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
    
  


    
}
