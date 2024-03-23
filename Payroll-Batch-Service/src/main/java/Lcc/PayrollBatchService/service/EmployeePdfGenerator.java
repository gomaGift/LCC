package Lcc.PayrollBatchService.service;

import Lcc.PayrollBatchService.model.Employee;
import com.lowagie.text.*;
import com.lowagie.text.Font;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;

import java.awt.*;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.stream.Stream;

public class EmployeePdfGenerator {
    public static ByteArrayInputStream generate(List<Employee> employeeList) throws IOException {
        Document document = new Document(PageSize.A4);
        ByteArrayOutputStream out = new ByteArrayOutputStream();

        try {

            PdfWriter.getInstance(document, out);
            document.open();


                    Font fontTitle = FontFactory.getFont(FontFactory.TIMES_ROMAN);
            fontTitle.setSize(20);
            Paragraph paragraph1 = new Paragraph("Employee Payroll", fontTitle);
            paragraph1.setAlignment(Paragraph.ALIGN_CENTER);
            document.add(paragraph1);
            PdfPTable table = new PdfPTable(4);
            table.setWidthPercentage(100f);
            table.setWidths(new int[] {5,5,5,5});
            table.setSpacingBefore(5);
            PdfPCell cell = new PdfPCell();
            cell.setBackgroundColor(Color.LIGHT_GRAY);
            cell.setPadding(5);
        

            Font font = FontFactory.getFont(FontFactory.TIMES_ROMAN);
            font.setColor(Color.WHITE);
            

            cell.setPhrase(new Phrase("ID", font));
            table.addCell(cell);
            cell.setPhrase(new Phrase("Department", font));
            table.addCell(cell);
            cell.setPhrase(new Phrase("Position", font));
            table.addCell(cell);
            cell.setPhrase(new Phrase("Salary", font));
            table.addCell(cell);

            for (Employee employee: employeeList) {

            table.addCell(String.valueOf(employee.getId()));
            
            table.addCell(employee.getDepartment());
            
            table.addCell(employee.getPosition());
            
            table.addCell(String.valueOf(employee.getSalary()));
            }

            document.add(table);

            document.close();
        } catch (DocumentException e) {
            e.printStackTrace();
        }

        return new ByteArrayInputStream(out.toByteArray());
    }

}


