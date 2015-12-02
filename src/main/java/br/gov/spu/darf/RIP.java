package br.gov.spu.darf;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Wither;

import java.util.List;

@Data
@Wither
@AllArgsConstructor
@NoArgsConstructor
public class RIP {
    long rip;
    List<Debito> debitos;

    public RIP debito(Debito b) {
        debitos.add(b);
        return this;
    }
}
