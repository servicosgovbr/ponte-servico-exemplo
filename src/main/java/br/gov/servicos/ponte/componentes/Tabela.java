package br.gov.servicos.ponte.componentes;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Wither;

import java.util.List;

@Data
@Wither
@AllArgsConstructor
@NoArgsConstructor
public class Tabela implements Componente {
    List<String> colunas;

    @Override
    public String getType() {
        return "tabela";
    }
}
