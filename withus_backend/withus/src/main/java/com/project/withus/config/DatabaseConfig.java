package com.project.withus.config;

/**
 * 데이터 베이스 관련
 * MapperScan을 위한 설정 class
 */

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@MapperScan(
		basePackages = "com.project.withus.model.mapper"
)
public class DatabaseConfig {}