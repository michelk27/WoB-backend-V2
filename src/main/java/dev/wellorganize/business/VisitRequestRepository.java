package dev.wellorganize.business;

import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface VisitRequestRepository extends MongoRepository<VisitRequest, String> {
//    List<VisitRequest> findByStatus(String status);
    List<VisitRequest> findByCustomerName(String customerName);
}

