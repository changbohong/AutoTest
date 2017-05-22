package edu.bupt.cbh.template.dao.impl;

import edu.bupt.cbh.common.dao.BaseDaoImpl;
import edu.bupt.cbh.template.dao.TemplateDao;
import edu.bupt.cbh.template.entity.RegistTestTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by scarlett on 2017/5/22.
 */
@Repository
public class TemplateDaoImpl extends BaseDaoImpl implements TemplateDao{

    @Override
    public void initTemplateDatabase(List<RegistTestTemplate> registTestTemplateList) {
        sqlSessionTemplate.insert(this.getNameSpace() + ".initTemplateDatabase", registTestTemplateList);
    }
}
