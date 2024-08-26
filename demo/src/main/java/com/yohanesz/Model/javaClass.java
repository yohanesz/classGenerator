package com.yohanesz.Model;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class javaClass implements classInterface {

    private StringBuilder sb = new StringBuilder();
    private Class clazz;

    public javaClass(Class clazz) {
        this.clazz = clazz;
    }


    public void generateClass(File file) {
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

    public void generateConstructor() {
        sb.append("\n    public ").append(clazz.getClassName()).append("() {\n");
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
