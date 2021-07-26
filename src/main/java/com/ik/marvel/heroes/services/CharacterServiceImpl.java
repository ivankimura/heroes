package com.ik.marvel.heroes.services;

import com.ik.marvel.heroes.model.Character;
import com.ik.marvel.heroes.repository.CharacterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CharacterServiceImpl implements CharacterService{

    private CharacterRepository characterRepository;

    @Autowired
    public CharacterServiceImpl(CharacterRepository characterRepository){
        this.characterRepository = characterRepository;
    }

    @Override
    public List<Character> listAll(){
        List<Character> characters = new ArrayList<>();
        characterRepository.findAll().forEach(characters::add);
        return characters;
    }

    @Override
    public Character getById(int id) {
        return characterRepository.findById(id).orElse(null);
    }
}
