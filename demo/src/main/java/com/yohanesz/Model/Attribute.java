package com.yohanesz.Model;

public class Attribute {

    private String modifier;
    private String type;
    private String attributeName;

    public Attribute(String modifier, String type, String attributeName) {
        this.modifier = modifier;
        this.type = type;
        this.attributeName = attributeName;
    }

    public String getModifier() {
        return modifier;
    }

    public void setModifier(String modifier) {
        this.modifier = modifier;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getAttributeName() {
        return attributeName;
    }

    public void setAttributeName(String attributeName) {
        this.attributeName = attributeName;
    }

    
    
    
 
   
    
    
}
