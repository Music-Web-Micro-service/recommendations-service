package com.freemusic.recommendationsservice.controllers;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.function.EntityResponse;

@RestController
public class RecommendationController {

    public EntityResponse<?> RecommendationTop50Track(){
        return null;
    }

    public EntityResponse<?> RecommendationTop50Album(){
        return null;
    }

    public EntityResponse<?> RecommendationByUserHistory(){
        return null;
    }

    public EntityResponse<?> RecommendationByUserLike(){
        return null;
    }
}
