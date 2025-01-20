package school.be.hackaton_christmas_wallet.infrastructure.dbEntities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "budgets")
@Data
@NoArgsConstructor
public class DbBudgets {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private float budget;
    private int month;
    private int year;

    @OneToMany(mappedBy = "budget")
    private List<DbPurchases> purchases= new ArrayList<>();
}
