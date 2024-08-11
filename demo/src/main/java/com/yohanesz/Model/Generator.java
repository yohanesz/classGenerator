package com.yohanesz.Model;

import com.yohanesz.languages.javaClass;
import static com.yohanesz.Model.optionLanguage.*;
import com.yohanesz.Model.Modifier;
import com.yohanesz.Model.Type;

public class Generator {

    private classInterface cInterface;

    public Generator(optionLanguage language) {
        if (language == JAVA) {
            cInterface = new javaClass();
        } else if (language == PYTHON) {
            // cInterface = new pythonClass();
        } else {
            throw new IllegalArgumentException("Linguagem não suportada: " + language);
        }
    }

    public void createClass(String nome) {
        cInterface.createClass(nome);
    }

    public void addAttribute(Modifier modifier, Type type, String name){
       cInterface.addAttribute(modifier, type, name);
    }

    public void addMethod(Modifier modifier, Type type, String name){
       cInterface.addMethod(modifier, type, name);
    }

    public void generateClass() {
        cInterface.generateClass();
        cInterface.generateAttribute();
    }
    
}
    
    
