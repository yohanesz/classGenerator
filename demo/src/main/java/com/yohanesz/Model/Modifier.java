package com.yohanesz.Model;

public enum Modifier {
    
    PRIVATE("private "),
    PUBLIC("public "),
    PROTECTED("protected "),
    DEFAULT(""), 
    ABSTRACT("abstract "),
    STATIC("static ");

    private final String modifier;

    Modifier(String modifier) {
        this.modifier = modifier;
    }

    public String getModifierName() {
        return modifier;
    }
}
