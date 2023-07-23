package com.mjc.stage2.parser;

import com.mjc.stage2.entity.AbstractTextComponent;
import com.mjc.stage2.entity.SymbolLeaf;
import com.mjc.stage2.entity.TextComponent;
import com.mjc.stage2.entity.TextComponentType;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LexemeParser extends AbstractTextParser {
    private static final String LEXEME_REGEX = "\\s+";
    private static final String WORD_REGEX = "\\w[\\w!=?():]+";
    //private static final String WORD_REGEX = "\\w[\\w!=?():\\n]+";

    // Write your code here!

    public LexemeParser() {
    }

    @Override
    public void parse(AbstractTextComponent abstractTextComponent, String string) {
        String[] parts = string.split(LEXEME_REGEX);
        Pattern pattern = Pattern.compile(WORD_REGEX);
        Matcher matcher;
        SymbolLeaf symbolLeaf;

        for (String str : parts) {
            matcher = pattern.matcher(str);
            if (matcher.find()) {
                nextParser.parse(abstractTextComponent, str);
            } else {
                char ch = str.charAt(0);
                symbolLeaf = new SymbolLeaf(TextComponentType.SYMBOL);
                symbolLeaf.setChar(ch);
                abstractTextComponent.add(symbolLeaf);
            }
        }
    }
}
