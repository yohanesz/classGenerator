package com.yohanesz.Model;

public class Method {

    public Method(String modifier, String type, String methodName) {
        this.methodName = methodName;
        this.type = type;
        this.modifier = modifier;
    }

    private String methodName;
    private String type;
    private String modifier;

    public String getMethodName() {
        return methodName;
    }
    public void setMethodName(String methodName) {
        this.methodName = methodName;
    }
    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }
    public String getModifier() {
        return modifier;
    }
    public void setModifier(String modifier) {
        this.modifier = modifier;
    }
    
   
    

    
}
