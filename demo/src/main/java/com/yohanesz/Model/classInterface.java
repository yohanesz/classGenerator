package com.yohanesz.Model;

import java.io.File;


public interface classInterface {

    void createClass(String name, Modifier modifier);
    void generateClass(File file);
    void generateAttribute();
    void generateMethod();
    void generateConstructor();
    // void addAttribute(Modifier modifier, Type type, String name);
    // void addMethod(Modifier modifier, Type type, String name);

  


    
}
