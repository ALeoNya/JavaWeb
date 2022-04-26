package cn.edu.lingnan.util;

import org.xml.sax.SAXException;

import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;
import javax.xml.validation.Validator;
import java.io.File;
import java.io.IOException;

public class XmlValidate {
    //输入ssd和xml文件，来验证xml文件的有效性
    public  static boolean validate(String xsdName,String xmlName){
        boolean flag = false;
        try {
            //(1)
            SchemaFactory schemaFactory = SchemaFactory.newInstance("http://www.w3.org/2001/XMLSchema");
            //(2)
            File file = new File(xsdName);
            Schema schema =  schemaFactory.newSchema(file);
            //(3)
            Validator validator = schema.newValidator();
            //(4)
            Source source = new StreamSource(xmlName);
            validator.validate(source);
            flag = true;
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            System.out.println("[DeBug]Xsd文件在验证xml文件时出错");
            e.printStackTrace();
        }
        return flag;
    }
}
