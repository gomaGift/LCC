package Lcc.PayrollBatchService.model;

import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;


@Entity
@Data
public class Salary_Scale {

    @Id
    private String salaryScale;
    private LocalDate dateFrom;
    private LocalDate dateTo;
    private BigDecimal basicSalary;
}
