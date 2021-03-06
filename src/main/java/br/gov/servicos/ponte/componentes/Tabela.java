package br.gov.servicos.ponte.componentes;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Wither;

import java.util.ArrayList;
import java.util.List;

@Data
@Wither
@AllArgsConstructor
public class Tabela implements Componente {
    List<ChaveValor> items = new ArrayList<>();

    @Override
    public String getType() {
        return "tabela";
    }
}
