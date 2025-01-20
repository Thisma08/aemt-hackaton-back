package school.be.hackaton_christmas_wallet.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/Budget")
public class ControllerBudget {

    @GetMapping()
    public ResponseEntity<String> GetBudget() {
        return ResponseEntity.ok("test");
    }
}
