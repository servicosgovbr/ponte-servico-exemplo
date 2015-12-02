package br.gov.servicos.ponte.componentes;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.experimental.Wither;

@Data
@Wither
@AllArgsConstructor
public class Label extends Componente {
    String value;

    public Label() {
        type = "label";
        value = "";
    }
}
