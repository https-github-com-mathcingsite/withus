package com.project.withus.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.withus.model.TeamInfoDto;
import com.project.withus.model.service.TeamInfoService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@RestController
@RequestMapping("/teams")
@Api("팀 정보 컨트롤러 API V1")
public class TeamInfoController {
	
	private static final Logger logger = LoggerFactory.getLogger(TeamInfoController.class);
	private static final String SUCCESS = "success";
	private static final String FAIL = "fail";
	
	@Autowired
	private TeamInfoService teaminfoService;
	
	@ApiOperation(value = "팀 모집 게시글 작성", notes = "새로운 팀을 모집한다. DB 입력 성공 여부에 따라 'success' 또는 'fail' 문자열은 반환한다",response=String.class)
	@PostMapping("/post/")
	public ResponseEntity<String> postTeamInfo(@RequestBody @ApiParam(value = "팀 정보", required = true)TeamInfoDto teaminfoDto) throws Exception{
		logger.info("postTeamInfo - 호출");
		if(teaminfoService.postTeamInfo(teaminfoDto)) {
			return new ResponseEntity<String>(SUCCESS, HttpStatus.OK);
		}
		return  new ResponseEntity<String>(FAIL, HttpStatus.NO_CONTENT);
	}

}
