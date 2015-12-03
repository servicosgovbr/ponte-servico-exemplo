package br.gov.servicos.ponte.componentes;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Wither;

@Data
@Wither
@AllArgsConstructor
@NoArgsConstructor
public class Button implements Componente {
    String text;
    String action;

    @Override
    public String getType() {
        return "submit";
    }
}
