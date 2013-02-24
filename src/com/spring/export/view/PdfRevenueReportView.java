package com.spring.export.view;

import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.view.document.AbstractPdfView;

import com.lowagie.text.Document;
import com.lowagie.text.Table;
import com.lowagie.text.pdf.PdfWriter;

public class PdfRevenueReportView extends AbstractPdfView{


	protected void buildPdfDocument(Map model, Document document,
			PdfWriter writer, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		Map<String,String> revenueData = (Map<String,String>) model.get("monthlyData");
		
		Table table = new Table(2);
		table.addCell("Month");
		table.addCell("Quantity");
		
		for (Map.Entry<String, String> entry : revenueData.entrySet()) {

			table.addCell(entry.getKey());
			table.addCell(entry.getValue());
			
        }
		
		document.add(table);
	}
}