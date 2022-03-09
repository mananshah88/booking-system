package com.mybooking.demo.service;

import java.util.List;

import com.mybooking.demo.dto.partner.PartnerDetailsForAdminDTO;
import com.mybooking.demo.dto.partner.TheaterRequestDto;
import com.mybooking.demo.dto.partner.TheaterResponseDto;
import com.mybooking.demo.exceptions.RecordNotFoundException;

public interface PartnerService {

	public List<TheaterResponseDto> getTheaterDetails(Integer partnerId);

	public Boolean addTheaterAndScreens(Integer partnerId, TheaterRequestDto theaterScreenRequestDto);

	public Boolean updateTheaterAndScreens(Integer partnerId, TheaterRequestDto theaterScreenRequestDto)
			throws RecordNotFoundException;

	public List<PartnerDetailsForAdminDTO> getAllPartners();
}
