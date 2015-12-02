package br.gov.servicos.ponte.web;

import br.gov.servicos.ponte.componentes.Componente;
import br.gov.servicos.ponte.componentes.Input;
import br.gov.servicos.ponte.componentes.Label;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Value;
import lombok.experimental.Wither;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
public class PonteController {

    @RequestMapping(value = "/ponte", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    RespostaPonte ponte(@RequestBody RequestPonte request) {
        return new RespostaPonte()
                .withTitulo("Emissão DARF - SPU")
                .componente(new Label()
                        .withValue("Consulta da situação do imóvel"))
                .componente(new Input()
                        .withLabel("RIP:")
                        .withName("rip"));
    }

    @Value
    @Wither
    @AllArgsConstructor
    public static class RespostaPonte {
        String titulo;
        List<Componente> componentes;

        public RespostaPonte() {
            titulo = "";
            componentes = new ArrayList<>();
        }

        public RespostaPonte componente(Componente c) {
            componentes.add(c);
            return this;
        }
    }

    @Data
    @Wither
    @NoArgsConstructor
    @AllArgsConstructor
    public static class RequestPonte {
        String token;
        String session;
        String action;
        Map<String, String> params;
    }
}
