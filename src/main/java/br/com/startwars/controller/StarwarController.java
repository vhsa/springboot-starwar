package br.com.startwars.controller;

import br.com.startwars.dtos.PersonagemResponse;
import br.com.startwars.service.PersonagemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/starwars")
public class StarwarController {

    @Autowired
    PersonagemService personagemService;

    @GetMapping("/{name}")
    public List<PersonagemResponse> index (@PathVariable String name ) {
        return personagemService.findByName(name);
    }
}
