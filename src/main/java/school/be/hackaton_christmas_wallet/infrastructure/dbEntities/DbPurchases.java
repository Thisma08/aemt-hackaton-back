package school.be.hackaton_christmas_wallet.infrastructure.dbEntities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;
import java.time.LocalDateTime;

@Entity
@Table(name = "purchases")
@Data
@NoArgsConstructor
public class DbPurchases {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private float amount;

    @Column(name = "purchasedate")
    private Timestamp purchaseDate;

    @ManyToOne
    @JoinColumn(name = "userid", referencedColumnName = "id")
    private DbUsers user;

    @ManyToOne
    @JoinColumn(name = "categoryid", referencedColumnName = "id")
    private DbCategories category;

    @ManyToOne
    @JoinColumn(name = "budgetid", referencedColumnName = "id")
    private DbBudgets budget;
}

