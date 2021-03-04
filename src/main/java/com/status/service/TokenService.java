package com.status.service;

import cn.hutool.core.util.IdUtil;
import com.status.constant.Constants;
import com.status.model.entity.User;
import com.status.redis.RedisCache;
import com.status.utils.StringUtils;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * token验证处理
 * 
 * @author 张志宇
 */
@Component
public class TokenService
{

    @Autowired
    private RedisCache redisCache;

    protected static final long MILLIS_SECOND = 1000;

    protected static final long MILLIS_MINUTE = 60 * MILLIS_SECOND;

    private static final Long MILLIS_MINUTE_TEN = 20 * 60 * 1000L;
    /**
     * 创建令牌
     * @return
     */
   public String createdToken(User user){
       String token = IdUtil.randomUUID();
       Map<String, Object> map = new HashMap<>();
       map.put(Constants.LOGIN_USER_KEY,token);
       map.put("id",user.getId());
       map.put("username",user.getName());
       //令牌有效期
       refreshToken(map);

       return createdToken(map);
   }

    /**
     * 生成秘钥
     * @param map
     * @return
     */
   private String createdToken(Map<String, Object> map){
       String token = Jwts.builder().setClaims(map).signWith(SignatureAlgorithm.HS512, "abcdefghijklmnopqrstuvwxyz").compact();
       return token;
   }
    /**
     * 刷新令牌有效期
     *
     * @param map 登录信息
     */
    public void refreshToken(Map<String, Object> map)
    {
        // 根据uuid将loginUser缓存
        String userKey = getTokenKey((String)map.get(Constants.LOGIN_USER_KEY));
        redisCache.setCacheObject(userKey, map, 30, TimeUnit.MINUTES);
    }
    private String getTokenKey(String uuid)
    {
        return Constants.LOGIN_TOKEN_KEY + uuid;
    }


    /**
     * 获取用户身份信息
     *
     * @return 用户信息
     */
    public Map<String, Object> getLoginUser(HttpServletRequest request)
    {
        // 获取请求携带的令牌
        String token = request.getHeader("token");
        if (StringUtils.isNotEmpty(token))
        {
            Claims claims = parseToken(token);
            // 解析对应的权限以及用户信息
            String uuid = (String) claims.get(Constants.LOGIN_USER_KEY);
            String userKey = getTokenKey(uuid);
            Map<String, Object> map = redisCache.getCacheObject(userKey);
            return map;
        }
        return null;
    }

    /**
     * 从令牌中获取用户名
     *
     * @param token 令牌
     * @return 用户名
     */
    public String getUsernameFromToken(String token)
    {
        Claims claims = parseToken(token);
        return claims.getSubject();
    }
    /**
     * 从令牌中获取数据声明
     *
     * @param token 令牌
     * @return 数据声明
     */
    private Claims parseToken(String token)
    {
        return Jwts.parser()
                .setSigningKey("abcdefghijklmnopqrstuvwxyz")
                .parseClaimsJws(token)
                .getBody();
    }
}
