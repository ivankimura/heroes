package com.ik.marvel.heroes.repository;

import com.ik.marvel.heroes.model.Comic;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;

public interface ComicRepository  extends JpaRepository<Comic, Integer> {

    @Query("SELECT DISTINCT co FROM Comic co JOIN co.comicCharacters ch WHERE ch.id = :characterId")
    @Transactional(readOnly = true)
    Collection<Comic> findComicsByCharacterId(@Param("characterId") Integer characterId);
}
