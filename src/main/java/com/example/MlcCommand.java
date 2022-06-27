package com.example;

import com.example.adapter.cache.factory.DefaultCacheFactory;
import com.example.domain.port.in.MlCache;
import com.example.domain.usecase.DefaultMlCache;

import java.util.Map;

public class MlcCommand {

    public static void main(String[] args) {
        System.out.println("Hi");
        MlCache mlCache = new DefaultMlCache(3, Map.ofEntries(
                Map.entry("1", Map.ofEntries(
                        Map.entry("type", "in-memory"),
                        Map.entry("capacity", "10"),
                        Map.entry("policy", "lru")
                )),
                Map.entry("2", Map.ofEntries(
                        Map.entry("type", "in-memory"),
                        Map.entry("capacity", "20"),
                        Map.entry("policy", "lru")
                )),
                Map.entry("3", Map.ofEntries(
                        Map.entry("type", "in-memory"),
                        Map.entry("capacity", "15"),
                        Map.entry("policy", "lru")
                ))
        ),
                new DefaultCacheFactory());
    }
}
