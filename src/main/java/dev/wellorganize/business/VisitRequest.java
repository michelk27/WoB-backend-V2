package dev.wellorganize.business;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "visit_requests")
public class VisitRequest {
    @Id
    private String id;
    private String customerName;
    private String date;
    private String status;
    private boolean canceled;

    public VisitRequest() {
        this.customerName = "";
        this.date = "";
        this.status = "";
        this.canceled = false;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public boolean isCanceled() {
        return canceled;
    }

    public void setCanceled(boolean canceled) {
        this.canceled = canceled;
    }

    // Getters and setters
}
