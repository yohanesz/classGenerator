package com.yohanesz;

import static com.yohanesz.Model.optionLanguage.JAVA;
import static com.yohanesz.Model.optionLanguage.PYTHON;

import com.yohanesz.Model.Generator;
import com.yohanesz.Model.Modifier;
import com.yohanesz.Model.Type;

public class Main {

    public static void main(String[] args) {
    
        Generator gn = new Generator(JAVA);

        gn.setDirectory("demo/src/main/java/com/yohanesz/generatedClasses");
        gn.createClass("primeiroTeste", Modifier.PRIVATE);
        gn.addAttribute(Modifier.PRIVATE, Type.INTEGER, "num1");
        gn.addAttribute(Modifier.PRIVATE, Type.STRING, "num2");
        gn.addAttribute(Modifier.DEFAULT, Type.BOOLEAN, "num3");
        gn.addAttribute(Modifier.PUBLIC, Type.BOOLEAN, "num4");
        gn.addMethod(Modifier.PUBLIC, Type.BOOLEAN, "firstMethod");
        gn.addMethod(Modifier.PUBLIC, Type.BOOLEAN, "secondMethod");
        gn.addMethod(Modifier.PUBLIC, Type.BOOLEAN, "thirdMethod");
        gn.generateClass();
        
    }

    
}
