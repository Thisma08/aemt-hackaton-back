package school.be.hackaton_christmas_wallet.controller;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/admin")
public class ControllerTest {

    @GetMapping()
    public ResponseEntity<String> Test() {
        return ResponseEntity.ok("test");
    }
}
