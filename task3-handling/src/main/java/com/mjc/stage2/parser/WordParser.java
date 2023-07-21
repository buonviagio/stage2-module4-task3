package com.mjc.stage2.parser;


import com.mjc.stage2.entity.AbstractTextComponent;
import com.mjc.stage2.entity.SymbolLeaf;
import com.mjc.stage2.entity.TextComponent;
import com.mjc.stage2.entity.TextComponentType;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class WordParser extends AbstractTextParser {
    // Write your code here!

    public WordParser(AbstractTextParser nextParser) {
        super(nextParser);
    }
    @Override
    public void parse(AbstractTextComponent abstractTextComponent, String string) {
        SymbolLeaf symbolLeaf;
        TextComponent textComponent;
        String[] symbols = string.split(TextComponentType.SYMBOL.getDelimiter());
        textComponent = new TextComponent(TextComponentType.WORD);
        abstractTextComponent.add(textComponent);

        for (String symbol : symbols) {
            char ch = symbol.charAt(0);
            symbolLeaf = new SymbolLeaf(TextComponentType.WORD);
            symbolLeaf.setChar(ch);
            textComponent.add(symbolLeaf);
        }
        /*
        Pattern pattern = Pattern.compile(WORD_REGEX);
        Matcher matcher = pattern.matcher(string);
        SymbolLeaf symbolLeaf;
        TextComponent textComponent;
        if (matcher.find()) {
            String[] symbols = string.split(TextComponentType.SYMBOL.getDelimiter());
            textComponent = new TextComponent(TextComponentType.WORD);
            abstractTextComponent.add(textComponent);

            for (String symbol : symbols) {
                char ch = symbol.charAt(0);
                symbolLeaf = new SymbolLeaf(TextComponentType.WORD);
                symbolLeaf.setChar(ch);
                textComponent.add(symbolLeaf);
            }
        } else {
            textComponent = new TextComponent(TextComponentType.SYMBOL);
            abstractTextComponent.add(textComponent);
            char ch = string.charAt(0);
            symbolLeaf = new SymbolLeaf(TextComponentType.SYMBOL);
            symbolLeaf.setChar(ch);
            textComponent.add(symbolLeaf);
        }
         */
    }
}
