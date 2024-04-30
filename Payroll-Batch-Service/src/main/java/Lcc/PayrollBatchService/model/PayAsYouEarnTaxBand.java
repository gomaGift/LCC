package Lcc.PayrollBatchService.model;

import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "payAsYouEarnTaxBands")
public class PayAsYouEarnTaxBand {
    public PayAsYouEarnCompositeKey getKey() {
        return key;
    }
    public void setKey(PayAsYouEarnCompositeKey key) {
        this.key = key;
    }

    public PayAsYouEarnTaxBand(PayAsYouEarnCompositeKey key, double percentage, double upperBound) {
        this.key = key;
        this.percentage = percentage;
        this.upperBound = upperBound;
    }

    public PayAsYouEarnTaxBand() {
    }

    public double getPercentage() {
        return percentage;
    }

    public void setPercentage(double percentage) {
        this.percentage = percentage;
    }

    public double getUpperBound() {
        return upperBound;
    }

    public void setUpperBound(double upperBound) {
        this.upperBound = upperBound;
    }

    @EmbeddedId
    private PayAsYouEarnCompositeKey key;
    private double percentage;
    private double upperBound;

}
