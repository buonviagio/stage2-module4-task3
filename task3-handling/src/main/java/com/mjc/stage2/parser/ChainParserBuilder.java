package com.mjc.stage2.parser;

import java.util.ArrayList;
import java.util.List;

public class ChainParserBuilder {
    private List<AbstractTextParser> parsers = new ArrayList<>();

    public ChainParserBuilder() {
    }

    public ChainParserBuilder setParser(AbstractTextParser abstractTextParser) {
        // Write your code here!
        parsers.add(abstractTextParser);
        return this;
    }

    public AbstractTextParser build() {
        for (int i = 1; i < parsers.size(); i++) {
            AbstractTextParser parser = parsers.get(i - 1);
            parser.setNextParser(parsers.get(i));
        }
        return parsers.get(0);
    }
}
