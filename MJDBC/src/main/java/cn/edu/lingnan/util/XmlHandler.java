package cn.edu.lingnan.util;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.HashMap;
import java.util.Map;

public class XmlHandler extends DefaultHandler {
    //事件处理器（重写DefaultHandler中的子集）
    StringBuffer stringBuffer = new StringBuffer();

    public Map<String, String> getMap() {
        return map;
    }

    Map<String,String> map = new HashMap<String,String>();


    public void startElement (String uri, String localName,
                              String qName, Attributes attributes)
            throws SAXException
    {
        stringBuffer.delete(0,stringBuffer.length());// no op
    }


    public void endElement (String uri, String localName, String qName)
            throws SAXException
    {
        map.put(qName.toLowerCase(),stringBuffer.toString());// no op
    }


    public void characters (char ch[], int start, int length)
            throws SAXException
    {
        stringBuffer.append(ch,start,length);// no op
    }

}
