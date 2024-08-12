package com.yohanesz.Model;

public enum Modifier {
    
    PRIVATE("private "),
    PUBLIC("public "),
    PROTECTED("protected "),
    DEFAULT(""), // Representa o modificador de acesso padrão (package-private)
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
