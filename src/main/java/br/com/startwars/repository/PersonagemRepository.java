package br.com.startwars.repository;

import br.com.startwars.dtos.Personagem;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class PersonagemRepository {

    public List<Personagem> findByName ( String name ) {
        List<Personagem> personagens = null;

        personagens = loadDatabase();

        if (personagens != null ) {
            return personagens.stream().filter( p -> p.getName().contains(name)).collect(Collectors.toList());
        }
        return null;
    }


    public List<Personagem> loadDatabase() {
        File file = null;

        try {
            file = ResourceUtils.getFile("classpath:starwars.json");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        ObjectMapper objectMapper = new ObjectMapper();
        TypeReference<List<Personagem>> typeReference = new TypeReference<>(){};
        List<Personagem> personagens = null;

        try {
            personagens = objectMapper.readValue(file, typeReference);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return personagens;
    }
}
