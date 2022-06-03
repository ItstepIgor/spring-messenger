package com.springmessenger.cache;

import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class MessageCacheMap {
    private Map<Long, String> cacheMap = new HashMap<>();


    public void addCache(long id, String str) {
        cacheMap.put(id, str);
    }

    public Map<Long, String> getCacheMap() {
        return cacheMap;
    }
}

