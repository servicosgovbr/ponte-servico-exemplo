package br.gov.spu.darf;

import br.gov.servicos.ponte.PonteApp;
import lombok.extern.slf4j.Slf4j;

import java.util.Map;

@Slf4j
public class EmissaoDARFController implements PonteApp {

    @Override
    public void index() {
        log.info("Iniciando emissão de darf");
    }

    @Override
    public void action(String action, Map<String, String> params) {
        log.info("Ação para emissão de darf" + params);
    }

}
