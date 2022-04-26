package cn.edu.lingnan.text;

import cn.edu.lingnan.util.XmlParser;
import cn.edu.lingnan.util.XmlValidate;

import java.util.Map;

public class XmlTest {
    public static void main(String[] args) {
        String xsdName="database.conf.xsd";
        String xmlName="database.conf.xml";
        String basePath = Thread.currentThread().getContextClassLoader().getResource("").getPath();
        String xsdPath=basePath+xsdName;
        String xmlPath= basePath+xmlName;
//        System.out.println(XmlValidate.validate(xsdPath,xmlPath));

        if(XmlValidate.validate(xsdPath,xmlPath)){
            Map<String,String> map = XmlParser.parse(xmlPath);
            System.out.println(map.get("driver"));
            System.out.println(map.get("url"));
            System.out.println(map.get("user"));
            System.out.println(map.get("password"));
        }


        //(1)写死了的(绝对路径)
//        System.out.println(XmlValidate.validate("C:\\Users\\29235\\Desktop\\JavaWeb\\code1.13\\MJDBC\\target\\classes\\database.conf.xsd",
//                "C:\\Users\\29235\\Desktop\\JavaWeb\\code1.13\\MJDBC\\target\\classes\\database.conf.xml"));//路径不能为中文
    }
}
