package com.freemusic.recommendationsservice.services.implement;

import com.freemusic.recommendationsservice.models.MusicList;
import com.freemusic.recommendationsservice.services.MusicListService;
import org.springframework.stereotype.Service;

@Service
public class MusicListServiceImpl implements MusicListService {

//    @Autowired
//    MusicListRepository musicListRepository;
    @Override
    public MusicList getMusicList(Integer withInDay, Boolean isDay) {
        return null;
//        if(isDay) {
//            return musicListRepository.getMusicListByWithInDayEquals(withInDay);
//        }
//        return musicListRepository.getMusicListByTopNumberEquals(withInDay);
    }

    @Override
    public MusicList getMusicList(Integer withInDay, Integer topNumber) {
        return null;
//        return musicListRepository.getMusicListByWithInDayAndTopNumberEquals(withInDay, topNumber);
    }
}
