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

public class javaClass implements classInterface {

    private StringBuilder sb = new StringBuilder();
    private String directory;
    private Class clazz;

    public javaClass() {
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
        File file = new File(directory + "/" + clazz.getClassName() + ".java");
        return file;
    }

    public void generateClass() {
        File file = createFile();
        sb.append(clazz.getClassModifier())
          .append("class ")
          .append(clazz.getClassName())
          .append(" {\n\n");
        
        generateAttribute();
        generateConstructor();
        generateGettersAndSetters();
        generateMethod();   

        sb.append("}\n");

        try (FileWriter writer = new FileWriter(file)) {
            writer.write(sb.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void generateAttribute() {
        ArrayList<Attribute> attributes = clazz.getAttributes();
        for (Attribute attribute : attributes) {
            sb.append("    ")
              .append(attribute.getModifier())
              .append(attribute.getType())
              .append(" ")
              .append(attribute.getAttributeName())
              .append(";\n");
        }
    }
    
    public void generateGettersAndSetters() {
        ArrayList<Attribute> attributes = clazz.getAttributes();
        for (Attribute attribute : attributes) {
            // Getter
            sb.append("\n")
              .append("    public ")
              .append(attribute.getType())
              .append(" get")
              .append(capitalize(attribute.getAttributeName()))
              .append("() {\n")
              .append("        return this.")
              .append(attribute.getAttributeName())
              .append(";\n")
              .append("    }\n");

            // Setter
            sb.append("\n")
              .append("    public void set")
              .append(capitalize(attribute.getAttributeName()))
              .append("(")
              .append(attribute.getType())
              .append(" ")
              .append(attribute.getAttributeName())
              .append(") {\n")
              .append("        this.")
              .append(attribute.getAttributeName())
              .append(" = ")
              .append(attribute.getAttributeName())
              .append(";\n")
              .append("    }\n");
        }
    }

    public void generateMethod() {
        sb.append("\n");
        ArrayList<Method> methods = clazz.getMethods();
        for (Method method : methods) {
            sb.append("    ")
              .append(method.getModifier())
              .append(method.getType())
              .append(" ")
              .append(method.getMethodName())
              .append("() {\n    // Implementação\n    }\n\n");
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
        sb.append("    public ").append(clazz.getClassName()).append("() {\n");
        sb.append("        // Construtor vazio\n");
        sb.append("    }\n\n");

        sb.append("    public ").append(clazz.getClassName()).append("(");
        
        ArrayList<Attribute> attributes = clazz.getAttributes();
        for (int i = 0; i < attributes.size(); i++) {
            Attribute attribute = attributes.get(i);
            sb.append(attribute.getType()).append(" ").append(attribute.getAttributeName());
            if (i < attributes.size() - 1) {
                sb.append(", ");
            }
        }
        sb.append(") {\n");

        for (Attribute attribute : attributes) {
            sb.append("        this.").append(attribute.getAttributeName()).append(" = ").append(attribute.getAttributeName()).append(";\n");
        }
        sb.append("    }\n\n");
    }

    private String capitalize(String str) {
        if (str == null || str.isEmpty()) {
            return str;
        }
        return str.substring(0, 1).toUpperCase() + str.substring(1);
    }
}
