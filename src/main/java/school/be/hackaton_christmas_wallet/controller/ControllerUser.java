package school.be.hackaton_christmas_wallet.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import school.be.hackaton_christmas_wallet.application.user.command.UserCommandProcessor;
import school.be.hackaton_christmas_wallet.application.user.command.login.LoginQuery;
import school.be.hackaton_christmas_wallet.application.user.command.register.RegisterQuery;

@RestController
@RequestMapping("/v1/user")
public class ControllerUser {
    private final UserCommandProcessor userCommandProcessor;

    public ControllerUser(UserCommandProcessor userCommandProcessor) {
        this.userCommandProcessor = userCommandProcessor;
    }
    @PostMapping("/register")
    public ResponseEntity<Boolean> registerUser(@RequestBody RegisterQuery query) {
        return ResponseEntity.ok(userCommandProcessor.registerUser(query));
    }

    @PostMapping("/login")
    public ResponseEntity<String> loginUser(@RequestBody LoginQuery query) {
        String token = userCommandProcessor.loginUser(query);
        return ResponseEntity.ok(token);
    }
}
