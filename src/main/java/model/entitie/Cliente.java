package model.entitie;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Cliente {
    private String name;
    private Conta tipoConta;
}
