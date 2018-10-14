package com.transactionanalyser.mappers;

import com.transactionanalyser.entities.Transaction;
import com.transactionanalyser.loaders.CSVFileLoader;
import com.transactionanalyser.loaders.FileLoader;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import static org.junit.jupiter.api.Assertions.fail;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class TransactionMapperTest {

    FileLoader fileLoader;
    TransactionMapper mapper;

    @BeforeEach
    public void init(){
        mapper = new TransactionMapper();
    }

    @Test
    public void testMap() {
        CSVFileLoader fileLoader = mock(CSVFileLoader.class);
        List<String> record = Arrays.asList(new String[] {
                "WLMFRDGD", "20/08/2018 12:45:33", "59.99", "Kwik-E-Mart", "PAYMENT",""
        });
        Iterable<String> itr = record;
        when(fileLoader.hasNextRecord()).thenReturn(true, false);
        when(fileLoader.nextRecord()).thenReturn(itr);
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
            Transaction  t = new Transaction("WLMFRDGD", sdf.parse("20/08/2018 12:45:33"), 59.99, "Kwik-E-Mart", "PAYMENT","");
            List<Transaction> result = mapper.map(fileLoader);
            Assertions.assertEquals(1, result.size(), "Error in list size");
            Assertions.assertEquals(result.get(0), t);
        } catch (ParseException e) {
            fail("No exception is expected");
        }

    }
}
