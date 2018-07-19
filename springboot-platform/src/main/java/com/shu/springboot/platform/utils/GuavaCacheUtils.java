package com.shu.springboot.platform.utils;



import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

/**
 * @author shudongping
 * @date 2018/05/23
 */
public class GuavaCacheUtils {
    /**
     * 缓存过期时间10s
     */
    private static Cache<Object, Object> cache = CacheBuilder.newBuilder()
            .maximumSize(100).expireAfterAccess(10, TimeUnit.SECONDS)
            .recordStats()
            .build();

    /**
     * 从缓存取值
     * @param key
     * @return
     * @throws ExecutionException
     */
    public static Object get(Object key){
        try{
            Object var = cache.get(key, new Callable<Object>() {
                @Override
                public Object call() throws Exception {
                    System.out.println("值不存在");
                    return null;
                }
            });
            return var;
        }catch (Exception e){
            return null;
        }


    }

    /**
     * 将数据放入缓存中
     * @param key
     * @param value
     */
    public static void put(Object key, Object value) {
        cache.put(key, value);
    }

    /**
     * 删除key
     * @param key
     */
    public static void remove(Object key){
        cache.invalidate(key);
    }


}
