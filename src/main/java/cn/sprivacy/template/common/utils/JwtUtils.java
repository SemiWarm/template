package cn.sprivacy.template.common.utils;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @author fanglang
 * @date 2018-06-01 14:12
 * @desc jjwt工具类
 */
@Component
@ConfigurationProperties(prefix = "template.jwt")
public class JwtUtils {

    private final static Logger LOGGER = LoggerFactory.getLogger(JwtUtils.class);

    private String secret;
    private Long expire;
    private String header;

    public String getSecret() {
        return secret;
    }

    public void setSecret(String secret) {
        this.secret = secret;
    }

    public Long getExpire() {
        return expire;
    }

    public void setExpire(Long expire) {
        this.expire = expire;
    }

    public String getHeader() {
        return header;
    }

    public void setHeader(String header) {
        this.header = header;
    }

    /**
     * 生成Token
     *
     * @param userId
     * @return
     */
    public String generateToken(long userId) {
        Date nowDate = new Date();
        // 过期时间
        Date expireDate = new Date(nowDate.getTime() + expire * 1000);

        return Jwts.builder()
                .setHeaderParam("typ", "JWT")
                .setSubject(userId + "")
                .setIssuedAt(nowDate)
                .setExpiration(expireDate)
                .signWith(SignatureAlgorithm.HS512, secret)
                .compact();
    }

    /**
     * 根据Token获取凭证信息
     *
     * @param token
     * @return
     */
    public Claims getClaimByToken(String token) {
        try {
            return Jwts.parser()
                    .setSigningKey(secret)
                    .parseClaimsJws(token)
                    .getBody();
        } catch (Exception e) {
            LOGGER.debug("Validate is token error:", e);
            return null;
        }
    }


    /**
     * 验证Token是否过期
     *
     * @param expiration
     * @return
     */
    public boolean isTokenExpired(Date expiration) {
        return expiration.before(new Date());
    }
}
