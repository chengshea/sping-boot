package com.cs.util;

import java.util.ArrayList;
import java.util.List;


import org.json.JSONException;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.gson.JsonParser;

public class GetJson {
	
	static Logger logger = LoggerFactory.getLogger(GetJson.class);
	
    public static  List<String>  json(JSONObject response){
		
		
		 List<String> ls = new ArrayList<String>();
		 try {
			 int i = Integer.parseInt(response.get("words_result_num").toString());
			if(i==0){//提取不到值图片
		      		return ls;
			}else{
			 String json = response.get("words_result").toString();
		      
		      	for (int j = 0; j < i; j++) {
		      		String str = new JsonParser().parse(json).getAsJsonArray().get(j).getAsJsonObject().get("words").getAsString();
		      		ls.add(str);
					}
			}
	      } catch (JSONException e) {
	    	  Object ob= null;
	    	  try {
		      		ob = response.get("error_msg");
		      		
					} catch (JSONException e1) {
						logger.error("获取不到error_msg字段");
						e1.printStackTrace();
					}
		      	if(ob!=null)
		      	    logger.info("返回error_msg>>>"+ob.toString());
				
			}
		 logger.info("list<words_result>>>"+ls);
      	return ls;
	}

}
