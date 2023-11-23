package com.freemusic.recommendationsservice.models;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


import java.sql.Date;
import java.util.List;

/**
 * Current list for trending or top music
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "music_lists")
public class MusicList {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private long id;

    Integer topNumber;

    Integer withInDay;

    @OneToMany(mappedBy = "musicList")
    List<Music> music;

    Date validDate;
}
