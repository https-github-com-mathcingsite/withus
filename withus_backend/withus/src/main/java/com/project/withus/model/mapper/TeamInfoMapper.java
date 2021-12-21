package com.project.withus.model.mapper;

import java.sql.SQLException;

import org.apache.ibatis.annotations.Mapper;

import com.project.withus.model.TeamInfoDto;


@Mapper
public interface TeamInfoMapper {

	public int postTeamInfo(TeamInfoDto teaminfoDto) throws SQLException;
}
