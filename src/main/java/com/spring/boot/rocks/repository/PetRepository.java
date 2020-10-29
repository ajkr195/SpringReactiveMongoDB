package com.spring.boot.rocks.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.data.mongodb.repository.Tailable;

import com.spring.boot.rocks.domain.Pet;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface PetRepository extends ReactiveMongoRepository<Pet, String> {

	@Tailable
	Flux<Pet> findWithTailableCursorBy();
	Mono<Pet> findPetById(String id);

}
