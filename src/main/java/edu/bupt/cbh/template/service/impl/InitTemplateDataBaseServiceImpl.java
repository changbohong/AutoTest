package edu.bupt.cbh.template.service.impl;

import edu.bupt.cbh.common.Constants;
import edu.bupt.cbh.common.service.impl.ParseXmlServiceImpl;
import edu.bupt.cbh.template.dao.TemplateDao;
import edu.bupt.cbh.template.entity.RegistTestTemplate;
import edu.bupt.cbh.template.service.InitTemplatDataBaseeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.w3c.dom.Element;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by scarlett on 2017/5/22.
 */
@Service
public class InitTemplateDataBaseServiceImpl extends ParseXmlServiceImpl implements InitTemplatDataBaseeService {

    @Autowired
    private TemplateDao templateDao;

    public void initTemplateDataBase() {
        System.out.println("InitTemplateDataBaseServiceImpl initRegistTemplate");
        initRegistTemplate();
    }

    private void initRegistTemplate() {
        //获取节点列表
        NodeList nodeList = this.parseXml(Constants.InitTemplateCons.REGIST_PATH, Constants.InitTemplateCons.REGIST_LISTNODE);
        List<RegistTestTemplate> registTestTemplateList = new ArrayList<>();
        for (int i = 0; i < nodeList.getLength(); i++) {
            RegistTestTemplate registTestTemplate = new RegistTestTemplate();

            // 获得元素，将节点强制转换为元素
            Node node = nodeList.item(i);
            Element element = (Element) node;
            //判断类型，1表示RegistTemplate
            if (element.getAttribute("type") == "1"){
                String id = element.getElementsByTagName("id").item(0).getFirstChild().getNodeValue();
                registTestTemplate.setId(Integer.valueOf(id));
                String username = element.getElementsByTagName("username").item(0).getFirstChild().getNodeValue();
                registTestTemplate.setUsername(username);
                String password = element.getElementsByTagName("password").item(0).getFirstChild().getNodeValue();
                registTestTemplate.setPassword(password);
            }

            registTestTemplateList.add(registTestTemplate);
        }

        templateDao.initTemplateDatabase(registTestTemplateList);
    }


}
