package be.atc.warehousemgmt.util;


import org.docx4j.Docx4J;
import org.docx4j.convert.out.FOSettings;
import org.docx4j.fonts.IdentityPlusMapper;
import org.docx4j.fonts.Mapper;
import org.docx4j.fonts.PhysicalFonts;
import org.docx4j.model.fields.FieldUpdater;
import org.docx4j.openpackaging.packages.WordprocessingMLPackage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.OutputStream;

/**
 * Demo of PDF output.
 * <p>
 * From v3.3.0, PDF output is by default via Plutext's commercial PDF Converter.
 * <p>
 * By default, the evaluation instance at:
 * <p>
 * http://converter-eval.plutext.com:80/v1/00000000-0000-0000-0000-000000000000/convert
 * <p>
 * is used.  To specify your own instance, please set docx4j.properties property:
 * <p>
 * com.plutext.converter.URL=http://your.host:80/v1/00000000-0000-0000-0000-000000000000/convert
 * <p>
 * If you don't want to use Plutext's PDF Converter, you can still use XSL FO and Apache FOP;
 * just put docx4j-export-fo and its depedencies on your classpath and use Docx4J.toFO
 * as per the example below.
 *
 * @author jharrop
 */
public class ConvertDocxToPdf {
    static boolean saveFO = true;
    static boolean usePlutext = false;
    private static Logger logger = LoggerFactory.getLogger(ConvertDocxToPdf.class);

    static public String convert(String docxFilePath) throws Exception {

        // Font regex (optional)
        // Set regex if you want to restrict to some defined subset of fonts
        // Here we have to do this before calling createContent,
        // since that discovers fonts
        String regex = null;
        // Windows:
        // String
        regex = ".*(calibri).*";
        //regex=".*(calibri|camb|cour|arial|times|comic|georgia|impact|LSANS|pala|tahoma|trebuc|verdana|symbol|webdings|wingding).*";
        // Mac
        // String
        // regex=".*(Courier New|Arial|Times New Roman|Comic Sans|Georgia|Impact|Lucida Console|Lucida Sans Unicode|Palatino Linotype|Tahoma|Trebuchet|Verdana|Symbol|Webdings|Wingdings|MS Sans Serif|MS Serif).*";
        PhysicalFonts.setRegex(regex);

        // Document loading (required)
        WordprocessingMLPackage wordMLPackage;
        // Load .docx or Flat OPC .xml
        logger.debug("Loading file from " + docxFilePath);
        wordMLPackage = WordprocessingMLPackage.load(new java.io.File(docxFilePath));

        // Refresh the values of DOCPROPERTY fields
        FieldUpdater updater = new FieldUpdater(wordMLPackage);
        updater.update(true);

        String outputfilepath;

        outputfilepath = docxFilePath + ".pdf";

        // All methods write to an output stream
        OutputStream os = new java.io.FileOutputStream(outputfilepath);

        /**
         * VIA Commercial Plutext library
         */
        if (!Docx4J.pdfViaFO() || usePlutext) {

            // Since 3.3.0, Plutext's PDF Converter is used by default

            logger.debug("Using Plutext's PDF Converter; add docx4j-export-fo if you don't want that");

            Docx4J.toPDF(wordMLPackage, os);
            logger.debug("Saved: " + outputfilepath);

            return outputfilepath;
        }

        logger.debug("Attempting to use XSL FO");

        /**
         * Demo of PDF output.
         *
         * PDF output is via XSL FO.
         * First XSL FO is created, then FOP
         * is used to convert that to PDF.
         *
         * Don't worry if you get a class not
         * found warning relating to batik. It
         * doesn't matter.
         *
         * If you don't have logging configured,
         * your PDF will say "TO HIDE THESE MESSAGES,
         * TURN OFF debug level logging for
         * org.docx4j.convert.out.pdf.viaXSLFO".  The thinking is
         * that you need to be able to be warned if there
         * are things in your docx which the PDF output
         * doesn't support...
         *
         * docx4j used to also support creating
         * PDF via iText and via HTML. As of docx4j 2.5.0,
         * only viaXSLFO is supported.  The viaIText and
         * viaHTML source code can be found in src/docx4j-extras directory
         *
         */


		/*
         * NOT WORKING?
		 *
		 * If you are getting:
		 *
		 *   "fo:layout-master-set" must be declared before "fo:page-sequence"
		 *
		 * please check:
		 *
		 * 1.  the jaxb-xslfo jar is on your classpath
		 *
		 * 2.  that there is no stack trace earlier in the logs
		 *
		 * 3.  your JVM has adequate memory, eg
		 *
		 *           -Xmx1G -XX:MaxPermSize=128m
		 *
		 */


        // Set up font mapper (optional)
        Mapper fontMapper = new IdentityPlusMapper();
        wordMLPackage.setFontMapper(fontMapper);

        // .. example of mapping font Times New Roman which doesn't have certain Arabic glyphs
        // eg Glyph "ي" (0x64a, afii57450) not available in font "TimesNewRomanPS-ItalicMT".
        // eg Glyph "ج" (0x62c, afii57420) not available in font "TimesNewRomanPS-ItalicMT".
        // to a font which does
//        PhysicalFont font  = PhysicalFonts.get("Arial Unicode MS");
        // make sure this is in your regex (if any)!!!
//		if (font!=null) {
//			fontMapper.put("Times New Roman", font);
//			fontMapper.put("Arial", font);
//		}
//		fontMapper.put("Libian SC Regular", PhysicalFonts.get("SimSun"));

        // FO exporter setup (required)
        // .. the FOSettings object
        FOSettings foSettings = Docx4J.createFOSettings();
        if (saveFO) {
            foSettings.setFoDumpFile(new java.io.File(docxFilePath + ".fo"));
        }
        foSettings.setWmlPackage(wordMLPackage);

        // Document format:
        // The default implementation of the FORenderer that uses Apache Fop will output
        // a PDF document if nothing is passed via
        // foSettings.setApacheFopMime(apacheFopMime)
        // apacheFopMime can be any of the output formats defined in org.apache.fop.apps.MimeConstants eg org.apache.fop.apps.MimeConstants.MIME_FOP_IF or
        // FOSettings.INTERNAL_FO_MIME if you want the fo document as the result.
        //foSettings.setApacheFopMime(FOSettings.INTERNAL_FO_MIME);

        // Specify whether PDF export uses XSLT or not to create the FO
        // (XSLT takes longer, but is more complete).

        // Don't care what type of exporter you use
        Docx4J.toFO(foSettings, os, Docx4J.FLAG_EXPORT_PREFER_XSL);

        // Prefer the exporter, that uses a xsl transformation
        // Docx4J.toFO(foSettings, os, Docx4J.FLAG_EXPORT_PREFER_XSL);

        // Prefer the exporter, that doesn't use a xsl transformation (= uses a visitor)
        // .. faster, but not yet at feature parity
        // Docx4J.toFO(foSettings, os, Docx4J.FLAG_EXPORT_PREFER_NONXSL);

        logger.debug("Saved: " + outputfilepath);

        // Clean up, so any ObfuscatedFontPart temp files can be deleted
        if (wordMLPackage.getMainDocumentPart().getFontTablePart() != null) {
            wordMLPackage.getMainDocumentPart().getFontTablePart().deleteEmbeddedFontTempFiles();
        }
        // This would also do it, via finalize() methods
        updater = null;
        foSettings = null;
        wordMLPackage = null;

        return outputfilepath;
    }


}