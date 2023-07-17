package com.mjc.stage2.entity;

public class SymbolLeaf extends AbstractTextComponent {

    private char value;

    // Write your code here!

    //14.7
    public void setChar(char c) {
        value = c;
    }

    //14.7
    public char getChar() {
        return value;
    }

    public SymbolLeaf(TextComponentType componentType) {
        super(componentType);
    }

    @Override
    public String operation() {
        return Character.toString(value);
    }

    @Override
    public void add(AbstractTextComponent textComponent) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void remove(AbstractTextComponent textComponent) {
        throw new UnsupportedOperationException();
    }

    @Override
    public int getSize() {
        throw new UnsupportedOperationException();
    }
}
