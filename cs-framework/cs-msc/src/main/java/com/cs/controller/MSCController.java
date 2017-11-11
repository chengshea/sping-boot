package com.cs.controller;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.tomcat.jni.Buffer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.cs.util.MediaTool;
import com.cs.util.UploadFile;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;





@Api(value="讯飞语音")
@RestController
@RequestMapping("/api/msc")
public class MSCController {

	private static  Logger logger = LoggerFactory.getLogger(MSCController.class);
	
       @Autowired  
       StringRedisTemplate stringRedisTemplate;  
         
       @Resource(name="stringRedisTemplate")  
       ValueOperations<String,String> valOpsStr;
	   
       

	 
		@ApiOperation(value = "音频", notes = "识别音频文件")
		@RequestMapping(value = "/media", method = RequestMethod.POST)
		@ResponseBody
		public Map<String, Object> media(
		         @ApiParam(  value="音频文件",required = true) MultipartFile mfile,
		         HttpServletRequest request,@ApiParam(  value="应用领域  默认:日常",required = false)
	    @RequestParam(value = "domain",defaultValue="iat") 
		String domain,@ApiParam(  value="语言 zh_cn| en_us",required = false)
	    @RequestParam(value = "language",defaultValue="en_us") 
		String language,@ApiParam(  value="方言默认国语",required = false)
	    @RequestParam(value = "accent",defaultValue="mandarin") String accent) {
			long s = System.currentTimeMillis();
			String url = UploadFile.load(mfile);//上传
			
			
			 StringBuffer sb=new StringBuffer();
			 String sid= UUID.randomUUID().toString().replaceAll("-", "");
		
			   MediaTool tool = new MediaTool( (str)->{
					logger.info("calll---"+str);
				    sb.append(str);
				    valOpsStr.set(sid,str ,30,TimeUnit.MINUTES);
				        return str;  
				});
			   if(url!=null)
			       tool.doSomeThing(url, domain, language, accent,sid);
			
			
		Map<String, Object> map = new HashMap<String, Object>();
			
			if (sid!=null && url!=null) {
				map.put("status", 1);
				map.put("msg", "识别成功");
				map.put("data", sid);

			} else {
				map.put("status", 0);
				map.put("msg", "上传失败");
				map.put("data", null);
			}
			return map;
		}
	
		@ApiOperation(value = "识别", notes = "根据media返回标识获取结果")
		@RequestMapping(value = "/get", method = RequestMethod.POST)
		@ResponseBody
		public Map<String, Object> getStr(@ApiParam(  value="标识",required = true)
        @RequestParam(value = "sid") String sid){
				
			Map<String, Object> map = new HashMap<String, Object>();
			
			String str = valOpsStr.get(sid);
			 if(str==null){
				 try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				 str = valOpsStr.get(sid);
			 }
			
			
			if (str!=null) {
				map.put("status", 1);
				map.put("msg", "识别成功");
				map.put("data", str);

			} else {
				map.put("status", 0);
				map.put("msg", "识别失败");
				map.put("data", null);
			}
					return map;
		}

	
}
