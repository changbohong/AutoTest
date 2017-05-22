package edu.bupt.cbh.common.service.impl;

import edu.bupt.cbh.common.service.ParseXml;

import javax.xml.parsers.*;
import org.w3c.dom.*;

import java.io.File;

/**
 * Created by scarlett on 2017/5/22.
 */
public class ParseXmlServiceImpl implements ParseXml{

    public NodeList parseXml(String filePath, String listNode){
        // step 1:获得DOM解析器工厂
        // 工厂的作用是创建具体的解析器
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();

        try{
            // step 2：获得具体的dom解析器
            DocumentBuilder db = dbf.newDocumentBuilder();

            // step 3:解析一个xml文档，获得Document对象（根节点）
            // 此文档放在项目目录下即可
            Document doc = db.parse(new File(filePath));

            // 根据标签名访问节点
            NodeList nodeList = doc.getElementsByTagName(listNode);
            System.out.println("parseXml 共有" + nodeList.getLength() + "个节点");

            return nodeList;
        }catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }
}
