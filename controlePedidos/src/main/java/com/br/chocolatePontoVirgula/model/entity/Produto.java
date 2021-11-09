package com.br.chocolatePontoVirgula.model.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int codigo;

    private String descricao;
    private String unidadeMedida;
    private double valorUnitario;
    private boolean status;


    public String Status() {
        if (status) {
            return "Ativo";
        } else {
            return "Inativo";
        }
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Produto{" +
                "codigo=" + codigo +
                ", descricao='" + descricao + '\'' +
                ", unidadeMedida='" + unidadeMedida + '\'' +
                ", valorUnitario=" + valorUnitario +
                ", status=" + status +
                '}';
    }
}