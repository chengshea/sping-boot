package com.cs.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Service;

import com.cs.service.CallBack;
import com.iflytek.cloud.speech.RecognizerListener;
import com.iflytek.cloud.speech.RecognizerResult;
import com.iflytek.cloud.speech.SpeechConstant;
import com.iflytek.cloud.speech.SpeechError;
import com.iflytek.cloud.speech.SpeechRecognizer;
import com.iflytek.cloud.speech.SpeechUtility;


public class MediaTool {
	private static  Logger logger = LoggerFactory.getLogger(MediaTool.class);
	
	@Value("${MSC.ID}")
	public String id;
	
	private CallBack  callb;
	
	public MediaTool(CallBack cb) {
          callb=cb;
	}



	public  void doSomeThing(String url,
	 		   String domain,String language,String accent,String sid){
		StringBuffer mResult =new StringBuffer();
		  SpeechUtility.createUtility("appid="+id);
		  
		  //1.创建SpeechRecognizer对象  
   	   
  		byte[] voiceBuffer = null;
  		FileInputStream fis = null;
  		try {
  			fis = new FileInputStream(new File(url));
  			voiceBuffer = new byte[fis.available()];
  			fis.read(voiceBuffer);
  		} catch (Exception e) {
  			e.printStackTrace();
  		} finally {
  			try {
  				if (null != fis) {
  					fis.close();
  					fis = null;
  				}
  			} catch (IOException e) {
  				e.printStackTrace();
  			}
  		}
  		// 2、音频流听写
  		if (0 == voiceBuffer.length) {
  			logger.error("没有可用音频文件!");
  		} else {
  	   SpeechRecognizer mIat= SpeechRecognizer.createRecognizer( );  
  	   //2.设置听写参数
  	   mIat.setParameter(SpeechConstant.DOMAIN, "iat");  //应用领域 短信和日常用语：iat (默认)
  	   if("zh_cn".equals(language) || "en_us".equals(language))
  	   mIat.setParameter(SpeechConstant.LANGUAGE, language);//语言设置  zh_cn  en_us
  	   mIat.setParameter (SpeechConstant.ACCENT, "mandarin "); //方言 普通话：mandarin(默认) 粤 语：cantonese 四川话：lmz 河南话：henanese
  	   mIat.setParameter(SpeechConstant.AUDIO_SOURCE, "-1"); //写入-1 
  	   mIat.setParameter( SpeechConstant.RESULT_TYPE, "plain" );//结果类型包括：xml, json, plain。xml和json
//  	   mIat.setParameter( SpeechConstant.SAMPLE_RATE,"8000");
  	   mIat.setParameter( SpeechConstant.NET_TIMEOUT,"30000");
  	   mIat.setParameter( SpeechConstant.ENGINE_TYPE,"cloud");
//  	   // 设置语音前端点  
//         mIat.setParameter(SpeechConstant.VAD_BOS, "4000");  
//         // 设置语音后端点  
//         mIat.setParameter(SpeechConstant.VAD_EOS, "1000");  
		//3.开始听写  
  	   mIat.startListening(new RecognizerListener(){  
 			
      	   public void onResult(RecognizerResult results, boolean isLast) {  
      	             logger.info("Result: "+results.getResultString ());  
      	             mResult.append(results.getResultString());
      	             if(isLast){
      	            	 logger.info ("识别结果为:" + mResult.toString());
      	            	 callb.callback(mResult.toString());
      	      
      	            	mResult.setLength(0);
      	             }
      	       }  
  	
      	   //会话发生错误回调接口  
      	       public void onError(SpeechError error) {  
      	    	   logger.info("*************" + error.toString()
  					+ "*************"+error.getErrorDesc()+"***********");
      	              
      	        }  
      	       //开始录音  
      	       public void onBeginOfSpeech() {}  
      	       //音量值0~30  
      	       public void onVolumeChanged(int volume){}  
      	       //结束录音  
      	       public void onEndOfSpeech() {}  
      	       //扩展用接口  
      	       public void onEvent(int eventType,int arg1,int arg2,String msg) {}
      	   });  
  	   //voiceBuffer为音频数据流，splitBuffer为自定义分割接口，将其以4.8k字节分割成数组  
  	   ArrayList<byte[]> buffers = splitBuffer(voiceBuffer,voiceBuffer.length, 48000);  
  	               for (int i = 0; i < buffers.size(); i++) {  
  	   // 每次写入msc数据4.8K,相当150ms录音数据  
  	                   mIat.writeAudio(buffers.get(i), 0, buffers.get(i).length);  
  	                   try {  
  	                       Thread.sleep(150);  
  	                   } catch (InterruptedException e) {  
  	                       e.printStackTrace();  
  	                   }  
  	               }  
  	               
  	        mIat.stopListening();  
  	            
  	         
  		}
	       // 删除本地
	        File img = new File(url);
	         if(img.exists())
	        	  img.delete();
	         logger.info("delete"+img);

     }
  		/**
  		 * 将字节缓冲区按照固定大小进行分割成数组
  		 * 
  		 * @param buffer
  		 *            缓冲区
  		 * @param length
  		 *            缓冲区大小
  		 * @param spsize
  		 *            切割块大小
  		 * @return
  		 */
  		public  ArrayList<byte[]> splitBuffer(byte[] buffer, int length, int spsize) {
  			ArrayList<byte[]> array = new ArrayList<byte[]>();
  			if (spsize <= 0 || length <= 0 || buffer == null
  					|| buffer.length < length)
  				return array;
  			int size = 0;
  			while (size < length) {
  				int left = length - size;
  				if (spsize < left) {
  					byte[] sdata = new byte[spsize];
  					System.arraycopy(buffer, size, sdata, 0, spsize);
  					array.add(sdata);
  					size += spsize;
  				} else {
  					byte[] sdata = new byte[left];
  					System.arraycopy(buffer, size, sdata, 0, left);
  					array.add(sdata);
  					size += left;
  				}
  			}
  			return array;
  		}
    
  		
	
		  
  		
}
