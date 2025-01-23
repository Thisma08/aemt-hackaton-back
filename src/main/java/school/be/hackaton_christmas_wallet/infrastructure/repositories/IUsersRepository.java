package school.be.hackaton_christmas_wallet.infrastructure.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import school.be.hackaton_christmas_wallet.domains.User;
import school.be.hackaton_christmas_wallet.infrastructure.dbEntities.DbUsers;

import java.util.Optional;

public interface IUsersRepository extends JpaRepository<DbUsers, Long> {
    Optional<User> findByUsername(String username);
}
