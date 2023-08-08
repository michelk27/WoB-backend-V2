package dev.wellorganize.business;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface VisitRequestRepository extends MongoRepository<VisitRequest, String> {

}

