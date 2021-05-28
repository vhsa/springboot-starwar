package br.com.startwars.service;

import br.com.startwars.dtos.Personagem;
import br.com.startwars.dtos.PersonagemResponse;
import br.com.startwars.repository.PersonagemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PersonagemService {

    @Autowired
    PersonagemRepository personagemRepository;

    public List<PersonagemResponse> findByName (String name ) {

        List<PersonagemResponse> personagemResponse = new ArrayList<>();
        List<Personagem> personagens = personagemRepository.findByName(name);

        for ( Personagem p : personagens ) {
            personagemResponse.add(new PersonagemResponse(p.getName()));
        }
//        IntStream.range(0, personagens.size()).forEach( i -> personagemResponse.add(new PersonagemResponse(personagens.get(i).getName())));

        return personagemResponse;
    }
}
