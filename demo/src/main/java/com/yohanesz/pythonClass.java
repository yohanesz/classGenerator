package com.yohanesz;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;

public class pythonClass implements classInterface<pythonClass>{

    String extension = getClass().getSimpleName();
    

    public void createClass(String name) {
        File file = new File(directory + "/" + name + ".py");
        StringBuilder sb = new StringBuilder();
        sb.append("class ").append(name).append(":").append("\n\n");

        try (FileWriter writer = new FileWriter(file)) {
            writer.write(sb.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    @Override
    public File createFile(String name) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'createFile'");
    }


    @Override
    public pythonClass generateClass(String name) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'generateClass'");
    }


    @Override
    public pythonClass addModifier(Modifier modifier) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'addModifier'");
    }


    @Override
    public pythonClass generateAttribute(String attribute, Type type, Modifier modifier) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'generateAttribute'");
    }


    @Override
    public pythonClass generateMethod(String method) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'generateMethod'");
    }


    @Override
    public pythonClass generateConstructor(String[] attributes) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'generateConstructor'");
    }



}
p