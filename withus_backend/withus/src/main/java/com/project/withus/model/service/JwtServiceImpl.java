package com.project.withus.model.service;

import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.project.withus.exception.UnAuthorizedException;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Service
public class JwtServiceImpl implements JwtService {

	private static final String PRIVATE_KEY = "withusPrivateKey";
	private static final int EXPIRE_MINUTES = 60;
	
	@Override
	public <T> String create(String key, T data, String subject) {
		String jwt = Jwts.builder().setHeaderParam("typ", "JWT")
				.setHeaderParam("regDate", System.currentTimeMillis())
				.setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * EXPIRE_MINUTES))
				.setSubject(subject).claim(key,data)
				.signWith(SignatureAlgorithm.HS256,this.generateKey()).compact();
		return jwt;
	}
	
	private byte[] generateKey() {
		try {
			return PRIVATE_KEY.getBytes("UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	@Override
	public boolean isUsable(String jwt) {
		try{
			Jws<Claims> claims = Jwts.parser()
					  .setSigningKey(this.generateKey())
					  .parseClaimsJws(jwt);
			return true;
			
		}catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	@Override
	public Map<String, Object> get(String key) {
		HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getRequest();
		String jwt = request.getHeader("access-token");
		Jws<Claims> claims = null;
		try {
			claims = Jwts.parser()
						 .setSigningKey(PRIVATE_KEY.getBytes("UTF-8"))
						 .parseClaimsJws(jwt);
		} catch (Exception e) {
			throw new UnAuthorizedException();
		}
	
		Map<String, Object> value = claims.getBody();
		return value;
	}
	
	@Override
	public String getUserId() {
		return (String) this.get("user").get("userid");
	}
	
}
