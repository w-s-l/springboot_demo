package com.wsl.mapper;

import com.wsl.domain.Video;
import org.springframework.stereotype.Repository;

import javax.crypto.Cipher;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
@Repository
public class VideoMapper {
    private static Map<Integer, Video> map = new HashMap<>();

    static{
        map.put(1,new Video(1,"Java基础课程"));
        map.put(2,new Video(2,"Springboot2.X零基础到实战"));
        map.put(3,new Video(3,"微服务架构SpringCloud"));
        map.put(4,new Video(4,"Springboot微信支付实战"));
        map.put(5,new Video(5,"小滴课堂面试题，300道大厂连环问"));
    }
    public List<Video> videoList(){
        List<Video> list = new ArrayList<>();
        list.addAll(map.values());
        return list;
    }
}
