package com.springmessenger.controller;


import com.springmessenger.cache.MessageCacheMap;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;

import java.util.Locale;
import java.util.Scanner;

@Controller
public class OutputController {


    private Locale locale;

    private final Scanner scanner;

    private final MessageSource messageSource;

    private final MessageCacheMap messageCacheMap;

    public OutputController(Scanner scanner, MessageSource messageSource, MessageCacheMap messageCacheMap) {
        this.scanner = scanner;
        this.messageSource = messageSource;
        this.messageCacheMap = messageCacheMap;
    }

//    @PostConstruct
//    private void init() {
//        System.out.println("""
//                1 - English
//                2 - Русский
//                """);
//        int selectLanguage = scanner.nextInt();
//        switch (selectLanguage) {
//            case 1 -> locale = new Locale("en", "EN");
//            case 2 -> locale = new Locale("ru", "RU");
//        }
//    }


    public void showMessage(String stringLocale, String addText, String logText) {
        System.out.println(addText + "" + messageSource.getMessage(stringLocale, null, locale) + " " + logText);
    }

    public void showCache() {
        System.out.println(messageCacheMap.getCacheMap());
    }
}
