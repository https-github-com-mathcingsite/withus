package com.project.withus.controller;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.withus.model.UserDto;
import com.project.withus.model.service.JwtService;
import com.project.withus.model.service.UserService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@RestController
@RequestMapping("/user")
@Api("유저 컨트롤러 API")
public class UserController {

	private static final String SUCCESS = "success";
	private static final String FAIL = "fail";
	@Autowired
	private UserService userService;
	
	@Autowired
	private JwtService jwtService;
	
	@ApiOperation(value = "유저 회원가입", notes = "유저 등록. 그리고 DB입력 성공여부에 따라 'success' 또는 'fail' 문자열을 반환한다.", response = String.class)
	@PostMapping
	public ResponseEntity<String> insertUser(@RequestBody @ApiParam(value = "유저 데이터", required = true) UserDto userDto) throws Exception {
		if (userService.insertUser(userDto)) {
			return new ResponseEntity<String>(SUCCESS, HttpStatus.OK);
		}
		return new ResponseEntity<String>(FAIL, HttpStatus.NO_CONTENT);
	}
	
	@ApiOperation(value = "유저 로그인", notes = "유저 로그인. 그리고 DB입력 성공여부에 따라 'success' 또는 'fail' 문자열을 반환한다.", response = String.class)
	@PostMapping("/login")
	public ResponseEntity<Map<String, Object>> loginUser(@RequestBody @ApiParam(value = "로그인시 필요한 회원정보(아이디,비밀번호)", required = true) UserDto userDto) throws Exception {
		Map<String, Object> resultMap = new HashMap<>();
		HttpStatus status = null;
		try {
			UserDto loginUser = userService.login(userDto);
			if(loginUser !=null) {
				String token = jwtService.create("userid", loginUser.getUserId(), "access-token");
				System.out.println("로그인 토큰 정보 : " + token);
				resultMap.put("access-token" , token);
				resultMap.put("message" , SUCCESS);
				status = HttpStatus.ACCEPTED;
			}else {
				resultMap.put("message" , FAIL);
				status = HttpStatus.ACCEPTED;
			}
		} catch (Exception e) {
			System.out.println("로그인 실패 : " +  e);
			resultMap.put("message", e.getMessage());
			status = HttpStatus.INTERNAL_SERVER_ERROR;
		}
		return new ResponseEntity<Map<String, Object>>(resultMap, status);
	}
	
	@ApiOperation(value = "회원인증", notes = "회원 정보를 담은 Token을 반환한다.", response = Map.class)
	@GetMapping("/info/{userid}")
	public ResponseEntity<Map<String, Object>> getInfo(
			@PathVariable("userid") @ApiParam(value = "인증할 회원의 아이디.", required = true) String userId,
			HttpServletRequest request) {
		Map<String, Object> resultMap = new HashMap<>();
		HttpStatus status = HttpStatus.ACCEPTED;
		if (jwtService.isUsable(request.getHeader("access-token"))) {
			try {
				UserDto userDto = userService.getUserInfo(userId);
				resultMap.put("userInfo", userDto);
				resultMap.put("message", SUCCESS);
				status = HttpStatus.ACCEPTED;
			} catch (Exception e) {
				System.out.println("정보조회 실패 : " + e.getMessage());
				status = HttpStatus.INTERNAL_SERVER_ERROR;
			}
		} else {
			System.out.println("사용불가 토큰");
			resultMap.put("message", FAIL);
			status = HttpStatus.ACCEPTED;
		}
		return new ResponseEntity<Map<String, Object>>(resultMap, status);
	}
	
	@ApiOperation(value = "사용자 정보 수정", notes = "사용자의 정보를 수정한다. 그리고 DB 수정 성공여부에 따라 'success' 또는 'fail' 문자열을 반환한다.", response = String.class)
	@PutMapping
	public ResponseEntity<String> modifyUser(@RequestBody @ApiParam(value = "수정할 사용자 정보", required = true) UserDto userDto) throws Exception {
		if (userService.modifyUser(userDto)) {
			return new ResponseEntity<String>(SUCCESS, HttpStatus.OK);
		}
		return new ResponseEntity<String>(FAIL, HttpStatus.OK);
	}
	
	@ApiOperation(value = "사용자 정보 한 개 보기", notes = "사용자 번호에 해당하는 사용자의 정보를 반환한다.", response = UserDto.class)
	@GetMapping("/{userid}")
	public ResponseEntity<UserDto> getUser(@PathVariable("userid") @ApiParam(value = "얻어올 사용자의 번호.", required = true) String userId) throws Exception {
		return new ResponseEntity<UserDto>(userService.getUser(userId), HttpStatus.OK);
	}
	
}
