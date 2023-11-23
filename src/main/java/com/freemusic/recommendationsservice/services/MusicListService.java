package com.freemusic.recommendationsservice.services;

import com.freemusic.recommendationsservice.models.MusicList;
import org.springframework.stereotype.Service;


@Service
public interface MusicListService {

    MusicList getMusicList(Integer withInDay, Boolean isDay);
    MusicList getMusicList(Integer withInDay, Integer topNumber);
}
