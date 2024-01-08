package org.example.IOLibrary;

import com.itextpdf.text.Document;
import com.itextpdf.text.html.simpleparser.HTMLWorker;
import com.itextpdf.text.pdf.PdfWriter;
import freemarker.template.Configuration;
import freemarker.template.Template;

import java.io.*;
import java.util.*;

public class Invoice {
    public static void createInvoice(Customer customer, String fileName) throws Exception {
        Configuration configuration = new Configuration(Configuration.VERSION_2_3_30);
        configuration.setClassForTemplateLoading(Main.class, "/templates");

        Template template = configuration.getTemplate("receipt.ftl");

        // Data model (replace with actual data)
        Map<String, Object> data = new HashMap<>();
        data.put("customerName", customer.getName());
        data.put("customerAddress", "24a bau cat");
        data.put("invoiceNumber", "CI-"+123);
        Date currentDate = new Date();
        data.put("invoiceDate", "1/4/2024");


        List<Map<String, String>> items = List.of(
                Map.of("description", "Burger", "quantity", "2", "price", "$20.00"),
                Map.of("description", "Fries", "quantity", "1", "price", "$5.00"),
                Map.of("description", "Smoothies", "quantity", "1", "price", "$2.50")
        );
        data.put("items", items);
        data.put("totalPrice", "27.50");

        // Create a PDF document
        Document document = new Document();
        PdfWriter.getInstance(document, new FileOutputStream(fileName));
        document.open();

        // Process the Freemarker template and generate HTML content
        StringWriter stringWriter = new StringWriter();
        template.process(data, stringWriter);
        String htmlContent = stringWriter.toString();

        // Use iText to convert HTML to PDF
        convertHtmlToPdf(htmlContent, document);

        // Close the document
        document.close();
    }

    public static void convertHtmlToPdf(String html, Document document) throws Exception {
        PdfWriter.getInstance(document, System.out);
        document.open();

        StringReader strReader = new StringReader(html);
        Reader reader = new BufferedReader(strReader);

        HTMLWorker htmlWorker = new HTMLWorker(document);
        htmlWorker.parse(reader);

        document.close();
    }

}
