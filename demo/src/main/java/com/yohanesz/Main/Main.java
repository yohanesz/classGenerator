package com.yohanesz.Main;

import static com.yohanesz.Model.Modifier.*;
import static com.yohanesz.Model.Type.*;
import static com.yohanesz.Model.optionLanguage.*;

import com.yohanesz.Model.Generator;

public class Main {

    public static void main(String[] args) {
    
        Generator gn = new Generator(PYTHON);

        gn.startClass("primeiroTeste", PUBLIC).addAttribute(PRIVATE, INTEGER, "num1")
        .addAttribute(PRIVATE, STRING, "num2")
        .addAttribute(PRIVATE, BOOLEAN, "num3")
        .addAttribute(PRIVATE, BOOLEAN, "num4")
        .addMethod(PRIVATE, BOOLEAN, "firstMethod")
        .addMethod(PUBLIC, BOOLEAN, "secondMethod")
        .addMethod(PUBLIC, BOOLEAN, "thirdMethod")
        .createFile("demo/src/main/java/com/yohanesz")
        .generateClass();
    }

    
}
