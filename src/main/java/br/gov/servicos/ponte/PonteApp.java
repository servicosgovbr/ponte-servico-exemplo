package br.gov.servicos.ponte;

import java.util.Map;

public interface PonteApp {
    void index();
    void action(String action, Map<String, String> params);
}
