package com.ik.marvel.heroes.services;

import com.ik.marvel.heroes.model.Character;

import java.util.List;

public interface CharacterService {

    List<Character> listAll();

    Character getById(int id);
}
