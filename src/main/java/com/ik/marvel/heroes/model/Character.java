package com.ik.marvel.heroes.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import java.util.Date;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Table(name="marvelcharacter")
@Entity
public class Character extends BaseEntity {

    private String name;
    private String description;
    private Date modified;

    @JsonIgnore
    @ManyToMany(mappedBy = "comicCharacters", fetch = FetchType.LAZY)
    private Set<Comic> characterComics;

    @JsonIgnore
    @ManyToMany(mappedBy = "storyCharacters", fetch = FetchType.LAZY)
    private Set<Story> characterStories;

//    private List comicList;
//    private List storyList;
//    private List eventList;
//    private List serieList;




}
