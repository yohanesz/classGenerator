package com.yohanesz.Main;

import static com.yohanesz.Model.Modifier.*;
import static com.yohanesz.Model.Type.*;
import static com.yohanesz.Model.optionLanguage.*;
import com.yohanesz.Model.Generator;

public class Main {

    public static void main(String[] args) {
    
        Generator gn = new Generator(JAVA);

        gn.startClass("Carro", PUBLIC)
        .addAttribute(PRIVATE, STRING, "modelo").addAttribute(PRIVATE, INTEGER, "ano")
        .addAttribute(PRIVATE, STRING, "cor")
        .addAttribute(PRIVATE, DOUBLE, "preco")
        .addMethod(PUBLIC, BOOLEAN, "iniciarMotor")
        .addMethod(PUBLIC, BOOLEAN, "acelerar")
        .addMethod(PUBLIC, BOOLEAN, "frear")
        .createFile("demo/src/main/java/com/yohanesz")
        .generateClass();

    }

    
}
