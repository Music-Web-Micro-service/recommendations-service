package com.freemusic.recommendationsservice.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import
        lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "musics")
public class Music {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private long id;

    /**
     * the real music id
     */
    private String uniqueId;
    private Long commentsCount;
    private Long userLikes;
    private String albumName;

    @ManyToOne
    @JsonIgnore
    MusicList musicList;
}
