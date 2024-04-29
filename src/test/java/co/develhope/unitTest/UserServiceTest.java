package co.develhope.unitTest;

import co.develhope.unitTest.Entities.UserEntity;
import co.develhope.unitTest.Repositories.UserRepository;
import co.develhope.unitTest.Service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class UserServiceTest {
    @Autowired
    private UserService userService;
    @Autowired
    private UserRepository userRepository;
    @Test
    void checkUserActivating() throws Exception {
        UserEntity personalUser = new UserEntity();
        personalUser.setId(personalUser.getId());
        personalUser.setActive(true);
        personalUser.setName("Alessio");
        personalUser.setSurname("Straforini");
        personalUser.setAge(32);

        UserEntity userFromDB = userRepository.save(personalUser);
        assertThat(userFromDB).isNotNull();
        assertThat(userFromDB.getId()).isNotNull();

        UserEntity userFromService = userService.setUserActivationStatus(personalUser.getId(), true);
        assertThat(userFromService).isNotNull();
        assertThat(userFromService.getId()).isNotNull();
        assertThat(userFromService.isActive()).isTrue();

        UserEntity userFromFind = userRepository.findById(userFromDB.getId()).get();
        assertThat(userFromFind).isNotNull();
        assertThat(userFromFind.getId()).isNotNull();
        assertThat(userFromFind.getId()).isEqualTo(userFromDB.getId());
        assertThat(userFromService.isActive()).isTrue();
    }
}
