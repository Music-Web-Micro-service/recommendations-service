package com.freemusic.recommendationsservice.controllers;

import com.freemusic.recommendationsservice.models.MusicList;
import com.freemusic.recommendationsservice.models.TrackClickEvent;
import com.freemusic.recommendationsservice.services.MusicListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 *        top多少的热单
 *        近期trending 热单
 *        userlike最多的
 *        top album
 *        trending album
 */
@RestController("/recommendation")
public class RecommendationController {


    @Autowired
    RestTemplate restTemplate;

    @Autowired
    MusicListService musicListService;

    String url = "http://listen-history-service";
    /**
     * Get top number of music we have base on current user
     * @param number
     * @return
     */
    @GetMapping("/top/tracks")
    public ResponseEntity<?> getTopNumberTrack( @RequestParam int number){

        MusicList musicList = musicListService.getMusicList(number, false);

        if(musicList != null && musicList.getMusic() != null) {
            return ResponseEntity.ok(musicList.getMusic());
        }
        List<TrackClickEvent> res = (List<TrackClickEvent>)restTemplate.getForObject(url + "/history/tracks/top/" + number, List.class);
        return ResponseEntity.ok(res);
    }

    @GetMapping("/trending/tracks")
    public ResponseEntity<?> getTrendingNumberTrack(@RequestParam int requireNumTrack, @RequestParam int overNumberPlayed, @RequestParam int withInDay) {
        MusicList musicList = musicListService.getMusicList(withInDay, requireNumTrack);
        if(musicList != null && musicList.getMusic() != null) {
            return ResponseEntity.ok(musicList.getMusic());
        }

        Map<String, Integer> param = new HashMap<>();
        param.put("requireNumTrack", requireNumTrack);
        param.put("overNumberPlayed",  overNumberPlayed);
        param.put("withInDay",  withInDay);

        List<TrackClickEvent> res = (List<TrackClickEvent>)restTemplate.getForObject(url + "/listen/{requireNumTrack}/{overNumberPlayed}/{withInDay}", List.class, param);

        return ResponseEntity.ok(res);
    }



    @GetMapping("/top/album")
    public ResponseEntity<?> getTopNumberAlbum( @RequestParam int number){

        MusicList musicList = musicListService.getMusicList(number, false);
        if(musicList != null && musicList.getMusic() != null) {
            return ResponseEntity.ok(musicList.getMusic());
        }
        List<TrackClickEvent> res = (List<TrackClickEvent>)restTemplate.getForObject(url + "/history/album/top/" + number, List.class);
        return ResponseEntity.ok(res);
    }

    @GetMapping("/trending/album")
    public ResponseEntity<?> getTrendingNumberAlbum(@RequestParam int requireNumAlbum, @RequestParam int overNumberPlayed, @RequestParam int withInDay) {

        MusicList musicList = musicListService.getMusicList(withInDay, requireNumAlbum);
        if(musicList != null && musicList.getMusic() != null) {
            return ResponseEntity.ok(musicList.getMusic());
        }

        Map<String, Integer> param = new HashMap<>();
        param.put("requireNumAlbum", requireNumAlbum);
        param.put("overNumberPlayed",  overNumberPlayed);
        param.put("withInDay",  withInDay);

        List<TrackClickEvent> res = (List<TrackClickEvent>)restTemplate.getForObject(url + "/listen/{requireNumAlbum}/{overNumberPlayed}/{withInDay}", List.class, param);

        return ResponseEntity.ok(res);
    }


    public ResponseEntity<?> recommendationByUserLike(){
        return null;
    }

    public ResponseEntity<?> getRecommendationTopNumberAlbum(){
        return null;
    }

    public ResponseEntity<?> getTrendingUserHistory(){
        return null;
    }

}
