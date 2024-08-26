package com.yohanesz.Model;

import java.io.File;

/**
 * A classe {@code Generator} é responsável por gerar código fonte em diferentes linguagens.
 * <p>
 * Este exemplo mostra como usar a classe {@code Generator}:
 * <pre>
 * {@code
 * Generator generator = new Generator(optionLanguage.JAVA);
 * generator.startClass("MyClass", Modifier.PUBLIC)
 *         .addAttribute(Modifier.PRIVATE, Type.STRING, "name")
 *         .addMethod(Modifier.PUBLIC, Type.VOID, "printName")
 *         .createFile("src");
 * generator.generateClass();
 * }
 * </pre>
 * </p>
 */
public class Generator {

    private classInterface cInterface;
    private Class clazz;
    private File file;
    private String ext;

    /**
     * Construtor da classe Generator.
     * 
     * @param language Enum que define a linguagem de programação a ser utilizada para gerar a classe.
     * @throws IllegalArgumentException Se a linguagem especificada não for suportada.
     */
    public Generator(optionLanguage language) {
        this.clazz = new Class();

        switch (language) {
            case JAVA:
                cInterface = new javaClass(clazz);
                ext = "java";
                break;
            case PYTHON:
                cInterface = new pythonClass(clazz);
                ext = "py";
                break;
            default:
                throw new IllegalArgumentException("Linguagem não suportada: " + language);
        }
    }

    /**
     * Define o nome e o modificador de acesso da classe a ser gerada.
     * 
     * @param name Nome da classe.
     * @param modifier Modificador de acesso da classe.
     * @return A instância atual de Generator para encadeamento de métodos.
     */
    public Generator startClass(String name, Modifier modifier) {
        clazz.setClassName(name);
        clazz.setClassModifier(modifier.getModifierName());
        return this;   
    }

    /**
     * Cria o arquivo onde o código da classe gerada será salvo.
     * 
     * @param directory Diretório onde o arquivo será criado.
     * @return A instância atual de Generator para encadeamento de métodos.
     */
    public Generator createFile(String directory) {
        File file = new File(directory + "/" + clazz.getClassName() + "." + ext);
        this.file = file;
        return this;
    }

    /**
     * Adiciona um atributo à classe a ser gerada.
     * 
     * @param modifier Modificador de acesso do atributo.
     * @param type Tipo do atributo.
     * @param name Nome do atributo.
     * @return A instância atual de Generator para encadeamento de métodos.
     */
    public Generator addAttribute(Modifier modifier, Type type, String name) {
        Attribute atr = new Attribute(modifier.getModifierName(), type.getTypeName(), name);
        clazz.addAttribute(atr);
        return this;
    }

    /**
     * Adiciona um método à classe a ser gerada.
     * 
     * @param modifier Modificador de acesso do método.
     * @param type Tipo de retorno do método.
     * @param name Nome do método.
     * @return A instância atual de Generator para encadeamento de métodos.
     */
    public Generator addMethod(Modifier modifier, Type type, String name) {
        Method mtd = new Method(modifier.getModifierName(), type.getTypeName(), name);
        clazz.addMethod(mtd);
        return this;
    }

    /**
     * Gera o código da classe e o salva no arquivo especificado.
     */
    public void generateClass() {
        cInterface.generateClass(file);
    }
    
}
