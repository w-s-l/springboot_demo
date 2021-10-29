package com.wsl.controller;

import com.wsl.domain.Video;
import com.wsl.service.VideoService;
import com.wsl.utils.JsonData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/pub/video")
public class VideoController {
    @Autowired
    private VideoService videoService;

    //@RequestMapping(value = "list",method = RequestMethod.GET)
    @GetMapping("list")
    public JsonData list() {
        List<Video> list = videoService.listVideo();
        return JsonData.buildSuccess(list);
    }
    @PostMapping("save_video_chapter")
    public JsonData saveVideoChapter(@RequestBody Video video) {
        System.out.println(video.toString());
        return JsonData.buildSuccess(video);
    }

}
