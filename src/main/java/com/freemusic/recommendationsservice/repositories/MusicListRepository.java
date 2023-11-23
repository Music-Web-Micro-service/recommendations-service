package com.freemusic.recommendationsservice.repositories;

import com.freemusic.recommendationsservice.models.MusicList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MusicListRepository extends JpaRepository<MusicList, Long> {

    MusicList getMusicListByWithInDayEquals(Integer withInDays);
    MusicList getMusicListByTopNumberEquals(Integer topNumber);

    MusicList getMusicListByWithInDayAndTopNumberEquals(Integer withInDay, Integer TopNumber);
}
