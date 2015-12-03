package br.gov.spu.darf;

import br.gov.servicos.ponte.PonteApp;
import br.gov.servicos.ponte.componentes.Button;
import br.gov.servicos.ponte.componentes.Input;
import br.gov.servicos.ponte.web.RespostaPonte;
import lombok.extern.slf4j.Slf4j;

import java.util.Map;
import java.util.Optional;

@Slf4j
public class EmissaoDARFController implements PonteApp {

    private EmissaoDARFService service;

    public EmissaoDARFController() {
        this.service = new EmissaoDARFService(new RIPRepository());
    }

    @Override
    public RespostaPonte action(String action, Map<String, String> params) {
        log.info("Ação para emissão de darf " + action);
//        if (action != null) {
//            switch (action) {
//                case "consulta-rip":
//                    return consultaRip(params);
//                case "emitir-darf":
//                    return emitirDarf(params);
//            }
//        }
        return index();
    }

    private RespostaPonte index() {
        return resposta()
                .componente(new Input()
                        .withLabel("Número do RIP")
                        .withName("rip")
                        .withValue(""))
                .componente(new Button()
                        .withText("Consultar")
                        .withAction("consulta-rip"));
    }

//    private RespostaPonte consultaRip(Map<String, String> params) {
//        long rip = Long.parseLong(params.get("rip"));
//        Optional<RIP> consulta = service.consultaRIP(rip);
//
//        return null;
//    }

//    private RespostaPonte emitirDarf(Map<String, String> params) {
//        return null;
//    }

    private RespostaPonte resposta() {
        return new RespostaPonte()
                .withTitulo("DARF Patrimonial");
    }

}
