package com.tent.cloud.shiro.cache.impl;

import com.tent.cloud.shiro.cache.JedisManager;
import com.tent.cloud.shiro.cache.JedisShiroCache;
import com.tent.cloud.shiro.cache.ShiroCacheManager;
import org.apache.shiro.cache.Cache;

public class JedisShiroCacheManager implements ShiroCacheManager {

    private JedisManager jedisManager;

    @Override
    public <K, V> Cache<K, V> getCache(String name) {
        return new JedisShiroCache<K, V>(name, getJedisManager());
    }

    @Override
    public void destroy() {
    	//如果和其他系统，或者应用在一起就不能关闭
    	//getJedisManager().getJedis().shutdown();
    }

    public JedisManager getJedisManager() {
        return jedisManager;
    }

    public void setJedisManager(JedisManager jedisManager) {
        this.jedisManager = jedisManager;
    }
}
