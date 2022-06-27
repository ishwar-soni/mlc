package com.example.domain.port.out;

public interface CacheFactory {

    CacheProvider getCacheProvider(String type, Integer capacity, String evictionPolicy);
}
