package br.gov.servicos.ponte.componentes;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.experimental.Wither;

import java.util.List;

@Data
@Wither
@AllArgsConstructor
public class Tabela extends Componente {
    List<String> colunas;

    public Tabela() {
        type = "tabela";
        colunas = null;
    }
}
