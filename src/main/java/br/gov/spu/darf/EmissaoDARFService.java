package br.gov.spu.darf;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class EmissaoDARFService {
    RIPRepository rips;

    @Autowired
    public EmissaoDARFService(RIPRepository rips) {
        this.rips = rips;
    }

    public Optional<RIP> consultaRIP(long rip) {
        return rips.findOne(rip);
    }

    public void darfParaDebito(long rip, long debito) {
    }

}
