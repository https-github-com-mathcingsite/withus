package com.project.withus.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.withus.model.DemoDto;
import com.project.withus.model.mapper.DemoMapper;
/**
 * 예시 ServiceImpl class 구조
 *
 */

@Service
public class DemoServiceImpl implements DemoService {
	
	@Autowired
	private DemoMapper demoMapper;
	
	@Override
	public boolean writeDemo(DemoDto demoDto) throws Exception{
		
		return demoMapper.writeDemo(demoDto) == 1;
	};
	
	
}
