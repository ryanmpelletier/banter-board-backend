package com.banterboard.banterboardbackend.repositories;

import com.banterboard.banterboardbackend.model.Banter;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface BanterRepository extends MongoRepository<Banter, String> {

}
