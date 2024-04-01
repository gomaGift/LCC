package Lcc.PayrollBatchService.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;


@Entity
@Data
public class SalaryScale {

    @Id
    private String salaryScale;
    private LocalDate dateFrom;
    private LocalDate dateTo;
    private double basicSalary;
}
