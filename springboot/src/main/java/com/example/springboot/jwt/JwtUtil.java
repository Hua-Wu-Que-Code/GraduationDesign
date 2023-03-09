package com.example.springboot.jwt;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component(value = "jwtUtil")
public class JwtUtil {
    final static String key = "testJwtSaltKey"; //签名
    final static Integer ttl = 24*60*60*1000;   //有效时间

    static public String generateToken( Integer initId ) {
        String id = initId.toString();
        String token = Jwts.builder()
                .setHeaderParam("typ", "JWT")
                //jwt的id
                .setSubject(id)
                //setIssuedAt用于设置签发时间
                .setIssuedAt(new Date())
                //过期时间：当前系统时间+一整天
                .setExpiration(new Date(System.currentTimeMillis()+ttl))
                //签名算法  key就是自定义的签名
                .signWith(SignatureAlgorithm.HS512, key)
                //拼接
                .compact();
        return token;
    }

    static public Integer parseToken( String token ) {
        /**
         * 通过token进行解析 然后 得到一个id
         */
        Claims claims = Jwts.parser().setSigningKey(key).parseClaimsJws(token).getBody();
        return Integer.parseInt(claims.getId());

        /**
         * 标准写法
         */
        /*String token = "";
        JwtParser jwtParser = Jwts.parser();
        Jws<Claims> claimsJws = jwtParser.setSigningKey(key).parseClaimsJws(token);
        Claims claims = claimsJws.getBody();*/
    }

    // 解析jwt
    public Claims getClaimByToken(String jwt) {
        //加异常是为了后续代码能正常进行
        try {
            return Jwts.parser()
                    //设置密钥
                    .setSigningKey(key)
                    //进行解析
                    .parseClaimsJws(jwt)
                    //得到Body部分
                    .getBody();
        } catch (Exception e) {
            System.out.println("test");
            return null;
        }
    }

    // jwt是否过期
    public boolean isTokenExpired(Claims claims) {
        return claims.getExpiration().before(new Date());
    }


}