package com.yohanesz;
import java.io.File;
import java.util.HashMap;


public interface classInterface<T> {

    String directory = "/home/yohanes/Default/projetos.POO/classGenerator/demo/src/main/java/com/yohanesz/generatedClasses";

    File createFile(String name);
    // T generateClass(String name, StringBuilder sb);
    T generateClass(String name);
    T addModifier(Modifier modifier);
    T generateAttribute(String attribute, Type type, Modifier modifier);
    T generateMethod(String name, Type typeOfReturn, Modifier modifier);
    T generateConstructor(String[] attributes);
    
}
