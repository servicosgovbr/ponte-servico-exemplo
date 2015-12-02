package br.gov.spu.darf;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Wither;

import java.util.Date;

@Data
@Wither
@AllArgsConstructor
@NoArgsConstructor
public class Debito {
    long numero;
    String receita;
    int exercicio;
    int cotasConc;
    double cotasPagas;
    String cpf_cnpj;
    String nomeResponsavel;
    String opcaoPagamento;
    Date vencimento;
    Date validade;
    double valorPrincipal;
    double valorMulta;
    double valorJuros;

    public double getValorTotal() {
        return valorPrincipal + valorMulta + valorJuros;
    }
}
