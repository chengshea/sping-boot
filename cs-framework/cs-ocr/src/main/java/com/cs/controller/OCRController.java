package com.cs.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.cs.service.OCRService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@Api( description = "识别")
@Controller
@RequestMapping("/api/ocr")
public class OCRController {
    
	 final Logger       logger = LoggerFactory.getLogger(OCRController.class);  
	 
     @Autowired
	private OCRService  ocrService;
	 
	 @ApiOperation(value="通用识别",notes="一般识别")
	 @RequestMapping(value="/general",method=RequestMethod.POST)
	 @ResponseBody
	 public  Map<String,Object> ocrGeneral(
			 @ApiParam(  value="文件",required = true) MultipartFile file,
			 @ApiParam(value="识别语言类型，默认为CHN_ENG")
	          @RequestParam(value="language_type",required=true,defaultValue="CHN_ENG") String language_type
			){
		 Map<String, Object> map = new HashMap<String, Object>();
		 List<String> object = ocrService.generalRecognition(file, language_type);
		
		 if (object!=null && !object.isEmpty()) {
				map.put("status", 1);
				map.put("msg", "识别成功");
				map.put("data", object);
                  
			} else {
				map.put("status", 0);
				map.put("msg", "失败");
				map.put("data", "错误");
			}
			return map;
		 
	 }
	
	 
	
	 @ApiOperation(value="使用次数",notes="使用次数")
	 @RequestMapping(value="/num",method=RequestMethod.GET)
	 @ResponseBody
	 public  Map<String,Object> getNum(
			 ){
		 Map<String, Object> map = new HashMap<String, Object>();
		
	    Map<String, String> num = ocrService.num();
		
				map.put("status", 1);
				map.put("msg", "使用次数");
				map.put("data", num);
			
			return map;
		 
	 }
}