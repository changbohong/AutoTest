package edu.bupt.cbh.common.service;

import org.w3c.dom.NodeList;

/**
 * Created by scarlett on 2017/5/22.
 */
public interface ParseXml {

    /**
     * 解析xml文档，返回最高层node列表
     * @param filePath
     * @param nodeLevelOne
     * @return
     */
    public NodeList parseXml(String filePath, String nodeLevelOne);
}
