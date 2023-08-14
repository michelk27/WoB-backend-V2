package dev.wellorganize.business;

import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;

public interface VisitRequestRepository extends MongoRepository<VisitRequest, String> {

    List<VisitRequest> findByCustomerName(String customerName);
    Optional<VisitRequest> findById(String id);
}

