package edu.bupt.cbh.template.dao;

import edu.bupt.cbh.template.entity.RegistTestTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by scarlett on 2017/5/22.
 */
@Repository
public interface TemplateDao {
    /**
     *
     * @param registTestTemplateList
     */
    void initTemplateDatabase(List<RegistTestTemplate> registTestTemplateList);
}
