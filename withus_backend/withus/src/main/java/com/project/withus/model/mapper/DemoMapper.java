package com.project.withus.model.mapper;

import java.sql.SQLException;

import org.apache.ibatis.annotations.Mapper;

import com.project.withus.model.DemoDto;

@Mapper
public interface DemoMapper {
	public int writeDemo(DemoDto demoDto) throws SQLException;
}
