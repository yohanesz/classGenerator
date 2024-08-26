package com.yohanesz.Model;

import java.util.ArrayList;

/**
 * Representa uma classe utilizada pelo Generator que armazena informações sobre uma classe de código a ser gerada.
 * <p>
 * A classe {@code Class} é usada através do Generator para definir o nome, modificador, atributos e métodos de uma classe. 
 * Essas informações são essenciais para gerar classes em diferentes linguagens de programação. 
 * </p>

 */
public class Class {

    /** Modificador da classe (ex: public, private) */
    private String classModifier;

    /** Nome da classe */
    private String className;

    /** Lista de atributos da classe */
    private ArrayList<Attribute> attributes = new ArrayList<>();

    /** Lista de métodos da classe */
    private ArrayList<Method> methods = new ArrayList<>();

    /**
     * Retorna o nome da classe.
     *
     * @return o nome da classe
     */
    public String getClassName() {
        return className;
    }

    /**
     * Define o nome da classe.
     *
     * @param className o nome da classe
     */
    public void setClassName(String className) {
        this.className = className;
    }

    /**
     * Retorna a lista de atributos da classe.
     *
     * @return a lista de atributos
     */
    public ArrayList<Attribute> getAttributes() {
        return attributes;
    }

    /**
     * Define a lista de atributos da classe.
     *
     * @param attributes a lista de atributos
     */
    public void setAttributes(ArrayList<Attribute> attributes) {
        this.attributes = attributes;
    }

    /**
     * Retorna a lista de métodos da classe.
     *
     * @return a lista de métodos
     */
    public ArrayList<Method> getMethods() {
        return methods;
    }

    /**
     * Define a lista de métodos da classe.
     *
     * @param methods a lista de métodos
     */
    public void setMethods(ArrayList<Method> methods) {
        this.methods = methods;
    }

    /**
     * Adiciona um atributo à lista de atributos da classe.
     *
     * @param atr o atributo a ser adicionado
     */
    public void addAttribute(Attribute atr) {
        attributes.add(atr);
    }

    /**
     * Adiciona um método à lista de métodos da classe.
     *
     * @param mtd o método a ser adicionado
     */
    public void addMethod(Method mtd) {
        methods.add(mtd);
    }

    /**
     * Retorna o modificador da classe.
     *
     * @return o modificador da classe
     */
    public String getClassModifier() {
        return classModifier;
    }

    /**
     * Define o modificador da classe.
     *
     * @param classModifier o modificador da classe
     */
    public void setClassModifier(String classModifier) {
        this.classModifier = classModifier;
    }
}
