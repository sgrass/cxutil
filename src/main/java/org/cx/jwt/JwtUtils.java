package org.cx.jwt;

import java.util.Date;

import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

import org.apache.commons.codec.binary.Base64;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.impl.crypto.MacProvider;
import net.sf.json.JSONObject;

public class JwtUtils {
	
	/**
	 * iss: jwt签发者
	 * sub: jwt所面向的用户
	 * aud: 接收jwt的一方
	 * exp: jwt的过期时间，这个过期时间必须要大于签发时间
	 * nbf: 定义在什么时间之前，该jwt都是不可用的.
	 * iat: jwt的签发时间
	 * jti: jwt的唯一身份标识，主要用来作为一次性token,从而回避重放攻击。
	 */
	
	
	public static final String JWT_ID = "jwt";
  public static final String JWT_SECRET = "1a2b3c4d";
  public static final int JWT_TTL = 60*60*1000;  //millisecond
  public static final int JWT_REFRESH_INTERVAL = 55*60*1000;  //millisecond
  public static final int JWT_REFRESH_TTL = 12*60*60*1000;  //millisecond
  
	private String key;

  /**
   * 由字符串生成加密key
   * @return
   */
  public SecretKey generalKey(){
      String stringKey = key+JWT_SECRET;
      byte[] encodedKey = Base64.decodeBase64(stringKey);
      SecretKey key = new SecretKeySpec(encodedKey, 0, encodedKey.length, "AES");
//      SecretKey key = MacProvider.generateKey();
      return key;
  }

  /**
   * 创建jwt
   * @param id
   * @param subject
   * @param ttlMillis
   * @return
   * @throws Exception
   */
  public String createJWT(String id, String subject, long ttlMillis) throws Exception {

      SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS256;
      long nowMillis = System.currentTimeMillis();
      Date now = new Date(nowMillis);
      SecretKey key = generalKey();
      JwtBuilder builder = Jwts.builder().setId(id).setIssuedAt(now).setSubject(subject).signWith(signatureAlgorithm, key);
      if (ttlMillis >= 0) {
          long expMillis = nowMillis + ttlMillis;
          Date exp = new Date(expMillis);
          builder.setExpiration(exp);
      }
      return builder.compact();
  }

  /**
   * 解密jwt
   * @param jwt
   * @return
   * @throws Exception
   */
  public Claims parseJWT(String jwt) throws Exception{
      SecretKey key = generalKey();
      Claims claims = Jwts.parser().setSigningKey(key).parseClaimsJws(jwt).getBody();
      return claims;
  }

  /**
   * 生成subject信息
   * @param user
   * @return
   */
  public static String generalSubject(Integer userId){
      JSONObject jo = new JSONObject();
      jo.put("userId", userId);
//      jo.put("userId", user.getId());
//      jo.put("mobile", user.getMobile());
      return jo.toString();
  }
  
  public static void main(String[] args) throws Exception {
  	JwtUtils jwt = new JwtUtils();
  	
  	System.out.println(generalSubject(222));
  	
  	String jwtsecr = jwt.createJWT("111",generalSubject(222),JWT_TTL);
  	System.out.println(jwtsecr);
  	
  	
  	Claims claims = jwt.parseJWT(jwtsecr);
  	System.out.println("-->"+claims.getId());
  	System.out.println("-->"+claims.getSubject());
  	System.out.println("-->"+claims);
  	
  	System.out.println(jwt.parseJWT("eyJhbGciOiJIUzI1NiJ9.eyJqdGkiOiIxMTEiLCJpYXQiOjE0OTM3MTcxMzgsInN1YiI6IntcInVzZXJJZFwiOjIyMn0iLCJleHAiOjE0OTM3MjA3Mzh9.5mPLN-q8gT1pJM5FkeLhP0pfgqSd_8s8kSr8Thhfxcg"));
     
  }
}
