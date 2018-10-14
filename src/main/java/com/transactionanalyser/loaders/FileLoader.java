package com.transactionanalyser.loaders;

import com.transactionanalyser.mappers.EntityMapper;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.Serializable;
import java.util.List;

public interface FileLoader {
    boolean hasNextRecord();
    Iterable<String> nextRecord();
}
