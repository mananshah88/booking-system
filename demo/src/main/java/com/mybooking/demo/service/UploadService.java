package com.mybooking.demo.service;

import com.mybooking.demo.dto.upload.UploadRequestDTO;

public interface UploadService {

	public Boolean uploadDetails(UploadRequestDTO uploadRequestDTO);
	
	public Boolean modifyDetails(UploadRequestDTO uploadRequestDTO);

}
