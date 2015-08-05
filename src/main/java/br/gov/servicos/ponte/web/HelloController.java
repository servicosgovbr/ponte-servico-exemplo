package br.gov.servicos.ponte.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloController {

    @RequestMapping("/")
    ModelAndView hello() {
        return new ModelAndView("index");
    }

    @RequestMapping(value = "/", params = {"name"})
    ModelAndView helloWithName(@RequestParam("name") String name) {
        return new ModelAndView("index", "name", name);
    }
}
