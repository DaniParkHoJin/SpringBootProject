package com.hojin.util;

import org.springframework.http.MediaType;

import java.util.HashMap;
import java.util.Map;

public class MediaUtils {
    private static Map<String, MediaType> mediaMap;

    static {
        mediaMap= new HashMap<String, MediaType>();
        mediaMap.put("JPG", MediaType.IMAGE_JPEG);
        mediaMap.put("GiF", MediaType.IMAGE_GIF);
        mediaMap.put("PNG", MediaType.IMAGE_PNG);

    }

    public static MediaType getMediaType(String type) {
        return mediaMap.get(type.toUpperCase());

    }

}
