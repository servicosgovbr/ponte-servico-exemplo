package br.gov.servicos.ponte.componentes;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.experimental.Wither;

@Data
@Wither
@AllArgsConstructor
public class Input extends Componente {
    String label;
    String name;
    String value;

    public Input() {
        type = "input";
    }
}
