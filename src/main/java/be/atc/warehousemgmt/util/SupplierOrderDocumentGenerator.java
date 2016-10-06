package be.atc.warehousemgmt.util;

import be.atc.warehousemgmt.model.entity.Person;
import be.atc.warehousemgmt.model.entity.catalog.Article;
import be.atc.warehousemgmt.model.entity.orders.OrderDetail;
import be.atc.warehousemgmt.model.entity.orders.Orders;
import be.atc.warehousemgmt.security.SecurityUtils;
import org.apache.commons.lang3.StringEscapeUtils;
import org.docx4j.model.datastorage.migration.VariablePrepare;
import org.docx4j.openpackaging.exceptions.Docx4JException;
import org.docx4j.openpackaging.packages.WordprocessingMLPackage;
import org.docx4j.openpackaging.parts.WordprocessingML.MainDocumentPart;
import org.docx4j.wml.ObjectFactory;
import org.docx4j.wml.Tbl;
import org.docx4j.wml.Tc;
import org.docx4j.wml.Tr;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import java.io.File;
import java.io.InputStream;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

/**
 * Created by ahmedidoumhaidi on 21/08/16.
 */

public class SupplierOrderDocumentGenerator {

    private static Logger logger = LoggerFactory.getLogger(SupplierOrderDocumentGenerator.class);
    private static ObjectFactory factory = new ObjectFactory();
    private final String supplierOrderTemplatePath = "document/SupplierOrderTemplateFile.docx";
    private final String templateFileName = "SupplierOrderTemplateFile";
    private WordprocessingMLPackage wordMLPackage;
    private MainDocumentPart documentPart;
    private String temporaryDirectory = "/tmp/";

    public void generateSupplierOrderDocument(Orders orders, List<OrderDetail> orderDetails) throws Exception {
        process(orders, orderDetails);
    }

    public void process(Orders orders, List<OrderDetail> orderDetails) throws Exception {
        String targetFile = "";
        try {
            openDocument();
            generateContent(orders, orderDetails);
            removeAllFirstTableRow(wordMLPackage);
            targetFile = getTargetFile();
            wordMLPackage.save(new File(targetFile));
        } catch (Exception e) {
            logger.error("Error on «process» method : " + e.getMessage(), e);
            throw e;
        }
    }

