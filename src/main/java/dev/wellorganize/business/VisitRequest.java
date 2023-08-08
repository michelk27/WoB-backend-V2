package dev.wellorganize.business;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "visit_requests")
public class VisitRequest {
    @Id
    private String id;
    private String customerName;
    private String date;
    private boolean canceled;

}

