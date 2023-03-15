package com.cinemarecords.clientProxy;

import java.util.Optional;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.cloud.openfeign.FeignClientProperties.FeignClientConfiguration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.cinemarecords.model.Review;

@FeignClient(name = "movie-review-system", configuration = FeignClientConfiguration.class)
public interface ReviewSystemProxy {

	@GetMapping("/review/getReviewByMovieId")
	public Optional<Review> getReviewByMovieId(@RequestParam int movieId);
}
