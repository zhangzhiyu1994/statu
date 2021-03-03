package com.status.service;

import cn.hutool.core.util.IdUtil;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/**
 * token验证处理
 * 
 * @author 张志宇
 */
@Component
public class TokenService
{
    /**
     * 创建令牌
     * @return
     */
   public String createdToken(){
       String token = IdUtil.randomUUID();
       Map<String, Object> map = new HashMap<>();
       map.put("token",token);
       String s = createdToken(map);
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
}
