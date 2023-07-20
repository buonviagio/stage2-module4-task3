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

    @Override
    public void parse(AbstractTextComponent abstractTextComponent, String string) {
        String[] parts = string.split(LEXEME_REGEX);
        Pattern pattern = Pattern.compile(WORD_REGEX);
        SymbolLeaf sl;
        for (String str : parts) {
            //nextParser.parse(abstractTextComponent, str);
            Matcher matcher = pattern.matcher(str);

            if (matcher.find()) {
                String[] s = str.split(TextComponentType.SYMBOL.getDelimiter());
                TextComponent textComponent = new TextComponent(TextComponentType.WORD);
                abstractTextComponent.add(textComponent);

                for (String value : s) {
                    char ch = value.charAt(0);
                    sl = new SymbolLeaf(TextComponentType.WORD);
                    sl.setChar(ch);
                    textComponent.add(sl);
                    //abstractTextComponent.add(sl);
                }
            } else {
                TextComponent textComponent = new TextComponent(TextComponentType.WORD);
                abstractTextComponent.add(textComponent);
                char ch = str.charAt(0);
                sl = new SymbolLeaf(TextComponentType.SYMBOL);
                sl.setChar(ch);
                textComponent.add(sl);
            }
        }
    }
}
