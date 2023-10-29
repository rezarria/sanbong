package io.rezarria.sanbong.security.service;

import io.rezarria.sanbong.security.model.User;
import io.rezarria.sanbong.security.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public void create(User user) {
        userRepository.save(user);
    }
}
