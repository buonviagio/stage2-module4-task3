package com.mjc.stage2.parser;


import com.mjc.stage2.entity.AbstractTextComponent;
import com.mjc.stage2.entity.SymbolLeaf;
import com.mjc.stage2.entity.TextComponentType;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class WordParser extends AbstractTextParser {
    // Write your code here!
    private static final String LETTER_REGEX = "\\W";

    public WordParser(AbstractTextParser nextParser) {
        super(nextParser);
    }

    @Override
    public void parse(AbstractTextComponent abstractTextComponent, String string) {

        Pattern pattern = Pattern.compile(LETTER_REGEX);
        Matcher matcher = pattern.matcher(string);
        SymbolLeaf sl = new SymbolLeaf(TextComponentType.SYMBOL);

        String tmp;
        while (matcher.find()) {
            tmp = matcher.group();
            sl.setChar(tmp.charAt(0));
            abstractTextComponent.add(sl);
            //System.out.println("WordParser ... " + tmp);
        }
    }
}
