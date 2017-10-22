package com.cs.util;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;

import javax.imageio.ImageIO;
import javax.imageio.ImageReader;
import javax.imageio.stream.ImageInputStream;


public class IMG {

	public static String getExtension(String path) {  
		 String str = null;
		 File file = new File(path);
	        ImageInputStream iis = null;  
	        try {  
	            iis = ImageIO.createImageInputStream(file);  
	            Iterator<ImageReader> iter = ImageIO.getImageReaders(iis);   
	            if(iter.hasNext()){  
	            	str = iter.next().getFormatName();
	            }  
	        } catch (IOException e) {  
	        	return null;  
	        }finally{  
	            if(iis!=null){  
	                try {  
	                    iis.close();  
	                } catch (IOException e) {  
	                    e.printStackTrace();  
	                }  
	            }  
	        }
			return str;  
	    }  
}
