package com.solvd.landscapingApp.DOMParser;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import java.io.IOException;


public class DOMParser {
    private final static Logger LOGGER = LogManager.getLogger(DOMParser.class);
    //TODO: clean up for loops
    //TODO: store data parsed data to class
    DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
    DocumentBuilder builder;

    {
        try {
            builder = factory.newDocumentBuilder();
            Document doc = builder.parse("src/main/java/com.solvd.landscapingApp/XML/Addresses.xml");
            NodeList addresses = doc.getElementsByTagName("Address");
            for (int i = 0; i < addresses.getLength(); i++) {
                Node p = addresses.item(i);
                if (p.getNodeType() == Node.ELEMENT_NODE) ;
                Element address = (Element) p;
                String id = address.getAttribute("id");
                NodeList addressEntities = address.getChildNodes();
                for (int j = 0; j < addressEntities.getLength(); j++) {
                    Node n = addressEntities.item(j);
                    if (n.getNodeType() == Node.ELEMENT_NODE) {
                        Element streetAddress = (Element) n;
                        LOGGER.info("Address: " + id + ":" + streetAddress.getTagName() + "=" + streetAddress.getTextContent());
                    }
                }
            }

        } catch (ParserConfigurationException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (SAXException e) {
            throw new RuntimeException(e);
        }
    }
}
