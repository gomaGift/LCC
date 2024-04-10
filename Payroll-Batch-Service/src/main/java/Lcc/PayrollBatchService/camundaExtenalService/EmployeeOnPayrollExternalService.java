package Lcc.PayrollBatchService.camundaExtenalService;

import Lcc.PayrollBatchService.model.EmployeeOnPayroll;
import Lcc.PayrollBatchService.service.EmployeeOnPayrollService;
import lombok.RequiredArgsConstructor;
import org.camunda.bpm.client.spring.annotation.ExternalTaskSubscription;
import org.camunda.bpm.client.task.ExternalTask;
import org.camunda.bpm.client.task.ExternalTaskHandler;
import org.camunda.bpm.client.task.ExternalTaskService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

/*
   Adds existing employees to the payroll
 */
@ExternalTaskSubscription(
        topicName = "PutEmployeeOnPayroll",
        processDefinitionKey = "employeeToPayroll",
        includeExtensionProperties = true,
        variableNames = "employeeId",
        autoOpen = false
)
@RequiredArgsConstructor
@Service
public class EmployeeOnPayrollExternalService implements ExternalTaskHandler {

    private final EmployeeOnPayrollService employeeOnPayrollService;
    Logger LOG = LoggerFactory.getLogger(EmployeeOnPayroll.class);

    @Override
    public void execute(ExternalTask externalTask, ExternalTaskService externalTaskService) {

            String employeeId = externalTask.getVariable("employeeId");
            EmployeeOnPayroll employee = new EmployeeOnPayroll(employeeId);
            EmployeeOnPayroll savedEmployee =  employeeOnPayrollService.save(employee);
            LOG.info("Employee with Id {} successfully put on Payroll on {}", savedEmployee.getEmployeeId(),savedEmployee.getDateStarted());
            externalTaskService.complete(externalTask);
    }
}
