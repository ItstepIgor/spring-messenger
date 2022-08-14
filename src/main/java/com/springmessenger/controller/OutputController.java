package com.springmessenger.controller;


import com.springmessenger.cache.MessageCacheMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;

import javax.annotation.PostConstruct;
import java.io.PrintStream;
import java.util.Locale;
import java.util.Scanner;

@Controller
public class OutputController {


    private Locale locale;
    //todo поменять на конструкторы
    @Autowired
    private Scanner scanner;

    @Autowired
    private MessageSource messageSource;

    @Autowired
    private PrintStream printStream;

    @Autowired
    private MessageCacheMap messageCacheMap;

    @PostConstruct
    private void init() {
        System.out.println("""
                1 - English
                2 - Русский
                """);
        int selectLanguage = scanner.nextInt();
        switch (selectLanguage) {
            case 1 -> locale = new Locale("en", "EN");
            case 2 -> locale = new Locale("ru", "RU");
        }
    }


    public void showMessage(String stringLocale, String addText, String logText) {
        System.out.println(addText + "" + messageSource.getMessage(stringLocale, null, locale) + " " + logText);
    }
    //todo - добавить в build.gradle utf-8  и в тругие файлы и заменить System.out. где можно

    public void showCache() {
        System.out.println(messageCacheMap.getCacheMap());
    }
}
