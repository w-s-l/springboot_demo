package com.wsl.service.impl;

import com.wsl.domain.Video;
import com.wsl.mapper.VideoMapper;
import com.wsl.service.VideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class VideoServiceImpl implements VideoService {
    @Autowired
    private VideoMapper videoMapper;
    @Override
    public List<Video> listVideo() {
        return videoMapper.videoList();
    }
}
