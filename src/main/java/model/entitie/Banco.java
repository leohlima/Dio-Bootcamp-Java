package model.entitie;

import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class Banco {
    private String name;
    private Cliente cliente;

    public Banco(String name, Cliente cliente){
        this.name = name;
        this.cliente = cliente;
    }

    public List<Cliente> clienteList = new ArrayList<>();

    public void AddCliente(Cliente cliente){
        clienteList.add(cliente);
    }

}
