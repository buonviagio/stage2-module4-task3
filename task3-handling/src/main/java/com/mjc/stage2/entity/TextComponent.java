package com.mjc.stage2.entity;

import java.util.ArrayList;
import java.util.List;

public class TextComponent extends AbstractTextComponent {
    protected List<AbstractTextComponent> componentList = new ArrayList<>();
    private int size = 0;

    public TextComponent(TextComponentType componentType) {
        super(componentType);
    }

    // Write your code here!
    @Override
    public String operation() {
        StringBuilder stringBuilder = new StringBuilder();
        for(int i = 0; i < size; i++){
            SymbolLeaf symbolLeaf = (SymbolLeaf)componentList.get(i);
            stringBuilder.append(symbolLeaf.getChar());
        }
        return stringBuilder.toString();
    }

    @Override
    public void add(AbstractTextComponent textComponent) {
        componentList.add(textComponent);
        size++;
    }

    @Override
    public void remove(AbstractTextComponent textComponent) {
        componentList.remove(textComponent);
    }

    @Override
    public int getSize() {
        return size;
    }
}
