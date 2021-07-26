package com.ik.marvel.heroes.controller;

import com.ik.marvel.heroes.exception.ResourceNotFoundException;
import com.ik.marvel.heroes.model.Character;
import com.ik.marvel.heroes.model.Comic;
import com.ik.marvel.heroes.model.Story;
import com.ik.marvel.heroes.repository.ComicRepository;
import com.ik.marvel.heroes.repository.StoryRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import com.ik.marvel.heroes.repository.CharacterRepository;
import com.ik.marvel.heroes.services.CharacterService;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.List;

@RestController
@RequestMapping("/v1/public")
public class CharacterController {

    private CharacterService characterService;

    private final CharacterRepository characterRepository;
    private final ComicRepository comicRepository;
    private final StoryRepository storyRepository;
//    private SerieRepository serieRepository;

    public CharacterController(CharacterRepository characterRepository, ComicRepository comicRepository, StoryRepository storyRepository){
        this.characterRepository = characterRepository;
        this.comicRepository = comicRepository;
        this.storyRepository = storyRepository;
    }

    @GetMapping("/characters")
    public List<Character> getAllCharacters() {
        return characterRepository.findAll();
    }

    @GetMapping("/characters/{id}")
    public Character getCharacterById(@PathVariable(value = "id") Integer characterId){
        return characterRepository.findById(characterId)
                .orElseThrow(() -> new ResourceNotFoundException("Character", "id", characterId));
    }

    @GetMapping("/characters/{id}/comics")
    public Collection<Comic> getComicsByCharacterId(@PathVariable(value = "id") Integer characterId){
        return comicRepository.findComicsByCharacterId(characterId);
    }

    @GetMapping("/characters/{id}/stories")
    public Collection<Story> getStoriesByCharacterId(@PathVariable(value = "id") Integer characterId){
        return storyRepository.findStoriesByCharacterId(characterId);
    }



//    public ResponseEntity<>

//    public ResponseEntity<Character> findById(@PathVariable int id){
//        return repository.findById(id)
//                .map(record -> ResponseEntity.ok().body(record))
//                .orElse(ResponseEntity.notFound().build());
//    }
}
