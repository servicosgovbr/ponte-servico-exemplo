package br.gov.servicos.ponte.web;

import br.gov.servicos.ponte.PonteApp;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Wither;

@Data
@Wither
@NoArgsConstructor
@AllArgsConstructor
public class Sessao {
    String id;
    PonteApp app;
}