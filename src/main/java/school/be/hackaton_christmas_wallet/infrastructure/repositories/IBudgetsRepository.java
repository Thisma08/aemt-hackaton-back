package school.be.hackaton_christmas_wallet.infrastructure.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import school.be.hackaton_christmas_wallet.infrastructure.dbEntities.DbBudgets;

public interface IBudgetsRepository extends JpaRepository<DbBudgets, Long> {
}
