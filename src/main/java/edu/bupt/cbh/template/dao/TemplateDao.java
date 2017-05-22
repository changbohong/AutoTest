package edu.bupt.cbh.template.dao;

import edu.bupt.cbh.template.entity.RegistTestTemplate;

import java.util.List;

/**
 * Created by scarlett on 2017/5/22.
 */
public interface TemplateDao {
    /**
     *
     * @param registTestTemplateList
     */
    void initTemplateDatabase(List<RegistTestTemplate> registTestTemplateList);
}
