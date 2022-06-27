package com.example.domain.port.in;

public interface MlCache {

    void set(String key, String value);

    String get(String key);

    String delete(String key);
}
