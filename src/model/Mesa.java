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
public class Mesa {
    private String msa_nome;
    private int msa_id;

    public int getMsa_id() {
        return msa_id;
    }

    public void setMsa_id(int msa_id) {
        this.msa_id = msa_id;
    }

    public String getMsa_nome() {
        return msa_nome;
    }

    public void setMsa_nome(String msa_nome) {
        this.msa_nome = msa_nome;
    }
    
    @Override
    public String toString(){
        return this.getMsa_nome();
    }
    
}
