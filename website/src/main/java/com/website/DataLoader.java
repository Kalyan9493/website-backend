package com.website;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import com.website.model.User;
import com.website.repository.UserRepository;

@Component
public class DataLoader implements ApplicationRunner {

    private UserRepository userRepository;

    @Autowired
    public DataLoader(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void run(ApplicationArguments args) {
        userRepository.save(new User("Keyansh", "Tech", "admin@keyanshtech.com", 9493609939L, "1-103/hyderabad", "admin@keyanshtech.com", "admin123" ));
    }
}
