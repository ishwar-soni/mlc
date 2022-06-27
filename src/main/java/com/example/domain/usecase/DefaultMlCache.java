package com.example.domain.usecase;

import com.example.domain.port.in.MlCache;
import com.example.domain.port.out.CacheFactory;
import com.example.domain.port.out.CacheProvider;
import io.micronaut.context.annotation.Property;
import jakarta.inject.Singleton;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

@Singleton
public class DefaultMlCache implements MlCache {

    private final int numLevels;
    private final Map<String, Map<String, String>> levelConfig;
    private final List<CacheProvider> levels;
    private final CacheFactory cacheFactory;

    public DefaultMlCache(
            @Property(name = "numLevels") int numLevels,
            @Property(name = "levelConfig") Map<String, Map<String, String>> levelConfig,
            CacheFactory cacheFactory) {
        this.numLevels = numLevels;
        this.levelConfig = levelConfig;
        this.cacheFactory = cacheFactory;

        Map<String, String> firstLevelConfig = levelConfig.get("1");
        CacheProvider firstLevel = this.cacheFactory.getCacheProvider(
                firstLevelConfig.get("type"), Integer.valueOf(firstLevelConfig.get("capacity")), firstLevelConfig.get("policy")
        );

        this.levels = new LinkedList<>();
        this.levels.add(firstLevel);
    }

    @Override
    public void set(String key, String value) {

    }

    @Override
    public String get(String key) {
        return null;
    }

    @Override
    public String delete(String key) {
        return null;
    }
}
