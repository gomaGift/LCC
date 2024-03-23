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
    public static ByteArrayInputStream generate(List<Employee> listOfEmployees) throws IOException {
        Document document = new Document();
        ByteArrayOutputStream out = new ByteArrayOutputStream();

        try {

            PdfWriter.getInstance(document, out);
            document.open();

            // Add Content to PDF file ->
            Font fontHeader = FontFactory.getFont(FontFactory.TIMES_BOLD, 22);
            Paragraph para = new Paragraph("Employee Payroll", fontHeader);
            para.setAlignment(Element.ALIGN_CENTER);
            document.add(para);
            document.add(Chunk.NEWLINE);

            PdfPTable table = new PdfPTable(4);
            // Add PDF Table Header ->
            Stream.of("ID", "Department", "Position", "Salary").forEach(headerTitle -> {
                PdfPCell header = new PdfPCell();
                Font headFont = FontFactory.getFont(FontFactory.TIMES_BOLD);
                header.setBackgroundColor(Color.LIGHT_GRAY);
                header.setHorizontalAlignment(Element.ALIGN_CENTER);
                header.setBorderWidth(1);
                header.setPhrase(new Phrase(headerTitle, headFont));
                table.addCell(header);
            });

            for (Employee employee : listOfEmployees) {
                PdfPCell idCell = new PdfPCell(new Phrase(String.valueOf(employee.getId())));
                idCell.setPaddingLeft(6);
                idCell.setVerticalAlignment(Element.ALIGN_MIDDLE);
                idCell.setHorizontalAlignment(Element.ALIGN_CENTER);
                table.addCell(idCell);
//
//                PdfPCell firstNameCell = new PdfPCell(new Phrase(employee.getFirstname()));
//                firstNameCell.setPaddingLeft(6);
//                firstNameCell.setVerticalAlignment(Element.ALIGN_MIDDLE);
//                firstNameCell.setHorizontalAlignment(Element.ALIGN_CENTER);
//                table.addCell(firstNameCell);
//
//                PdfPCell lastnameCell = new PdfPCell(new Phrase(employee.getLastname()));
//                lastnameCell.setPaddingLeft(4);
//                lastnameCell.setVerticalAlignment(Element.ALIGN_MIDDLE);
//                lastnameCell.setHorizontalAlignment(Element.ALIGN_CENTER);
//                table.addCell(lastnameCell);

                PdfPCell departmentCell = new PdfPCell(new Phrase(employee.getDepartment()));
                departmentCell.setPaddingLeft(6);
                departmentCell.setVerticalAlignment(Element.ALIGN_MIDDLE);
                departmentCell.setHorizontalAlignment(Element.ALIGN_CENTER);
                table.addCell(departmentCell);

                PdfPCell positionCell = new PdfPCell(new Phrase(String.valueOf(employee.getPosition())));
                positionCell.setVerticalAlignment(Element.ALIGN_MIDDLE);
                positionCell.setHorizontalAlignment(Element.ALIGN_CENTER);
                positionCell.setPaddingRight(6);
                table.addCell(positionCell);

                PdfPCell salaryCell = new PdfPCell(new Phrase(String.valueOf(employee.getSalary())));
                salaryCell.setVerticalAlignment(Element.ALIGN_MIDDLE);
                salaryCell.setHorizontalAlignment(Element.ALIGN_CENTER);
                salaryCell.setPaddingRight(6);
                table.addCell(salaryCell);

            }
            document.add(table);

            document.close();
        } catch (DocumentException e) {
            e.printStackTrace();
        }

        return new ByteArrayInputStream(out.toByteArray());
    }
}


