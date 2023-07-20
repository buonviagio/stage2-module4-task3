package com.mjc.stage2.parser;


import com.mjc.stage2.entity.AbstractTextComponent;
import com.mjc.stage2.entity.SymbolLeaf;
import com.mjc.stage2.entity.TextComponent;
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
        TextComponent textComponent = new TextComponent(TextComponentType.SYMBOL);
        SymbolLeaf sl;

        String tmp;
        while (matcher.find()) {
            tmp = matcher.group();
            sl = new SymbolLeaf(TextComponentType.SYMBOL);
            char c = tmp.charAt(0);
            sl.setChar(c);
            abstractTextComponent.add(sl);
        }
    }
}
