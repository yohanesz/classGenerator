package com.yohanesz.Model;

import com.yohanesz.languages.javaClass;
import com.yohanesz.languages.pythonClass;

import static com.yohanesz.Model.optionLanguage.*;

import java.io.File;

public class Generator {

    private classInterface cInterface;
    private String directory;
    private Class clazz;
    private File file;

    public Generator(optionLanguage language) {
        this.clazz = new Class();

        switch (language) {
            case JAVA:
                cInterface = new javaClass(clazz);
                break;
            case PYTHON:
                cInterface = new pythonClass(clazz);
                break;
            default:
                throw new IllegalArgumentException("Linguagem não suportada: " + language);
        }
    }

    public void createFile(String directory) {
        File file = new File(directory + "/" + clazz.getClassName() + ".java");
        this.file = file;
    }

    public Generator startClass(String name, Modifier modifier) {
        clazz.setClassName(name);
        clazz.setClassModifier(modifier.getModifierName());
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

    public void setDirectory(String directory) {
        this.directory = directory;
    }

    public void createClass(String nome, Modifier modifier) {
        cInterface.createClass(nome, modifier);
    }

    public void generateClass(File file) {
       
        cInterface.generateClass(file);
        cInterface.generateAttribute();
    }
    
}
    
    
