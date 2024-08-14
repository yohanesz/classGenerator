package com.yohanesz.Model;

import com.yohanesz.languages.javaClass;
import com.yohanesz.languages.pythonClass;

import java.io.File;

public class Generator {

    private classInterface cInterface;
    private Class clazz;
    private File file;
    private String ext;

    public Generator(optionLanguage language) {
        this.clazz = new Class();

        switch (language) {
            case JAVA:
                cInterface = new javaClass(clazz);
                ext = "java";
                break;
            case PYTHON:
                cInterface = new pythonClass(clazz);
                ext = "py";
                break;
            default:
                throw new IllegalArgumentException("Linguagem não suportada: " + language);
        }
    }


    public Generator startClass(String name, Modifier modifier) {
        clazz.setClassName(name);
        clazz.setClassModifier(modifier.getModifierName());
        return this;   
    }

    public Generator createFile(String directory) {
        File file = new File(directory + "/" + clazz.getClassName() + "." + ext);
        this.file = file;
        return this;
    }

    public Generator addAttribute(Modifier modifier, Type type, String name) {
        Attribute atr = new Attribute(modifier.getModifierName(), type.getTypeName(), name);
        clazz.addAttribute(atr);
        return this;
    }

    public Generator addMethod(Modifier modifier, Type type, String name) {
        Method mtd = new Method(modifier.getModifierName(), type.getTypeName(), name);
        clazz.addMethod(mtd);
        return this;
    }

    public void generateClass() {
        cInterface.generateClass(file);
    }
    
}
    
    
