package dev.wellorganize.business;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "visit_requests")
public class VisitRequest {
    @Id
    private String id;
    private String customerName;
    private String companyName;
    private String addresses;
    private String date;
    private String type;
    private String status;
    private boolean canceled;

    public VisitRequest() {
        this.customerName = "";
        this.companyName = "";
        this.addresses = "";
        this.date = "";
        this.type = "";
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getAddress() {
        return addresses;
    }

    public void setAddress(String addresses) {
        this.addresses = addresses;
    }
}
