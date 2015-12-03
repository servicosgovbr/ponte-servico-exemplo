package br.gov.spu.darf;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.experimental.Wither;

import java.util.ArrayList;
import java.util.List;

@Data
@Wither
@AllArgsConstructor
public class RIP {
    long rip;
    List<Debito> debitos;

    public RIP() {
        debitos = new ArrayList<>();
    }

    public RIP debito(Debito b) {
        debitos.add(b);
        return this;
    }
}
