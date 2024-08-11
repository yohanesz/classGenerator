package com.yohanesz.Model;

import java.io.File;
import java.util.HashMap;


public interface classInterface {

    void setDirectory(String directory);
    void createClass(String name, Modifier modifier);
    File createFile();
    void generateClass();
    void generateAttribute();
    void generateMethod();
    void generateConstructor();
    void addAttribute(Modifier modifier, Type type, String name);
    void addMethod(Modifier modifier, Type type, String name);

    // T generateClass(String name, StringBuilder sb);
    // void generateClass(String name);
    // void addModifier(Modifier modifier);
    // void generateAttribute(String attribute, Type type, Modifier modifier);
    // void generateMethod(String name, Type typeOfReturn, Modifier modifier);
    // void generateConstructor(String[] attributes);

  


    
}
