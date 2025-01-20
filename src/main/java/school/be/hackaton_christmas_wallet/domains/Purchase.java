package school.be.hackaton_christmas_wallet.domains;

import lombok.Getter;

import java.util.Date;
import java.util.List;

@Getter
public class Purchase {
    private final Date date;
    private final float amount;
    private final String category;

    Purchase(Date date, float amount, String category) {
        this.date = date;
        this.amount = amount;
        this.category = category;
    }


}
