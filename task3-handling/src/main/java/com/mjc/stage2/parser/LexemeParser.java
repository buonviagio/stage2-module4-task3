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

    // Write your code here!

    public LexemeParser(AbstractTextParser nextParser) {
        super(nextParser);
    }


    public LexemeParser() {
    }

    @Override
    public void parse(AbstractTextComponent abstractTextComponent, String string) {
        String[] parts = string.split(LEXEME_REGEX);
        Pattern pattern = Pattern.compile(WORD_REGEX);
        Matcher matcher = pattern.matcher(string);
        SymbolLeaf symbolLeaf;

        for (String str : parts) {

            if (matcher.find()) {
                System.out.println(str);
                nextParser.parse(abstractTextComponent, str);
            } else {
                char ch = string.charAt(0);
                symbolLeaf = new SymbolLeaf(TextComponentType.SYMBOL);
                symbolLeaf.setChar(ch);
                abstractTextComponent.add(symbolLeaf);
            }
        }
    }
}
