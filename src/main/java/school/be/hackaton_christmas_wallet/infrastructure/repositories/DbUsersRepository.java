package school.be.hackaton_christmas_wallet.infrastructure.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import school.be.hackaton_christmas_wallet.infrastructure.dbEntities.DbUsers;

public interface DbUsersRepository extends JpaRepository<DbUsers, Long> {
}
