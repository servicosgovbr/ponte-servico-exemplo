package br.gov.servicos.ponte.web;

import br.gov.servicos.ponte.componentes.Componente;
import lombok.AllArgsConstructor;
import lombok.Value;
import lombok.experimental.Wither;

import java.util.ArrayList;
import java.util.List;

@Value
@Wither
@AllArgsConstructor
public class RespostaPonte {
    String titulo;
    List<Componente> componentes;

    public RespostaPonte() {
        titulo = "";
        componentes = new ArrayList<>();
    }

    public RespostaPonte componente(Componente c) {
        componentes.add(c);
        return this;
    }
}