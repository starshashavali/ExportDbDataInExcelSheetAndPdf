package com.tcs.service;

import java.awt.Color;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.List;
import java.util.stream.Stream;

import com.lowagie.text.Chunk;
import com.lowagie.text.Document;
import com.lowagie.text.Element;
import com.lowagie.text.Font;
import com.lowagie.text.FontFactory;
import com.lowagie.text.Paragraph;
import com.lowagie.text.Phrase;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;
import com.tcs.entity.Emp;


public class DatabasePDFService {

	public static ByteArrayInputStream playerPDFReport(List<Emp> employees) {
		Document document = new Document();
		ByteArrayOutputStream out = new ByteArrayOutputStream();
		PdfWriter.getInstance(document, out);
		document.open();

		Font fontheader = FontFactory.getFont(FontFactory.TIMES_BOLD, 22);
		Paragraph para = new Paragraph("Emp structure", fontheader);
		para.setAlignment(Element.ALIGN_CENTER);
		document.add(para);
		document.add(Chunk.NEWLINE);

		PdfPTable table = new PdfPTable(3);
		Stream.of("empId", "name", "designation").forEach(headerTitle -> {
			PdfPCell header = new PdfPCell();
			Font headFont = FontFactory.getFont(FontFactory.TIMES_BOLD);
			header.setBackgroundColor(Color.CYAN);
			header.setHorizontalAlignment(Element.ALIGN_CENTER);
			header.setBorderWidth(2);
			header.setPhrase(new Phrase(headerTitle, headFont));
			table.addCell(header);

		});

		for (Emp emp : employees) {
			PdfPCell idCell = new PdfPCell(new Phrase(String.valueOf(emp.getEmpId())));
			idCell.setPaddingLeft(4);
			idCell.setVerticalAlignment(Element.ALIGN_MIDDLE);
			idCell.setHorizontalAlignment(Element.ALIGN_CENTER);
			table.addCell(idCell);

			PdfPCell firstNameCell = new PdfPCell(new Phrase(emp.getName()));
			firstNameCell.setPaddingLeft(4);
			firstNameCell.setVerticalAlignment(Element.ALIGN_MIDDLE);
			firstNameCell.setHorizontalAlignment(Element.ALIGN_CENTER);
			table.addCell(firstNameCell);

			PdfPCell lastNameCell = new PdfPCell(new Phrase(String.valueOf(emp.getDesignation())));
			lastNameCell.setVerticalAlignment(Element.ALIGN_MIDDLE);
			lastNameCell.setHorizontalAlignment(Element.ALIGN_CENTER);
			lastNameCell.setPaddingRight(4);
			table.addCell(lastNameCell);
		}
		document.add(table);
		document.close();
		return new ByteArrayInputStream(out.toByteArray());

	}

}

