package com.mjc.stage2.parser;


import com.mjc.stage2.entity.AbstractTextComponent;
import com.mjc.stage2.entity.SymbolLeaf;
import com.mjc.stage2.entity.TextComponent;
import com.mjc.stage2.entity.TextComponentType;

public class WordParser extends AbstractTextParser {
    // Write your code here!

    public WordParser() {
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
    }
}
