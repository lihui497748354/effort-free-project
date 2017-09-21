package com.effort.service;

import org.jdom.Document;
import org.jdom.Element;
import org.jdom.JDOMException;
import org.jdom.input.SAXBuilder;
import org.json.JSONObject;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017/9/21.
 */
public class XmlToJson {

    @PostMapping("/xmltojson")
    private static String xml2Json(@RequestBody String xml) throws JDOMException, IOException {

        JSONObject jsonObject = new JSONObject();
        InputStream inputStream = new ByteArrayInputStream(xml.getBytes("UTF-8"));
        SAXBuilder saxBuilder = new SAXBuilder();
        Document doc = saxBuilder.build(inputStream);
        Element root = doc.getRootElement();
        jsonObject.put(root.getName(), iterateElement(root));
        return jsonObject.toString();
    }


    private static Map iterateElement(Element element){
        List nodeList = element.getChildren();
        Element et = null;
        Map obj = new HashMap();
        List lister = null;
        for(int i=0;i<nodeList.size();i++){
            lister = new LinkedList();
            et = (Element) nodeList.get(i);
            if(et.getTextTrim().equals("")){
                if(et.getChildren().size() == 0){
                    obj.put(et.getName(), et.getValue());
                }
                if(obj.containsKey(et.getName())){
                    lister = (List) obj.get(et.getName());
                }
                lister.add(iterateElement(et));
                obj.put(et.getName(), lister);
            }else{
                if(obj.containsKey(et.getName())){
                    lister = (List) obj.get(et.getName());
                }
                //lister.add(et.getTextTrim());
                obj.put(et.getName(), et.getTextTrim());
            }
        }
        return obj;
    }
}
