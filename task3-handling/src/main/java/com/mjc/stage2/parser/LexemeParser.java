package com.mjc.stage2.parser;

import com.mjc.stage2.entity.AbstractTextComponent;
import com.mjc.stage2.entity.SymbolLeaf;
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

    @Override
    public void parse(AbstractTextComponent abstractTextComponent, String string) {
        String[] parts = string.split(LEXEME_REGEX);
        Pattern pattern = Pattern.compile(WORD_REGEX);
        SymbolLeaf sl;
        for (String str : parts) {
            nextParser.parse(abstractTextComponent, str);
            Matcher matcher = pattern.matcher(str);
            //sl = new SymbolLeaf(TextComponentType.WORD);

            if (matcher.find()) {
                //System.out.println(matcher.group());
                String[] s = str.split(TextComponentType.SYMBOL.getDelimiter());
                sl = new SymbolLeaf(TextComponentType.WORD);
                for (String value : s) {
                    sl.setChar(value.charAt(0));
                    abstractTextComponent.add(sl);
                }
            } else {
                //System.out.println("LETTER " + str);
                sl = new SymbolLeaf(TextComponentType.SYMBOL);
                sl.setChar(str.charAt(0));
                abstractTextComponent.add(sl);
            }
        }
    }
}
