package com.ik.marvel.heroes.repository;

import com.ik.marvel.heroes.model.Story;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;

@Repository
public interface StoryRepository extends JpaRepository<Story, Integer> {

    @Query("SELECT DISTINCT s FROM Story s JOIN s.storyCharacters sh WHERE sh.id = :characterId")
    @Transactional(readOnly = true)
    Collection<Story> findStoriesByCharacterId(@Param("characterId") Integer characterId);
}
