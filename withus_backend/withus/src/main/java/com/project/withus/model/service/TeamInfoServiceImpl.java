package com.project.withus.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.withus.model.TeamInfoDto;
import com.project.withus.model.mapper.TeamInfoMapper;

@Service
public class TeamInfoServiceImpl implements TeamInfoService {

	@Autowired
	private TeamInfoMapper teaminfoMapper;//-> no need for sqlSession if used
	
	@Override
	public boolean postTeamInfo(TeamInfoDto teaminfoDto) throws Exception {
	/*	if(teaminfoDto.getSubject() == null || teaminfoDto.getContent()==null){
			throw new Exception();
		}*/
		return teaminfoMapper.postTeamInfo(teaminfoDto)==1;
	}

}
