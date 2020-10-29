package com.spring.boot.rocks.controller;

import com.spring.boot.rocks.domain.Pet;
import com.spring.boot.rocks.repository.PetRepository;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Duration;

@Controller
public class PetController {

	private final PetRepository petRepository;

	public PetController(PetRepository petRepository) {
		this.petRepository = petRepository;
	}

	@GetMapping(value = "/pets", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
	@ResponseBody
	Flux<Pet> findPets() {
		return petRepository.findWithTailableCursorBy().delayElements(Duration.ofMillis(3000));
	}

	@GetMapping(value = "/pets/{id}")
	Mono<Pet> findById(@PathVariable String id) {
		return petRepository.findPetById(id);
	}

	@GetMapping("/")
	Mono<String> home() {
		return Mono.just("pets");
	}

}
