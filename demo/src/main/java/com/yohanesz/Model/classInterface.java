package com.yohanesz.Model;

import java.io.File;

/**
 * Interface para definir a geração de código de uma classe em diferentes linguagens.
 * <p>
 * Esta interface fornece métodos para gerar diferentes componentes de uma classe, incluindo
 * atributos, métodos, construtores e getters/setters. Implementações desta interface devem
 * fornecer a lógica específica para gerar o código em uma linguagem de programação específica.
 * </p>
 */
public interface classInterface {

    /**
     * Gera o código da classe e o salva em um arquivo.
     *
     * @param file o arquivo onde o código da classe será salvo
     */
    void generateClass(File file);

    /**
     * Gera o código para os atributos da classe.
     * <p>
     * Este método deve criar o código necessário para declarar os atributos da classe
     * de acordo com a linguagem de programação.
     * </p>
     */
    void generateAttribute();

    /**
     * Gera o código para os métodos da classe.
     * <p>
     * Este método deve criar o código necessário para definir os métodos da classe
     * de acordo com a linguagem de programação.
     * </p>
     */
    void generateMethod();

    /**
     * Gera o código para o construtor da classe.
     * <p>
     * Este método deve criar o código necessário para definir o construtor da classe
     * de acordo com a linguagem de programação.
     * </p>
     */
    void generateConstructor();

    /**
     * Gera o código para os métodos getters e setters da classe.
     * <p>
     * Este método deve criar o código necessário para definir os métodos getters e setters
     * para os atributos da classe de acordo com a linguagem de programação.
     * </p>
     */
    void generateGettersAndSetters();
}
