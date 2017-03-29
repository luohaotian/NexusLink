package cn.nexuslink.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.RedisSerializer;

/**
 * Created by 罗浩 on 2017/3/29.
 */
public abstract class AbstractBaseRedisDao<K,V> {

    @Autowired
    protected  RedisTemplate redisTemplate;

    public void setRedisTemplate(RedisTemplate<K, V> redisTemplate) {
        this.redisTemplate = redisTemplate;
    }


    /**
     * 获取RedisSerializer
     * @return
     */
    public RedisSerializer<String> getRedisSerializer(){
        return redisTemplate.getStringSerializer();
    }


}
