package com.transactionanalyser.mappers;

import com.transactionanalyser.entities.Transaction;
import com.transactionanalyser.loaders.FileLoader;

import java.io.File;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class TransactionMapper implements EntityMapper {

    @Override
    public List<Transaction> map(FileLoader fileLoader) throws ParseException {
        List<Transaction> transactions = new ArrayList<Transaction>();
        while(fileLoader.hasNextRecord()) {
            Iterator<String> recordIterator = fileLoader.nextRecord().iterator();
            Transaction transaction = new Transaction();
            transaction.setId(recordIterator.next().trim());
            String strTransDate = recordIterator.next().trim();
            SimpleDateFormat sFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
            Date transDate = sFormat.parse(strTransDate);
            transaction.setTransactionDate(transDate);
            transaction.setAmount(Double.parseDouble(recordIterator.next()));
            transaction.setMerchant(recordIterator.next().trim());
            transaction.setType(recordIterator.next().trim());
            transaction.setRelatedTransaction(recordIterator.next().trim());
            transactions.add(transaction);
        }
        return transactions;
    }
}

