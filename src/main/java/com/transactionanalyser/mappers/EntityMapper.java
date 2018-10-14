package com.transactionanalyser.mappers;

import com.transactionanalyser.loaders.FileLoader;

import java.io.File;
import java.io.Serializable;
import java.text.ParseException;
import java.util.List;

public interface EntityMapper<E> {
    List<E> map(FileLoader fileLoader) throws ParseException;
}
