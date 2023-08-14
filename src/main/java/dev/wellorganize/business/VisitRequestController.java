package dev.wellorganize.business;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:3000")
public class VisitRequestController {
    @Autowired
    private VisitRequestRepository visitRequestRepository;

    public VisitRequestController(VisitRequestRepository visitRequestRepository) {
        this.visitRequestRepository = visitRequestRepository;
    }

    @PostMapping("/visit-requests")
    public ResponseEntity<VisitRequest> createVisitRequest(@RequestBody VisitRequest visitRequest) {
        VisitRequest savedRequest = visitRequestRepository.save(visitRequest);
        return ResponseEntity.ok(savedRequest);
    }

    @GetMapping("/visit-requests/{id}")
    public ResponseEntity<VisitRequest> getVisitRequest(@PathVariable String id) {
        VisitRequest request = visitRequestRepository.findById(id).orElse(null);
        if (request == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(request);
    }

    @GetMapping("/last-visit")
    public ResponseEntity<VisitRequest> getLastVisitRequest() {
        List<VisitRequest> requests = visitRequestRepository.findAll();

        if (requests.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        VisitRequest lastVisit = requests.get(requests.size() - 1);
        return ResponseEntity.ok(lastVisit);
    }

    @GetMapping("/visit-requests")
    public ResponseEntity<List<VisitRequest>> getAllVisitRequests() {
        List<VisitRequest> requests = visitRequestRepository.findAll();
        return ResponseEntity.ok(requests);
    }
}

