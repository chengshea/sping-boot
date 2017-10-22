package com.cs.service.impl;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.baidu.aip.ocr.AipOcr;
import com.cs.config.CustomOCR;
import com.cs.service.OCRService;
import com.cs.util.GetJson;
import com.cs.util.UploadFile;

@Service
public class OCRServiceImpl implements OCRService {

	
	
	  @Autowired  
      StringRedisTemplate stringRedisTemplate;  
        
      @Resource(name="stringRedisTemplate")  
      ValueOperations<String,String> valOpsStr;
	
	
	
	//通用识别
		@Override
		public   List<String> generalRecognition(MultipartFile file,String language_type){
			AipOcr client = CustomOCR.client();
			List<String> ls = null;
		
			 String url = UploadFile.load(file);
	      // 自定义参数定义
	      HashMap<String, String> options = new HashMap<String, String>();
	      options.put("detect_direction", "false");
		  options.put("language_type", language_type);
		   

	      
		      JSONObject response = null;
		      try {
		    	// 参数为本地图片路径
		    	  response= client.basicGeneral(url, options);
		    	  valOpsStr.increment("ocr_count",1);
		      }catch (Exception e){
		    	  e.printStackTrace();
		      }
		      if(response!=null){
		        ls= GetJson.json(response);
		        File img = new File(url);
		         if(img.exists())
		        	  img.delete();
		      }
	      return ls;
		}

		@Override
		public Map<String, String> num() {
			 Map<String, String> map = new HashMap<String, String>();
			 String num =valOpsStr.get("ocr_count");
			map.put("普通字识别", num);
			return map;
		} 
}
