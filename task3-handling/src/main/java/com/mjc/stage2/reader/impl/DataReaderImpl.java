package com.mjc.stage2.reader.impl;

import com.mjc.stage2.entity.TextComponent;
import com.mjc.stage2.entity.TextComponentType;
import com.mjc.stage2.exception.HandlingException;
import com.mjc.stage2.parser.AbstractTextParser;
import com.mjc.stage2.parser.ChainParserBuilder;
import com.mjc.stage2.parser.LexemeParser;
import com.mjc.stage2.parser.WordParser;
import com.mjc.stage2.reader.DataReader;
import com.mjc.stage2.validator.impl.FileValidatorImpl;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class DataReaderImpl implements DataReader {

    @Override
    public String readFile(String path) throws HandlingException {
        FileValidatorImpl fileValidate = new FileValidatorImpl();
        if (!fileValidate.validateFilePath(path)) {
            throw new HandlingException("File is not exist or is empty or incorrect path");
        }
        List<String> lines;
        Path pathFile = Paths.get(path);
        try (Stream<String> lineStream = Files.lines(pathFile)) {
            lines = lineStream.collect(Collectors.toCollection(ArrayList::new));

        } catch (IOException e) {
            throw new HandlingException("Reading file is fail ", e);
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (String s : lines
                ) {
            stringBuilder.append(s).append("\n");
        }
        return stringBuilder.toString();
    }
    public static void main(String[] args) {
        String fileData;
        try {
            fileData = new DataReaderImpl().readFile("/Users/DimaHeinz/Desktop/test/stage2-module4-task3/task3-handling/src/main/resources/data/textdata.txt");
            System.out.println(fileData);
        } catch (HandlingException e) {
            throw new RuntimeException(e);
        }
        ChainParserBuilder chainParserBuilder = new ChainParserBuilder();
        chainParserBuilder.setParser(new LexemeParser());
        chainParserBuilder.setParser(new WordParser());

        AbstractTextParser abstractTextParser = chainParserBuilder.build();
        TextComponent textComponent = new TextComponent(TextComponentType.SENTENCE);
        abstractTextParser.parse(textComponent, fileData);
        System.out.println(textComponent.operation());
    }
}
