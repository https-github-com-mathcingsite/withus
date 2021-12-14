package com.project.withus.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.withus.model.DemoDto;
import com.project.withus.model.service.DemoService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@RestController
@RequestMapping("/demo")
@Api("데모 컨트롤러 API")
public class DemoController {
	
	private static final String SUCCESS = "success";
	private static final String FAIL = "fail";
	@Autowired
	private DemoService demoService;
	
	@ApiOperation(value = "데모파일 작성", notes = "새로운 데이터 작성. 그리고 DB입력 성공여부에 따라 'success' 또는 'fail' 문자열을 반환한다.", response = String.class)
	@PostMapping
	public ResponseEntity<String> writeArticle(@RequestBody @ApiParam(value = "데모파일 정보.", required = true) DemoDto demoDto) throws Exception {
		if (demoService.writeDemo(demoDto)) {
			return new ResponseEntity<String>(SUCCESS, HttpStatus.OK);
		}
		return new ResponseEntity<String>(FAIL, HttpStatus.NO_CONTENT);
	}
	
}
