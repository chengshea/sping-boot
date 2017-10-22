package com.cs.util;


import java.io.File;
import java.io.IOException;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.RequestContext;


public class UploadFile {
	 final static Logger       logger = LoggerFactory.getLogger(UploadFile.class);  
	     //音频
	 public static String load(MultipartFile file) {
			// 原图
			StringBuffer toUrl = new StringBuffer();
		
	     String suffix = null; 
	   
         if (file != null) {
                 String filename = file.getOriginalFilename();
          if( filename!= null && filename.length() >0)
                    suffix = filename.substring(filename
                                 .lastIndexOf("."));// 后缀名
	                             
                          // 判断文件类型是否符合规范
                          if (".jpg".equalsIgnoreCase(suffix) ||
                            	  ".png".equalsIgnoreCase(suffix) 
                            	) {
                            	 //随机生成名
                                  String name =System.nanoTime() + suffix;
                         
                            		// 绝对路径项目名称+分隔符+upload+分隔符
            						String sb=new StringBuffer().append("/upload").append("/").append("/").append(name).toString();
            						
            						File userFile = new File(toUrl.toString());
            		
                                 	if(!userFile.exists()){
                                 		userFile.mkdirs();
                             		}
                                 	String root = RequestContext.class.getResource("/").getFile();
                                	String path = null;
									try {
										path = new File(root).getParentFile().getParentFile().getCanonicalPath();
									} catch (IOException e1) {
										e1.printStackTrace();
									}
                                	
                                 	// 文件类的toString字符串+分隔符+纳秒
                                 	toUrl.append(path).append(sb);
				
						// 上传
						try {
							File img = new File(toUrl.toString());
							File parent = img.getParentFile();
							if (!parent.exists()) {
								parent.mkdirs();
							}
							// 保存文件
							file.transferTo(new File(toUrl.toString()));
							logger.info("存储路径" + toUrl.toString());
						} catch (Exception e) {
							e.printStackTrace();
							logger.error("存储出错:" + toUrl.toString());
						}
                      
                            return toUrl.toString();
                                    
                 } else {
                	 logger.error("不符合格式的文件!");
                         return null;
                 }
                    
             }
	    
	     return  null;
	   }
	
}
