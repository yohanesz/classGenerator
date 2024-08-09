package com.yohanesz;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;

public class javaClass implements classInterface<javaClass> {

    private String extension = getClass().getSimpleName();
    private StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        javaClass jc = new javaClass();

        File file = jc.createFile("NomeTeste2");
        jc.addModifier(Modifier.PRIVATE);
        jc.generateClass("classeTeste2").generateAttribute("num", Type.STRING, Modifier.PRIVATE).generateAttribute("nem2", Type.INTEGER, Modifier.PUBLIC);
        jc.generateMethod("metododeTeste", Type.STRING, Modifier.PUBLIC);
        jc.addParam("paramTeste", Type.STRING).addParam("outroParam", Type.INTEGER);
        System.out.println(jc.printBuilder());
    }

    public String printBuilder() {
        return sb.toString();
    }
    public javaClass addModifier(Modifier modifier) {
        sb.append(modifier).append(" ");
        return this;
    }

    public File createFile(String name) {
        return new File(directory + "/" + name + ".java");
    }

    @Override
    public javaClass generateClass(String name) {
        sb.append("class ").append(name).append(" {\n\n\n");
       return this;
    }

    @Override
    public javaClass generateAttribute(String attribute, Type type, Modifier modifier) {
        sb.append(modifier.getModifier()).append(" ").append(type.getTypeName()).append(" ").append(attribute).append(";\n");
        return this;
    }

    @Override
    public javaClass generateMethod(String name, Type typeOfReturn, Modifier modifier) {
        sb.append(modifier.getModifier()).append(" ").append(typeOfReturn.getTypeName()).append(" ").append(name).append("(){}\n");
        return this;
    }

    public javaClass addParam(String name, Type type) {
        
        sb.delete(sb.length () - 4, sb.length());
        sb.append(type.getTypeName()).append(" ").append(name).append(") {}");
        return this;
    }

    @Override
    public javaClass generateConstructor(String[] attributes) {
        return this;
    }
    


}

   
