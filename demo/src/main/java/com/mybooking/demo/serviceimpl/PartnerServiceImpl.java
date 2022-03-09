package com.mybooking.demo.serviceimpl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mybooking.demo.constant.AccessRole;
import com.mybooking.demo.dto.partner.PartnerDetailsForAdminDTO;
import com.mybooking.demo.dto.partner.TheaterRequestDto;
import com.mybooking.demo.dto.partner.TheaterResponseDto;
import com.mybooking.demo.exceptions.RecordNotFoundException;
import com.mybooking.demo.model.rdbms.Customer;
import com.mybooking.demo.model.rdbms.Screen;
import com.mybooking.demo.model.rdbms.Theater;
import com.mybooking.demo.repository.rdbms.CustomerRepository;
import com.mybooking.demo.repository.rdbms.TheaterRepository;
import com.mybooking.demo.service.PartnerService;

@Service
public class PartnerServiceImpl implements PartnerService {

	private CustomerRepository customerRepository;
	private TheaterRepository theaterRepository;

	@Autowired
	public PartnerServiceImpl(CustomerRepository customerRepository, TheaterRepository theaterRepository) {
		this.customerRepository = customerRepository;
		this.theaterRepository = theaterRepository;
	}

	@Override
	public List<TheaterResponseDto> getTheaterDetails(Integer partnerId) {
		List<Theater> theaters = theaterRepository.findByPartnerId(partnerId);
		List<TheaterResponseDto> list = new ArrayList<>(theaters.size());
		theaters.forEach(
				theater -> list.add(new TheaterResponseDto(theater.getId(), theater.getName(), theater.getPartnerId(),
						theater.getScreens().stream().collect(Collectors.toMap(Screen::getId, Screen::getName)),
						theater.getCityId())));
		return list;
	}

	@Override
	public Boolean addTheaterAndScreens(Integer partnerId, TheaterRequestDto dto) {
		Set<Screen> screens = dto.getScreens().stream()
				.map(s -> new Screen(s.getName(), s.getCapacity(), partnerId, partnerId, new Date(), new Date()))
				.collect(Collectors.toSet());
		var theater = new Theater(dto.getName(), partnerId, dto.getCityId(), dto.getAddress(), dto.getPincode(),
				partnerId, partnerId, new Date(), new Date());
		screens.forEach(theater::addScreen);
		theaterRepository.save(theater);
		return true;
	}

	@Override
	public Boolean updateTheaterAndScreens(Integer partnerId, TheaterRequestDto dto) throws RecordNotFoundException {
		List<Theater> theaters = theaterRepository.findByPartnerId(partnerId);
		if (theaters == null || theaters.isEmpty()) {
			throw new RecordNotFoundException("Theater Not Found");
		}
		// continue: MANAN
		return true;
	}

	@Override
	public List<PartnerDetailsForAdminDTO> getAllPartners() {
		List<Customer> partners = customerRepository.findByType(AccessRole.PARTNER.getValue());
		return partners.stream().map(partner -> new PartnerDetailsForAdminDTO(partner.getId(), partner.getFirstName(),
				partner.getLastName(), partner.getEmail(), partner.getType())).collect(Collectors.toList());
	}
}
