package com.bigpie.big_pie_project.utils;

import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class GeneratorUniqueCode {
    public static String generateAcceptCode(){
        UUID uuid = UUID.randomUUID();
        return uuid.toString();
    }
}
