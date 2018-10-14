package com.transactionanalyser.executor;

import com.transactionanalyser.entities.Transaction;
import com.transactionanalyser.executor.TransactionAnalyser;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import sun.java2d.pipe.SpanShapeRenderer;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.DoubleSummaryStatistics;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.fail;

public class TransactionAnalyserTest {

    static List<Transaction> transactionList;

    @BeforeAll
    static void init() {
        try
        {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        transactionList = Arrays.asList(
                new Transaction("WLMFRDGD", sdf.parse("20/08/2018 12:45:33"), 59.99, "Kwik-E-Mart", "PAYMENT",""),
                new Transaction("YGXKOEIA", sdf.parse("20/08/2018 12:46:17"), 10.95, "Kwik-E-Mart", "PAYMENT",""),
                new Transaction("LFVCTEYM", sdf.parse("20/08/2018 12:50:02"), 5.00, "MacLaren", "PAYMENT",""),
                new Transaction("SUOVOISP", sdf.parse("20/08/2018 13:12:22"), 5.00, "Kwik-E-Mart", "PAYMENT",""),
                new Transaction("AKNBVHMN", sdf.parse("20/08/2018 13:14:11"), 10.95, "Kwik-E-Mart", "REVERSAL", "YGXKOEIA"),
                new Transaction("JYAPKZFZ", sdf.parse("20/08/2018 14:07:10"), 99.50, "MacLaren", "PAYMENT",""));
        }catch (Exception ex){
            //Exception on parse
        }
    }

    @Test
    public void testAnalyseWithoutReversal()
    {
        try
        {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        DoubleSummaryStatistics results = TransactionAnalyser.analyse(transactionList,sdf.parse("20/08/2018 14:00:00"),
                sdf.parse("20/08/2018 14:10:00"),"MacLaren");
        assertEquals(results.getCount() , 1);
        assertEquals(results.getAverage(), 99.50);

        }catch (Exception ex){
            //Exception on parse
        }
    }

    @Test
    public void testAnalyseWithReversal()
    {
        try
        {
            if(transactionList== null)
                System.out.println("Transaction List is null");
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
            DoubleSummaryStatistics results = TransactionAnalyser.analyse(transactionList,sdf.parse("20/08/2018 12:00:00"),
                    sdf.parse("20/08/2018 13:00:00"),"Kwik-E-Mart");
            assertEquals(results.getCount() , 1);
            assertEquals(results.getAverage(), 59.99);

        }catch (Exception ex){
            //Exception on parse
            ex.printStackTrace();
        }
    }

}
