package com.cos.naverrealtime.web;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cos.naverrealtime.domain.News;
import com.cos.naverrealtime.domain.NewsRepository;
import com.cos.naverrealtime.util.DataStart;
import com.cos.naverrealtime.util.NaverCraw;

import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Flux;
import reactor.core.scheduler.Schedulers;

@RequiredArgsConstructor
@RestController
public class NewsController {

	private final NewsRepository newsRepository;
	private final NaverCraw naverCraw;

	String start = DataStart.sDay();
	String end = DataStart.eDay();

	@CrossOrigin
	@GetMapping(value = "/news", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
	public Flux<News> findAll() {
		return newsRepository.mFindAll().subscribeOn(Schedulers.boundedElastic());
	}
}
