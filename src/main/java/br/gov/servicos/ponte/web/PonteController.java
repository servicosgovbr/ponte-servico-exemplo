package br.gov.servicos.ponte.web;

import br.gov.servicos.ponte.PonteApp;
import br.gov.spu.darf.EmissaoDARFController;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

import static java.lang.String.format;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

@Controller
@Slf4j
public class PonteController {
    private Map<String, Class<? extends PonteApp>> applicacoes = new HashMap() {
        {
            put("emissao-darf-spu", EmissaoDARFController.class);
        }
    };

    @RequestMapping(value = "/ponte", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE, method = POST)
    @ResponseBody
    RespostaPonte ponte(@RequestBody RequestPonte request) {
        log.info("Request ponte: " + request);
        PonteApp app = criarApp(request.appId);
        log.debug("App: " + app);

        return app.action(request.action, request.params)
                .withAppId(request.appId);
    }

    @SneakyThrows
    private PonteApp criarApp(String appId) {
        log.debug("Criando nova instância: " + appId);
        Class<? extends PonteApp> appClass = applicacoes.get(appId);
        if (appClass != null) {
            log.debug("Encontrou aplicação para: " + appId);
            return appClass.newInstance();
        }
        throw new RuntimeException(format("Não existe nenhuma aplicação com o id: '%s' registrada", appId));
    }

}
