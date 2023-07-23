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
        TextComponent textComponent;
        AbstractTextComponent abstractTextComponent;
        for (int i = 0; i < size; i++) {
            //textComponent = (TextComponent) componentList.get(i);
            abstractTextComponent = componentList.get(i);
            if (abstractTextComponent instanceof SymbolLeaf){
                SymbolLeaf symbolLeaf = (SymbolLeaf) abstractTextComponent;
                stringBuilder.append(symbolLeaf.getChar());
            } else {
                textComponent = (TextComponent) abstractTextComponent;
                for (AbstractTextComponent com : textComponent.componentList) {
                    SymbolLeaf symbolLeaf = (SymbolLeaf) com;
                    stringBuilder.append(symbolLeaf.getChar());
                }
            }
            stringBuilder.append(" ");
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
