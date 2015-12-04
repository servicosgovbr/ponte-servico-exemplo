package br.gov.spu.darf;

import br.gov.servicos.ponte.PonteApp;
import br.gov.servicos.ponte.componentes.Button;
import br.gov.servicos.ponte.componentes.Componente;
import br.gov.servicos.ponte.componentes.Input;
import br.gov.servicos.ponte.componentes.Label;
import br.gov.servicos.ponte.web.RespostaPonte;
import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

@Slf4j
public class EmissaoDARFController implements PonteApp {

    private EmissaoDARFService service;

    public EmissaoDARFController() {
        this.service = new EmissaoDARFService(new RIPRepository());
    }

    @Override
    public RespostaPonte action(String action, Map<String, String> params) {
        log.info("Ação para emissão de darf " + action);
        if (action != null) {
            switch (action) {
                case "consulta-rip":
                    return consultaRip(params);
//                    case "emitir-darf":
//                        return emitirDarf(params);
            }
        }
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

    private RespostaPonte consultaRip(Map<String, String> params) {
        long rip = Long.parseLong(params.get("rip"));
        Optional<RIP> consulta = service.consultaRIP(rip);

        if (consulta.isPresent()) {
            return resposta()
                    .withComponentes(renderizaRip(consulta.get()));
        }
        return resposta()
                .componente(new Label()
                        .withValue("Não Achou!"));
    }

    private List<Componente> renderizaRip(RIP rip) {
        return Stream.concat(
                Arrays.asList(new Label("Extrato RIP: " + rip.getRip())).stream(),
                rip.getDebitos().stream()
                        .map(d -> Arrays.asList(
                             new Label("numero"), new Label(d.numero + ""),
                             new Label("receita"), new Label(d.receita),
                             new Label("exercicio"), new Label(d.exercicio + ""),
                             new Label("cotasConc"), new Label(d.cotasConc + ""),
                             new Label("cotasPagas"), new Label(d.cotasPagas + ""),
                             new Label("cpf_cnpj"), new Label(d.cpf_cnpj),
                             new Label("nomeResponsavel"), new Label(d.nomeResponsavel),
                             new Label("opcaoPagamento"), new Label(d.opcaoPagamento),
                             new Label("vencimento"), new Label(d.vencimento + ""),
                             new Label("validade"), new Label(d.validade + ""),
                             new Label("valorPrincipal"), new Label(d.valorPrincipal + ""),
                             new Label("valorMulta"), new Label(d.valorMulta + ""),
                             new Label("valorJuros"), new Label(d.valorJuros + "")))
                        .flatMap(x -> x.stream()))
                .collect(toList());
    }

//    private RespostaPonte emitirDarf(Map<String, String> params) {
//        return null;
//    }

    private RespostaPonte resposta() {
        return new RespostaPonte()
                .withTitulo("DARF Patrimonial");
    }

}
