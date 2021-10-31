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
public class Vendas {
    private int id;
    private ItensVenda venda;
    private String vd_data;
    private double vd_total;
    private int inativo;

    public int getInativo() {
        return inativo;
    }

    public void setInativo(int inativo) {
        this.inativo = inativo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public ItensVenda getVenda() {
        return venda;
    }

    public void setVenda(ItensVenda venda) {
        this.venda = venda;
    }

    public String getVd_data() {
        return vd_data;
    }

    public void setVd_data(String vd_data) {
        this.vd_data = vd_data;
    }

    public double getVd_total() {
        return vd_total;
    }

    public void setVd_total(double vd_total) {
        this.vd_total = vd_total;
    }
    
}