    public void generateContent(Orders orders, List<OrderDetail> orderDetails) throws JAXBException, Docx4JException {
        HashMap<String, String> data = new HashMap<>();
        Double totalPriceTtc = new Double(0);
        Person person = orders.getPerson();
        data.put("today", LocalDate.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
        data.put("createdDate", orders.getCreatedDate().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
        data.put("reference", orders.getOrdersId().toString());

        data.put("companyname", person.getCompanyName());
        data.put("street", (person.getAddressStreet() + " " + person.getAddressNumber()).replace("null", ""));
        data.put("city", person.getAddressCity());
        data.put("postalcode", person.getAddressPostCode());

        Tbl t_ordersDetailTable = getTableByName("T_ordersDetailTable");

        for (OrderDetail orderDetail : orderDetails) {
            Article article = orderDetail.getArticle();
            Double pricettc = article.getSellingUnitPrice() * Double.valueOf(orderDetail.getQuantity());
            totalPriceTtc += pricettc;
            addRow(t_ordersDetailTable, 4, article.getLabel(), article.getSellingUnitPrice().toString(), orderDetail.getQuantity(), pricettc.toString());
        }

        data.put("totalOrderAmount", totalPriceTtc + " euros");

        for (String key : data.keySet()) {
            data.putIfAbsent(key, "");
        }
        documentPart.variableReplace(escapeXmlFrom(data));
    }

    protected void openDocument() throws Exception {
        InputStream templateResourceAsStream = this.getClass().getClassLoader().getResourceAsStream(supplierOrderTemplatePath);
        wordMLPackage = WordprocessingMLPackage.load(templateResourceAsStream);
        VariablePrepare.prepare(wordMLPackage);
        documentPart = wordMLPackage.getMainDocumentPart();
    }

    public String getTargetFile() {
        String documentNameWithoutSlashes = templateFileName.replace("/", "_");
        return temporaryDirectory + SecurityUtils.getCurrentUserLogin() + "_" + documentNameWithoutSlashes + ".docx";
    }

    private HashMap<String, String> escapeXmlFrom(HashMap<String, String> data) {
        HashMap<String, String> result = new HashMap<>();
        Set<String> keys = data.keySet();
        for (String key : keys) {
            String value = data.get(key);
            result.put(key, StringEscapeUtils.escapeXml11(value));
        }
        return result;
    }

    public String convertToPdf() {
        String targetPdfFile = "";
        try {
            return ConvertDocxToPdf.convert(getTargetFile());
        } catch (Exception e) {
            logger.error("Error while converting the Docx to Pdf file", e);
            e.printStackTrace();
        }
        return targetPdfFile;
    }

    public Tbl getTableByName(String tableName) throws RuntimeException {
        if (StringUtils.isEmpty(tableName) || !StringUtils.startsWithIgnoreCase(tableName, "T_"))
            throw new RuntimeException("The table name is null or empty or doesn't start with the prefix (T_).");
        for (Object o : documentPart.getContent()) {
            if (o instanceof JAXBElement) {
                JAXBElement t = (JAXBElement) o;
                if (t.getDeclaredType().equals(Tbl.class)) {
                    Tbl tbl = ((Tbl) t.getValue());
                    Tr tr = (Tr) tbl.getContent().get(0);
                    JAXBElement jaxbTc = (JAXBElement) tr.getContent().get(0);
                    if (((Tc) jaxbTc.getValue()).getContent().get(0).toString().equals(tableName)) {
                        return tbl;
                    }
                }
            }
        }
        throw new RuntimeException("Sorry no table with this name doesn't exist (" + tableName + ").");
    }


    public Tr addRow(Tbl table, int cellNb, String... content) {
        Tr tableRow = factory.createTr();
        for (int i = 0; i < cellNb && i < content.length; i++) {
            addTableCell(tableRow, content[i]);
        }
        table.getContent().add(tableRow);
        return tableRow;
    }

    public Tc addTableCell(Tr tableRow, String content) {
        Tc tableCell = factory.createTc();
        if (content.contains("\n")) {
            for (String contentPart : Arrays.asList(content.split("\\n"))) {
                tableCell.getContent().add(wordMLPackage.getMainDocumentPart().createParagraphOfText(contentPart));
            }
        } else {
            tableCell.getContent().add(wordMLPackage.getMainDocumentPart().createParagraphOfText(content));

        }
        tableRow.getContent().add(tableCell);
        return tableCell;
    }

    protected void removeAllFirstTableRow(WordprocessingMLPackage target) {
        List<Object> content = target.getMainDocumentPart().getContent();
        for (Object o : content) {
            try {
                if (o instanceof JAXBElement && ((JAXBElement) o).getDeclaredType().getName().equals("org.docx4j.wml.Tbl")) {
                    org.docx4j.wml.Tbl tbl = (org.docx4j.wml.Tbl) ((JAXBElement) o).getValue();
                    if (tbl.getContent().size() > 0) {
                        Tr tr = (Tr) tbl.getContent().get(0);
                        JAXBElement jaxbTc = (JAXBElement) tr.getContent().get(0);
                        if (jaxbTc.getValue() != null && jaxbTc.getValue() instanceof Tc && ((Tc) jaxbTc.getValue()).getContent().size() > 0) {
                            Object rowObject = ((Tc) jaxbTc.getValue()).getContent().get(0);
                            if (rowObject != null && rowObject.toString().startsWith("T_")) {
                                tbl.getContent().remove(0);
                            }
                        }
                    }
                }
            } catch (Exception e) {
                logger.warn("", e);
            }
        }
    }

}
