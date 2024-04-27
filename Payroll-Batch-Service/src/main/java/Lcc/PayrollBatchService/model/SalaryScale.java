package Lcc.PayrollBatchService.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;


@Entity
@Data
@Table(name = "salary_scales")
public class SalaryScale {

    @Id
    private String salaryScale;
    private String division;
    private String description;
}
