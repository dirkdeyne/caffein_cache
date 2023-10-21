package io.getmedusa.demo;

import io.getmedusa.demo.model.DogsInHouse;
import io.getmedusa.demo.model.Lang;
import io.getmedusa.demo.service.DogsInHouseRepository;
import io.getmedusa.demo.service.DogsInHouseService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

import java.util.List;

@SpringBootApplication
public class DemoApplication {
	private static final Logger logger = LoggerFactory.getLogger(DemoApplication.class);
	private final DogsInHouseService service;
	private final DogsInHouseRepository repository;

	public DemoApplication(DogsInHouseService service, DogsInHouseRepository repository) {
		this.service = service;
		this.repository = repository;
	}

	@EventListener(ApplicationReadyEvent.class)
	public void tryout(){
		init();
		testCacheViaLogging();
	}

	private void testCacheViaLogging() {
		logger.info("one (1):" + service.findDogHouseEnFromDB("one"));
		logger.info("one (2):" + service.findDogHouseEnFromDB("one"));
		logger.info("two (1):" + service.findDogHouseEnFromDB("two"));
		logger.info("one (3):" + service.findDogHouseEnFromDB("one"));
		logger.info("two (2):" + service.findDogHouseEnFromDB("two"));
	}

	public void init() {
		List<DogsInHouse> examples = List.of(
				new DogsInHouse("one", Lang.EN,1L),
				new DogsInHouse("two", Lang.EN,2L),
				new DogsInHouse("three", Lang.EN,3L)
		);
		repository.saveAll(examples);
	}

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

}
