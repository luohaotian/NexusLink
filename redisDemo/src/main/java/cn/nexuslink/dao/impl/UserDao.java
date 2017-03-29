package cn.nexuslink.dao.impl;

import cn.nexuslink.dao.AbstractBaseRedisDao;
import cn.nexuslink.dao.IUserDao;
import cn.nexuslink.pojo.User;
import com.sun.org.apache.xpath.internal.operations.String;
import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.stereotype.Repository;
import org.springframework.util.Assert;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 罗浩 on 2017/3/29.
 */

@Repository("userDao")
public class UserDao extends AbstractBaseRedisDao<String, User> implements IUserDao {

    @Override
    public boolean add(final User user) {
        boolean result = (boolean) redisTemplate.execute(new RedisCallback<Boolean>() {
            @Override
            public Boolean doInRedis(RedisConnection redisConnection) throws DataAccessException {
                RedisSerializer serializer = getRedisSerializer();
                byte[] key = serializer.serialize(user.getId());
                byte[] name = serializer.serialize(user.getName());
                return redisConnection.setNX(key, name);
            }
        });
        return result;
    }

    @Override
    public boolean add(final List<User> userList) {
        Assert.notEmpty(userList);
        boolean result = (boolean) redisTemplate.execute(new RedisCallback<Boolean>() {
            @Override
            public Boolean doInRedis(RedisConnection redisConnection) throws DataAccessException {
                RedisSerializer serializer = getRedisSerializer();
                for (User user :
                        userList) {
                    byte[] key = serializer.serialize(user.getId());
                    byte[] name = serializer.serialize(user.getName());
                    redisConnection.setNX(key, name);
                }
                return true;
            }

        },false,true);
        return result;
    }

    @Override
    public void delete(java.lang.String key) {
        List<java.lang.String> list = new ArrayList<>();
        list.add(key);
        delete(list);
    }



    @Override
    public void delete(List<java.lang.String> keys) {
        redisTemplate.delete((String) keys);
    }

    public void main(String[] args) {
        UserDao userDao = new UserDao();
        userDao.delete("hello");
        System.out.print("ok!");
    }




//    @Override
//    public boolean update(final User user) {
//        String key =  user.getId();
//        if (get(key) == null) {
//            throw new NullPointerException("数据行不存在，key = " + key);
//        }
//
//        boolean result = redisTemplate.execute(new RedisCallback<Boolean>() {
//            @Override
//            public Boolean doInRedis(RedisConnection redisConnection) throws DataAccessException {
//                RedisSerializer<java.lang.String> serializer = getRedisSerializer();
//
//                byte[] key = serializer.serialize(user.getId());
//                byte[] name = serializer.serialize(java.lang.String.valueOf(user.getName()));
//                redisConnection.setNX(key, name);
//                return true;
//            }
//        });
//        return result;
//    }
//
//    @Override
//    public User get(final java.lang.String keyId) {
//        User result = redisTemplate.execute(new RedisCallback<User>() {
//            @Override
//            public User doInRedis(RedisConnection redisConnection) throws DataAccessException {
//                RedisSerializer<java.lang.String> serializer = getRedisSerializer();
//                byte[] key = serializer.serialize(keyId);
//                byte[] value = redisConnection.get(key);
//
//                if (value == null) {
//                    return null;
//                }
//                java.lang.String name;
//                name = serializer.deserialize(value);
//                User user = new User();
//                user.setId(keyId);
//                user.setName(name);
//                return user;
//            }
//        });
//        return result;
//    }


}
