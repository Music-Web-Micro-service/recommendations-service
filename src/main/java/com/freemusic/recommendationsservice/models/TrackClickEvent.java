package com.freemusic.recommendationsservice.models;


import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class TrackClickEvent {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String trackClickId;
    private String uniqueId;
    private Long played;
    private Long commentsCount;
    private Long userLikes;
    private String musicName;
    private Date publishedDate;
}
