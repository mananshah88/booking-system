package com.mybooking.demo.service;

import java.util.List;

import com.mybooking.demo.dto.search.SearchRequestDto;
import com.mybooking.demo.dto.search.SearchResponseDto;

public interface MovieSearchService {

	public List<SearchResponseDto> getMovieList(SearchRequestDto searchRequest);

}
