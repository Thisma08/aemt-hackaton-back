package school.be.hackaton_christmas_wallet.infrastructure.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import school.be.hackaton_christmas_wallet.infrastructure.dbEntities.DbCategories;

public interface ICategoriesRepository extends JpaRepository<DbCategories, Long> {

}
