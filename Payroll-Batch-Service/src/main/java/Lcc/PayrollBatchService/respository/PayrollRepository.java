package Lcc.PayrollBatchService.respository;

import Lcc.PayrollBatchService.model.Payroll;
import Lcc.PayrollBatchService.model.PayrollCompositeKey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface PayrollRepository extends JpaRepository<Payroll, PayrollCompositeKey> {


    @Query("SELECT p FROM Payroll p WHERE p.key.paymentDate = :payrollDate")
    List<Payroll> findRecordsByDate(String payrollDate);

    @Query("SELECT COALESCE(SUM(p.grossPay), 0) FROM Payroll p WHERE p.key.employeeId= :empId AND p.lastModified >= :startDate ")
    double findYtdGrossSalary(@Param("empId") String empId, @Param("startDate") Date startDate);

    @Query("SELECT COALESCE(sum(p.taxDue), 0) FROM Payroll p WHERE p.key.employeeId= :empId AND p.lastModified >= :startDate")
    double findTaxPaidYearToDate(String empId, Date startDate);

    @Query("SELECT p FROM Payroll p WHERE MONTH(p.lastModified) = :currentMonth AND YEAR(p.lastModified) = :currentYear")
    List<Payroll> findByMonthAndYear(int currentMonth, int currentYear);
}
