package com.yohanesz.Model;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class pythonClass implements classInterface {

    private StringBuilder sb = new StringBuilder();
    private Class clazz;

    public pythonClass(Class clazz) {
        this.clazz = clazz;
    }

    public void generateClass(File file) {
        sb.append("class ")
          .append(clazz.getClassName())
          .append(":\n\n");

        generateConstructor();
        generateAttribute();
        generateGettersAndSetters();
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
            sb.append(", ").append(formatName(attribute.getAttributeName(), attribute.getModifier()));
        }
        sb.append("):\n");

        for (Attribute attribute : attributes) {
            sb.append("        self.")
              .append(formatName(attribute.getAttributeName(), attribute.getModifier()))
              .append(" = ")
              .append(formatName(attribute.getAttributeName(), attribute.getModifier()))
              .append("\n");
        }
        sb.append("\n");
    }

    public void generateMethod() {
        ArrayList<Method> methods = clazz.getMethods();
        for (Method method : methods) {
            sb.append("    def ")
              .append(formatName(method.getMethodName(), method.getModifier()))
              .append("(self):\n")
              .append("        pass\n\n");
        }
    }

    public void generateGettersAndSetters() {
        ArrayList<Attribute> attributes = clazz.getAttributes();

        for (Attribute attribute : attributes) {
            String attributeName = formatName(attribute.getAttributeName(), attribute.getModifier());
            String methodName = capitalize(attribute.getAttributeName());

            // Getter
            sb.append("    def get_")
              .append(methodName)
              .append("(self):\n")
              .append("        return self.")
              .append(attributeName)
              .append("\n\n");

            // Setter
            sb.append("    def set_")
              .append(methodName)
              .append("(self, value):\n")
              .append("        self.")
              .append(attributeName)
              .append(" = value\n\n");
        }
    }

    private String formatName(String name, String modifier) {
        
        switch (modifier.toLowerCase()) {
            case "private ":
                return "__" + name;  // Dois underlines para atributos privados
            case "protected ":
                return "_" + name;   // Um underline para atributos protegidos
            default:
                return "" + name;  // Nenhuma alteração para atributos públicos
        }
    }

    private String capitalize(String name) {
        if (name == null || name.isEmpty()) {
            return name;
        }
        return name.substring(0, 1).toUpperCase() + name.substring(1);
    }

    public void generateConstructor() {
        sb.append("    def __init__(self):\n");
        sb.append("        pass\n\n");
    }
}
