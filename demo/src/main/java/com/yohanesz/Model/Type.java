package com.yohanesz.Model;

public enum Type {
    
    INTEGER("int"),
    STRING("String"),
    BOOLEAN("boolean"),
    FLOAT("float"),
    DOUBLE("double"),
    CHAR("char"),
    LONG("long"),
    SHORT("short"),
    BYTE("byte");

    private final String typeName;

    Type(String typeName) {
        this.typeName = typeName;
    }

    public String getTypeName() {
        return typeName;
    }

}