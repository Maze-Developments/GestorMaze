/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Klayton Massango
 */
public class Produto {
    private int id_produto;
    private String pro_nome;
    private String pro_categoria;
    private int pro_quantidade;
    private double pro_preco;

    public int getId_produto() {
        return id_produto;
    }

    public void setId_produto(int id_produto) {
        this.id_produto = id_produto;
    }

    public String getPro_nome() {
        return pro_nome;
    }

    public void setPro_nome(String pro_nome) {
        this.pro_nome = pro_nome;
    }

    public String getPro_categoria() {
        return pro_categoria;
    }

    public void setPro_categoria(String pro_categoria) {
        this.pro_categoria = pro_categoria;
    }

    public int getPro_quantidade() {
        return pro_quantidade;
    }

    public void setPro_quantidade(int pro_quantidade) {
        this.pro_quantidade = pro_quantidade;
    }

    public double getPro_preco() {
        return pro_preco;
    }

    public void setPro_preco(double pro_preco) {
        this.pro_preco = pro_preco;
    }
    
   
}
