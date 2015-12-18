package br.gov.spu.darf;

import br.gov.servicos.ponte.PonteApp;
import br.gov.servicos.ponte.componentes.*;
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
                        .withLabel("Registro Imobiliário Patrimonial (RIP):")
                        .withName("rip")
                        .withValue(""))
                .componente(new Button()
                        .withText("CONSULTAR")
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
                                new ChaveValor("Número do débito", d.numero + ""),
                                new ChaveValor("Receita", d.receita),
                                new ChaveValor("Exercício", d.exercicio + ""),
                                new ChaveValor("Cotas Conc.", d.cotasConc + ""),
                                new ChaveValor("Cotas Pagas", d.cotasPagas + ""),
                                new ChaveValor("CPF/CNPJ Responsável", d.cpf_cnpj),
                                new ChaveValor("Nome do Responsável", d.nomeResponsavel),
                                new ChaveValor("Opção de pagamento", d.opcaoPagamento),
                                new ChaveValor("Vencimento", d.vencimento + ""),
                                new ChaveValor("Data de Validade", d.validade + ""),
                                new ChaveValor("Valor principal", d.valorPrincipal + ""),
                                new ChaveValor("Valor da multa", d.valorMulta + ""),
                                new ChaveValor("Valor dos Juros", d.valorJuros + ""),
                                new ChaveValor("Valor Total", d.getValorTotal() + "")))
                        .flatMap(x -> x.stream()))
                .collect(toList());
    }

//    private RespostaPonte emitirDarf(Map<String, String> params) {
//        return null;
//    }

    private RespostaPonte resposta() {
        return new RespostaPonte();
    }
}
