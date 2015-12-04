package br.gov.servicos.ponte.componentes;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Wither;

@Data
@Wither
@AllArgsConstructor
@NoArgsConstructor
public class ChaveValor implements Componente {
    String left;
    String right;

    @Override
    public String getType() {
        return "chave-valor";
    }
}
