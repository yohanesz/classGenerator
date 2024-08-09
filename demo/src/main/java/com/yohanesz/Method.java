package com.yohanesz;

class Method {

    private String methodName;
    private Type returnType;
    private Modifier modifier;
    
    public Method(String methodName, Type returnType, Modifier modifier) {
        this.methodName = methodName;
        this.returnType = returnType;
        this.modifier = modifier;
    }

    public String getMethodName() {
        return methodName;
    }

    public void setMethodName(String methodName) {
        this.methodName = methodName;
    }

    public Type getReturnType() {
        return returnType;
    }

    public void setReturnType(Type returnType) {
        this.returnType = returnType;
    }

    public Modifier getModifier() {
        return modifier;
    }

    public void setModifier(Modifier modifier) {
        this.modifier = modifier;
    }

    @Override
    public String toString() {
        return modifier.getModifierName() + " " + returnType.getTypeName() + " " + methodName + "();";
    }


    
}
