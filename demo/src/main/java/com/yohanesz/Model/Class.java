package com.yohanesz.Model;

import java.util.ArrayList;

public class Class {

    private String classModifier;
    private String className;
    private ArrayList<Attribute> attributes = new ArrayList<>();
    private ArrayList<Method> methods = new ArrayList<>();

    public String getClassName() {
        return className;
    }
    public void setClassName(String className) {
        this.className = className;
    }
    public ArrayList<Attribute> getAttributes() {
        return attributes;
    }
    public void setAttributes(ArrayList<Attribute> attributes) {
        this.attributes = attributes;
    }
    public ArrayList<Method> getMethods() {
        return methods;
    }
    public void setMethods(ArrayList<Method> methods) {
        this.methods = methods;
    }

    public void addAttribute(Attribute atr) {
        attributes.add(atr);
    }

    public void addMethod(Method mtd) {
        methods.add(mtd);
    }

    public String getClassModifier() {
        return classModifier;
    }
    
    public void setClassModifier(String classModifier) {
        this.classModifier = classModifier;
    }


    


    
}
