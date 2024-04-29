package co.develhope.unitTest.Controllers;

import co.develhope.unitTest.Entities.UserEntity;
import co.develhope.unitTest.Repositories.UserRepository;
import co.develhope.unitTest.Service.UserService;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserService userService;

    @PostMapping("/createUser")
    public @ResponseBody UserEntity create(@RequestBody UserEntity personalUser) {
        return userRepository.save(personalUser);
    }
    @GetMapping("/")
    public @ResponseBody List<UserEntity> getAllUsers() {
        return userRepository.findAll();
    }
    @GetMapping("/{id}")
    public @ResponseBody UserEntity getSingleUserById(@PathVariable Long id) {
        Optional<UserEntity> user = userRepository.findById(id);
        if (user.isPresent()) {
            return user.get();
        } else {
            return null;
        }
    }
    @PutMapping("/{id}")
    public @ResponseBody UserEntity update(@PathVariable Long id, @RequestBody @NonNull UserEntity personalUser) {
        personalUser.setId(id);
        personalUser.setName(personalUser.getName());
        personalUser.setSurname(personalUser.getSurname());
        personalUser.setAge(personalUser.getAge());
        return userRepository.save(personalUser);
    }
    @PutMapping("/{id}/activation")
    public @ResponseBody UserEntity setUserActive(@PathVariable Long id, @RequestParam("activated") boolean activated) {
        return userService.setUserActivationStatus(id, activated);
    }
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        userRepository.deleteById(id);
    }
}
