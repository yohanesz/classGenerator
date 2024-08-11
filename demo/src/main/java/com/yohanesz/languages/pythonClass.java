package com.yohanesz.languages;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import com.yohanesz.Model.Attribute;
import com.yohanesz.Model.Class;
import com.yohanesz.Model.Method;
import com.yohanesz.Model.Modifier;
import com.yohanesz.Model.Type;
import com.yohanesz.Model.classInterface;

public class pythonClass implements classInterface {

    private StringBuilder sb = new StringBuilder();
    private String directory;
    private Class clazz;

    public pythonClass() {
        this.clazz = new Class();
    }

    public void setDirectory(String directory) {
        this.directory = directory;
    }

    public void createClass(String name, Modifier modifier) {
        clazz.setClassName(name);
        clazz.setClassModifier(modifier.getModifierName());
    }

    public File createFile() {
        File file = new File(directory + "/" + clazz.getClassName() + ".py");
        return file;
    }

    public void generateClass() {

        File file = createFile();
        sb.append("class ")
          .append(clazz.getClassName())
          .append(":\n\n");

        generateConstructor();
        generateAttribute(); 
        generateMethod();   

        try (FileWriter writer = new FileWriter(file)) {
            writer.write(sb.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void generateAttribute() {
        ArrayList<Attribute> attributes = clazz.getAttributes();
        sb.append("    def __init__(self");
        for (Attribute attribute : attributes) {
            sb.append(", ").append(attribute.getAttributeName());
        }
        sb.append("):\n");

        for (Attribute attribute : attributes) {
            sb.append("        self.")
              .append(attribute.getAttributeName())
              .append(" = ")
              .append(attribute.getAttributeName())
              .append("\n");
        }
        sb.append("\n");
    }

    public void generateMethod() {
        ArrayList<Method> methods = clazz.getMethods();
        for (Method method : methods) {
            sb.append("    def ")
              .append(method.getMethodName())
              .append("(self):\n")
              .append("        pass\n\n");
        }
    }

    public void addAttribute(Modifier modifier, Type type, String name) {
        Attribute atr = new Attribute(modifier.getModifierName(), type.getTypeName(), name);
        clazz.addAttribute(atr);
    }

    public void addMethod(Modifier modifier, Type type, String name) {
        Method mtd = new Method(modifier.getModifierName(), type.getTypeName(), name);
        clazz.addMethod(mtd);
    }

    public void generateConstructor() {
        // A lógica de construção do método construtor foi movida para generateAttributes
        // pois em Python o construtor é definido junto com os atributos na função __init__
    }

  
}
