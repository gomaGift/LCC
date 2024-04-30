package Lcc.PayrollBatchService.model;

import jakarta.persistence.Embeddable;


import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class PayAsYouEarnCompositeKey implements Serializable {
    private int band;

    public PayAsYouEarnCompositeKey() {
    }

    public PayAsYouEarnCompositeKey(int band, int year) {
        this.band = band;
        this.year = year;
    }

    private int year;

    public int getBand() {
        return band;
    }

    public void setBand(int band) {
        this.band = band;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PayAsYouEarnCompositeKey that = (PayAsYouEarnCompositeKey) o;
        return band == that.band && year == that.year;
    }

    @Override
    public int hashCode() {
        return Objects.hash(band, year);
    }
}
