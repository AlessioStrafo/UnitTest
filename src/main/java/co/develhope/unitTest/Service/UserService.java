package co.develhope.unitTest.Service;

import co.develhope.unitTest.Entities.UserEntity;
import co.develhope.unitTest.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public UserEntity setUserActivationStatus(Long userId, boolean isActive) {
        Optional<UserEntity> user = userRepository.findById(userId);
        if (!user.isPresent()) return null;
        user.get().setActive(isActive);
        return userRepository.save(user.get());
    }
}
