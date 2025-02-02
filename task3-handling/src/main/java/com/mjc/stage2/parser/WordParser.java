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

        int length = string.length();
        char[] symbol = new char[length];
        string.getChars(0, length, symbol, 0);
        textComponent = new TextComponent(TextComponentType.WORD);
        abstractTextComponent.add(textComponent);
        for (char c : symbol) {
            symbolLeaf = new SymbolLeaf(TextComponentType.WORD);
            symbolLeaf.setChar(c);
            textComponent.add(symbolLeaf);
        }
    }
}
