package com.mjc.stage2.parser;


import com.mjc.stage2.entity.AbstractTextComponent;
import com.mjc.stage2.entity.TextComponentType;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class WordParser extends AbstractTextParser {
    // Write your code here!
    private static final String WORD_REGEX = "\\w[\\w!=?():]+";

    public WordParser(AbstractTextParser nextParser) {
        super(nextParser);
    }

    @Override
    public void parse(AbstractTextComponent abstractTextComponent, String string) {
        String [] array = string.split(TextComponentType.SENTENCE.getDelimiter());



        Pattern pattern = Pattern.compile(WORD_REGEX);
        Matcher matcher = pattern.matcher(string);
        while (matcher.find()){

        }
    }
}
