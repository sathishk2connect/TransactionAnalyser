package com.transactionanalyser.executor;

import com.transactionanalyser.entities.Transaction;
import com.transactionanalyser.loaders.CSVFileLoader;
import com.transactionanalyser.loaders.FileLoader;
import com.transactionanalyser.mappers.EntityMapper;
import com.transactionanalyser.mappers.TransactionMapper;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.DoubleSummaryStatistics;
import java.util.List;
import java.util.stream.Collectors;

public class TransactionAnalyser {


    public static DoubleSummaryStatistics analyse(final List<Transaction> transactions, final Date fromDate, final Date toDate, final String merchant){
        List<String> reversalIds = transactions.stream()
                .filter(t -> t.getType().equals("REVERSAL"))
                .map(t -> t.getRelatedTransaction()).collect(Collectors.toList());
        DoubleSummaryStatistics summaryStatistics = transactions.stream()
                .filter(t -> t.getMerchant().equals(merchant)
                        && !t.getType().equals("REVERSAL")
                        && !reversalIds.contains(t.getId())
                        && t.getTransactionDate().after(fromDate)
                        && t.getTransactionDate().before(toDate))
                .mapToDouble(rs -> rs.getAmount()).summaryStatistics();
        return summaryStatistics;
    }

    public static void main(String[] args) throws FileNotFoundException, IOException, ParseException {
        if(args.length<4)
            throw new IllegalArgumentException("Call the class in format classname <filelocation> <fromDate> <toDate> <merchant>");

        String location = args[0];
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        Date fromDate = null, toDate = null;
        fromDate = simpleDateFormat.parse(args[1]);
        toDate = simpleDateFormat.parse(args[2]);
        String merchant = args[3];
        FileLoader fileLoader = new CSVFileLoader(location);
        EntityMapper transactionMapper = new TransactionMapper();
        List<Transaction> transactions = transactionMapper.map(fileLoader);
        DoubleSummaryStatistics results = analyse(transactions, fromDate, toDate, merchant);
        System.out.println("Number of transactions = " + results.getCount());
        System.out.println("Average Transaction Value = " + results.getAverage());
    }
}
