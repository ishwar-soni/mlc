package com.example.domain.port.out;

public interface CacheProvider {

    void set(String key, String value);

    String get(String key);

    String delete(String key);
}
