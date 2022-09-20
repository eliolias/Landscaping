package com.solvd.landscapingApp.DOMParser;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.xml.sax.SAXException;

import javax.xml.XMLConstants;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.SchemaFactory;

import java.io.File;
import java.io.IOException;

public class Validator {
    private final static Logger LOGGER = LogManager.getLogger(DOMParser.class);

    boolean isValid = true;
    {
        try {
            validate("src/main/java/com.solvd.landscapingApp/XML/Addresses.xml", "src/main/java/com.solvd.landscapingApp/XML/Addresses.xsd");
        }  catch (IOException e) {
            isValid = false;
            throw new RuntimeException(e);
        } catch (SAXException e) {
            isValid = false;
            throw new RuntimeException(e);
        }
    }

    public static void validate(String xmlFile, String validationFile) throws SAXException, IOException {
        SchemaFactory schemaFactory = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
        ((schemaFactory.newSchema(new File(validationFile))).newValidator()).validate(new StreamSource(new File(xmlFile)));
    }
}