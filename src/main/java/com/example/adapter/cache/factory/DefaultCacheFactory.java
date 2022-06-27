package com.example.adapter.cache.factory;

import com.example.adapter.cache.provider.InMemoryCacheProvider;
import com.example.domain.exception.DomainException;
import com.example.domain.policy.eviction.LRUEvictionPolicy;
import com.example.domain.port.out.CacheFactory;
import com.example.domain.port.out.CacheProvider;
import jakarta.inject.Singleton;

@Singleton
public class DefaultCacheFactory implements CacheFactory {

    public CacheProvider getCacheProvider(String type, Integer capacity, String evictionPolicy) {
        if ("in-memory".equals(type)) {
            return new InMemoryCacheProvider(capacity, new LRUEvictionPolicy());
        }

        throw new DomainException("CacheProvider not found of type " + type, DomainException.ErrorCode.CACHE_PROVIDER_NOT_FOUND, type);
    }
}
