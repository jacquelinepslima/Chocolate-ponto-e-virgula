package com.br.chocolatePontoVirgula.model.dto;

import javax.persistence.CascadeType;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import com.br.chocolatePontoVirgula.model.entity.Cliente;
import com.br.chocolatePontoVirgula.model.entity.Pedido;
import lombok.Getter;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Getter
public class PedidosDTO {
    private Long id;
    private String nome;
    private String enderecoEntrega;
    private boolean aberto;
    private double valorTotal;


    public PedidosDTO(Pedido pedido) {
        this.id = pedido.getId();
        this.nome=pedido.getCliente().getNome();
        this.enderecoEntrega = pedido.getEnderecoEntrega();
        this.aberto = pedido.isAberto();
        this.valorTotal=pedido.getValorTotal();
    }

    public static List<PedidosDTO> converter(ResponseEntity<Page<Pedido>> pedidos){
        return pedidos.getBody().stream().map(PedidosDTO::new).collect(Collectors.toList());
    }
}