package com.mjc.stage2.reader.impl;


import com.mjc.stage2.entity.AbstractTextComponent;
import com.mjc.stage2.entity.SymbolLeaf;
import com.mjc.stage2.entity.TextComponent;
import com.mjc.stage2.entity.TextComponentType;
import com.mjc.stage2.exception.HandlingException;
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
        try {
            String fileData = new DataReaderImpl().readFile("/Users/DimaHeinz/Desktop/test/stage2-module4-task3/task3-handling/src/main/resources/data/textdata.txt");
            System.out.println(fileData);
        } catch (HandlingException e) {
            throw new RuntimeException(e);
        }

        SymbolLeaf s1 = new SymbolLeaf(TextComponentType.SYMBOL);
        s1.setChar('g');
        AbstractTextComponent abstractTextComponent1 = new TextComponent(TextComponentType.SYMBOL);
        abstractTextComponent1.add(s1);

        SymbolLeaf s11 = new SymbolLeaf(TextComponentType.SENTENCE);
        s11.setChar('H');
        SymbolLeaf s12 = new SymbolLeaf(TextComponentType.SENTENCE);
        s12.setChar('E');
        SymbolLeaf s13 = new SymbolLeaf(TextComponentType.SENTENCE);
        s13.setChar('L');
        SymbolLeaf s14 = new SymbolLeaf(TextComponentType.SENTENCE);
        s14.setChar('L');
        SymbolLeaf s15 = new SymbolLeaf(TextComponentType.SENTENCE);
        s15.setChar('O');
        AbstractTextComponent abstractTextComponent2 = new TextComponent(TextComponentType.SENTENCE);
        abstractTextComponent2.add(s11);
        abstractTextComponent2.add(s12);
        abstractTextComponent2.add(s13);
        abstractTextComponent2.add(s14);
        abstractTextComponent2.add(s15);
        System.out.println(abstractTextComponent2.operation());


    }
}
