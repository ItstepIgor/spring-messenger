package com.springmessenger.cache;

import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class MessageCacheMap {
    private Map<String, String> cacheMap = new HashMap<>();
}
