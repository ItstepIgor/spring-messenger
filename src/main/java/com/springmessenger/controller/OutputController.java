package com.springmessenger.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;

import java.io.PrintStream;
import java.util.Locale;


public class OutputController {


    private final Locale locale;

    @Autowired
    private MessageSource messageSource;

    @Autowired
    private PrintStream printStream;

    public OutputController(Locale locale) {
        this.locale = locale;
    }

    public void showMessage(String stringLocale, String addText, String logText) {
        printStream.println(addText + "" + messageSource.getMessage(stringLocale, null, locale) + " " + logText);
    }
}
