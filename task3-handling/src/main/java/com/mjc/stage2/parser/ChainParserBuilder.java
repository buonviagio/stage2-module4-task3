package com.mjc.stage2.parser;

import java.util.ArrayList;
import java.util.List;

public class ChainParserBuilder {
    private List<AbstractTextParser> parsers = new ArrayList<>();

    public ChainParserBuilder() {
    }

    public ChainParserBuilder setParser(AbstractTextParser abstractTextParser) {
        // Write your code here!

        return this;
    }

    public AbstractTextParser build() {
        // Write your code here!
        return new WordParser(new LexemeParser(null));
    }
}
