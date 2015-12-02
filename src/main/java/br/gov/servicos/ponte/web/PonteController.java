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
import java.util.Optional;
import java.util.UUID;

import static java.lang.String.format;

@Controller
@Slf4j
public class PonteController {
    private Map<String, Class<? extends PonteApp>> applicacoes = new HashMap() {
        {
            put("emissao-darf-spu", EmissaoDARFController.class);
        }
    };
    private Map<String, Sessao> sessoes = new HashMap<>();

    @RequestMapping(value = "/ponte", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    RespostaPonte ponte(@RequestBody RequestPonte request) {
        log.info("Request ponte: " + request);
        Sessao sessao = obterOuCriarInstancia(request.appId, request.session);
        PonteApp app = sessao.app;
        String action = request.action;
        log.debug("Sessão: " + sessao);

        if (action == null || action.isEmpty()) {
            app.index();
        } else {
            app.action(action, request.params);
        }

        return null;
    }

    private Sessao obterOuCriarInstancia(String appId, String sessao) {
        return Optional.ofNullable(sessoes.get(sessao))
                .orElse(criarApp(appId));
    }

    @SneakyThrows
    private Sessao criarApp(String appId) {
        log.debug("Criando nova instância: " + appId);
        Class<? extends PonteApp> appClass = applicacoes.get(appId);
        if (appClass != null) {
            log.debug("Encontrou aplicação para: " + appId);
            PonteApp app = appClass.newInstance();
            return new Sessao()
                    .withId(UUID.randomUUID().toString())
                    .withApp(app);
        }
        throw new RuntimeException(format("Não existe nenhuma aplicação com o id: '%s' registrada", appId));
    }

}
