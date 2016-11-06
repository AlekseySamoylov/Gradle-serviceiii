package com.alekseysamoylov.serviceiii.service;

import lombok.extern.apachecommons.CommonsLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.stereotype.Service;

import java.util.Collection;

/**
 * Реализация {@link CacheService}.
 */
@Service
@CommonsLog
public class CacheServiceImpl implements CacheService {

    @Autowired
    private CacheManager cacheManager;

    @Override
    public void clearAllCaches() {
        Collection<String> cacheNames = cacheManager.getCacheNames();
        for (String name : cacheNames) {
            Cache cache = cacheManager.getCache(name);
            cache.clear();
        }
    }

    @Override
    public void clearCaches(String... names) {
        for (String name : names) {
            if (name != null) {
                Cache cache = cacheManager.getCache(name);
                if (cache != null) {
                    cache.clear();
                } else {
                    log.warn("Cache with name \"" + name + "\" not cleared because not found.");
                }
            } else {
                log.warn("Cache not cleared because name is null");
            }
        }
    }

}
