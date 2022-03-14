package com.mybooking.demo.serviceimpl;

import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import com.mybooking.demo.base.BaseServiceImpl;
import com.mybooking.demo.dto.search.SearchRequestDto;
import com.mybooking.demo.dto.search.SearchResponseDto;
import com.mybooking.demo.model.nosql.Movie;
import com.mybooking.demo.service.MovieSearchService;

/*
 * Key Goal: Enable end customers to browse the platform to get access to movies across different cities, languages, and genres.
 */
@Service
public class MovieSearchServiceImpl extends BaseServiceImpl implements MovieSearchService {

	private Logger logger = LoggerFactory.getLogger(MovieSearchServiceImpl.class);

	private MongoTemplate mongoTemplate;

	@Autowired
	public MovieSearchServiceImpl(MongoTemplate mongoTemplate) {
		this.mongoTemplate = mongoTemplate;
	}

	@Override
	public List<SearchResponseDto> getMovieList(SearchRequestDto searchRequest) {
		logger.debug("search request:{}", searchRequest);
		var query = getQuery(searchRequest.getLanguages(), searchRequest.getGenres(), searchRequest.getCities());
		List<Movie> movies = mongoTemplate.find(query, Movie.class);
		return movies.stream().map(m -> new SearchResponseDto(m.getName(), m.getThumbnailUrl(), m.getTitle()))
				.collect(Collectors.toList());
	}

	private Query getQuery(List<String> languages, List<String> genres, List<Integer> cities) {
		var query = new Query();
		if (languages != null && !languages.isEmpty()) {
			query.addCriteria(Criteria.where("languages").in(languages));
		}
		if (genres != null && !genres.isEmpty()) {
			query.addCriteria(Criteria.where("genres").in(genres));
		}
		if (cities != null && !cities.isEmpty()) {
			query.addCriteria(Criteria.where("cities").in(cities));
		}
		logger.debug("query:{}", query);
		return query;
	}

}
