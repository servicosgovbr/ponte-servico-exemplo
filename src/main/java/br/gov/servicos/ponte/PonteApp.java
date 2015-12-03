package br.gov.servicos.ponte;

import br.gov.servicos.ponte.web.RespostaPonte;

import java.util.Map;

public interface PonteApp {
    RespostaPonte action(String action, Map<String, String> params);
}
