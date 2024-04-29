package co.develhope.unitTest.Repositories;

import co.develhope.unitTest.Entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<UserEntity, Long> {
}
