package school.be.hackaton_christmas_wallet.infrastructure.repositories;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import school.be.hackaton_christmas_wallet.infrastructure.dbEntities.DbBudgets;

import java.util.List;
import java.util.Optional;

public interface IBudgetsRepository extends JpaRepository<DbBudgets, Long> {
    @Query("SELECT DISTINCT b FROM DbBudgets b LEFT JOIN FETCH b.purchases p LEFT JOIN FETCH p.category")
    List<DbBudgets> findAllWithPurchasesAndCategories();
    Optional<DbBudgets> findByMonthAndYear(int month, int year);

}
