package br.gov.spu.darf;

import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Component
public class RIPRepository {

    private static List<RIP> RIPS = Arrays.asList(new RIP()
            .withRip(123123)
            .debito(new Debito()
                    .withNumero(123123)
                    .withReceita("Taxa de ocupação")
                    .withExercicio(2013)
                    .withCotasConc(07)
                    .withCotasPagas(0)
                    .withCpf_cnpj("10913041815")
                    .withNomeResponsavel("Nome privado")
                    .withOpcaoPagamento("Valor integral")
                    .withVencimento(new Date())
                    .withValidade(new Date())
                    .withValorPrincipal(500.00)
                    .withValorMulta(123.62)
                    .withValorJuros(87.3))
            .debito(new Debito()
                    .withNumero(321321)
                    .withReceita("Taxa de ocupação")
                    .withExercicio(2013)
                    .withCotasConc(07)
                    .withCotasPagas(0)
                    .withCpf_cnpj("10913041815")
                    .withNomeResponsavel("Nome privado")
                    .withOpcaoPagamento("Valor integral")
                    .withVencimento(new Date())
                    .withValidade(new Date())
                    .withValorPrincipal(500.00)
                    .withValorMulta(123.62)
                    .withValorJuros(87.3))
            .debito(new Debito()
                    .withNumero(101010)
                    .withReceita("Taxa de ocupação")
                    .withExercicio(2013)
                    .withCotasConc(07)
                    .withCotasPagas(0)
                    .withCpf_cnpj("10913041815")
                    .withNomeResponsavel("Nome privado")
                    .withOpcaoPagamento("Valor integral")
                    .withVencimento(new Date())
                    .withValidade(new Date())
                    .withValorPrincipal(500.00)
                    .withValorMulta(123.62)
                    .withValorJuros(87.3)));

    public Optional<RIP> findOne(long numero) {
        return RIPS.stream()
                .filter(r -> r.getRip() == numero)
                .findFirst();
    }
}
