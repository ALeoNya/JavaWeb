package cn.edu.lingnan.util;

import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class XmlParser {
    //½âÎöxmlÎÄ¼þ
    public static Map<String,String> parse(String xmlName) {

        Map<String,String> map = new HashMap<String,String>();
        try {

            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser saxParser = factory.newSAXParser();
            File file = new File(xmlName);
            XmlHandler xmlHandler = new XmlHandler();
            saxParser.parse(file,xmlHandler);
            map = xmlHandler.getMap();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return map;
    }
}
