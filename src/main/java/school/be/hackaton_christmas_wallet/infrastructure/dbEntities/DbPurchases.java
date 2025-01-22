package school.be.hackaton_christmas_wallet.infrastructure.dbEntities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

import lombok.*;

@Entity
@Table(name = "purchases")
@Data
@NoArgsConstructor
@ToString(exclude = {"category", "budget"})
public class DbPurchases {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private float amount;

    @Column(name = "purchasedate")
    private LocalDateTime purchaseDate;

    @ManyToOne
    @JoinColumn(name = "categoryid", referencedColumnName = "id")
    private DbCategories category;

    @ManyToOne
    @JoinColumn(name = "budgetid", referencedColumnName = "id")
    private DbBudgets budget;
}


