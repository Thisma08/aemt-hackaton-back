package school.be.hackaton_christmas_wallet.infrastructure.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import school.be.hackaton_christmas_wallet.infrastructure.dbEntities.DbPurchases;

public interface IPurchasesRepository extends JpaRepository<DbPurchases, Long> {
}
