package com.transactionanalyser.loaders;

import com.transactionanalyser.mappers.EntityMapper;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class CSVFileLoader implements FileLoader {

    Iterable<CSVRecord> records;

    public CSVFileLoader(String location) throws FileNotFoundException, IOException {
        Reader in = new FileReader(location);
        records = CSVFormat.DEFAULT.withFirstRecordAsHeader().parse(in);
    }

    @Override
    public boolean hasNextRecord() {
        return records.iterator().hasNext();
    }

    @Override
    public Iterable<String> nextRecord() {
        return records.iterator().next();
    }
}
