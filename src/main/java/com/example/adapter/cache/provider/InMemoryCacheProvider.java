package com.example.adapter.cache.provider;

import com.example.domain.exception.DomainException;
import com.example.domain.policy.eviction.EvictionPolicy;
import com.example.domain.port.out.CacheProvider;
import jakarta.inject.Named;
import jakarta.inject.Singleton;

import java.util.HashMap;
import java.util.Map;

@Singleton
@Named("in-memory")
public class InMemoryCacheProvider implements CacheProvider {

    private final Integer capacity;
    private final Map<String, String> storage;
    private final EvictionPolicy evictionPolicy;

    public InMemoryCacheProvider(Integer capacity, EvictionPolicy evictionPolicy) {
        this.capacity = capacity;
        this.storage = new HashMap<>();
        this.evictionPolicy = evictionPolicy;
    }

    @Override
    public void set(String key, String value) {
        if (storage.size() >= capacity) {
            throw new DomainException("Storage full.", DomainException.ErrorCode.STORAGE_FULL);
        }

        storage.put(key, value);
    }

    @Override
    public String get(String key) {
        return storage.get(key);
    }

    @Override
    public String delete(String key) {
        return storage.remove(key);
    }
}
