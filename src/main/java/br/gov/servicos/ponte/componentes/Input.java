package br.gov.servicos.ponte.componentes;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Wither;

@Data
@Wither
@AllArgsConstructor
@NoArgsConstructor
public class Input implements Componente {
    String label;
    String name;
    String value;

    @Override
    public String getType() {
        return "input";
    }
}
