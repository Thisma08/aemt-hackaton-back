package school.be.hackaton_christmas_wallet.application.purchase.query.createPurchasing;

import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import school.be.hackaton_christmas_wallet.infrastructure.dbEntities.DbBudgets;
import school.be.hackaton_christmas_wallet.infrastructure.dbEntities.DbCategories;
import school.be.hackaton_christmas_wallet.infrastructure.dbEntities.DbUsers;

import java.time.LocalDateTime;

public class CreatePurchasingQuery {
//    private long id;
    public float amount;
    public LocalDateTime purchaseDate;
    public long categoryID;
    public long budgetId;
}
