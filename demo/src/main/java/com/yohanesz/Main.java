package com.yohanesz;

import static com.yohanesz.Model.Modifier.DEFAULT;
import static com.yohanesz.Model.Modifier.PRIVATE;
import static com.yohanesz.Model.Modifier.PUBLIC;
import static com.yohanesz.Model.Type.BOOLEAN;
import static com.yohanesz.Model.Type.INTEGER;
import static com.yohanesz.Model.Type.STRING;
import static com.yohanesz.Model.optionLanguage.JAVA;
import static com.yohanesz.Model.optionLanguage.PYTHON;

import com.yohanesz.Model.Generator;
import com.yohanesz.Model.Modifier;


public class Main {

    public static void main(String[] args) {
    
        Generator gn = new Generator(PYTHON);

        gn.startClass("primeiroTeste", PUBLIC); 
        gn.createFile("demo/src/main/java/com/yohanesz").addAttribute(PRIVATE, INTEGER, "num1")
        .addAttribute(PRIVATE, STRING, "num2")
        .addAttribute(DEFAULT, BOOLEAN, "num3")
        .addAttribute(PUBLIC, BOOLEAN, "num4")
        .addMethod(PRIVATE, BOOLEAN, "firstMethod")
        .addMethod(PUBLIC, BOOLEAN, "secondMethod")
        .addMethod(PUBLIC, BOOLEAN, "thirdMethod")
        .generateClass();
    }

    
}
