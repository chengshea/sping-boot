package com.cs.service;

import java.util.List;
import java.util.Map;

import org.springframework.web.multipart.MultipartFile;

public interface OCRService {

	public List<String> generalRecognition(MultipartFile file, String language_type);

	public Map<String, String> num();

}
