package edu.bupt.cbh.testing.controller;

import edu.bupt.cbh.test.entity.Test;
import edu.bupt.cbh.test.service.TestService;
import edu.bupt.cbh.testing.entity.ExpectedTestingOutput;
import edu.bupt.cbh.testing.entity.Testing;
import edu.bupt.cbh.testing.entity.TestingInput;
import edu.bupt.cbh.testing.service.TestingService;
import edu.bupt.cbh.testing.vo.AddTestingVO;
import edu.bupt.cbh.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * Created by changbohong on 2017/7/23.
 */
@Controller
@RequestMapping("/testing")
public class TestingController {

    @Autowired
    private TestService testService;

    @Autowired
    private UserService userService;

    @Autowired
    private TestingService testingService;

    /**
     * 展示添加测试单元页面
     *
     * @param id
     * @return
     */
    @RequestMapping("/toAddTesting")
    public ModelAndView toAddTesting(Integer id) {
        ModelAndView modelAndView;
        Test test = testService.getTestById(id);
        //判断测试类型
        if (test.getTestType() == 0){
            modelAndView = new ModelAndView("testing/addTesting");
        } else if (test.getTestType() == 1){
            modelAndView = new ModelAndView("testing/addTestingLink");
        } else {
            modelAndView = new ModelAndView("testing/addTesting");
        }
        modelAndView.addObject("test", test);
        return modelAndView;
    }


    /**
     * 添加链接测试单元
     * @param addTestingVO
     * @return
     */
    @RequestMapping("/addTestingLink")
    public ModelAndView addTestingLink(AddTestingVO addTestingVO) {
        //保存Testing
        ModelAndView modelAndView = new ModelAndView("main/main");
        Integer testingId = testingService.addTestingLink(addTestingVO);
        if (testingId == null) {
            String msg = "创建测试失败，测试名称为：" + addTestingVO.getTestingName();
            modelAndView.addObject("msg", msg);
            System.out.println(msg);
            return modelAndView;
        }
        modelAndView.addObject("msg", "创建成功");
        return modelAndView;
    }

    /**
     * 添加测试单元
     * @param addTestingVO
     * @return
     */
    @RequestMapping("/addTesting")
    public ModelAndView addTesting(AddTestingVO addTestingVO) {
        //保存Testing
        ModelAndView modelAndView = new ModelAndView("main/main");
        Integer testingId = testingService.addTesting(addTestingVO);
        if (testingId == null) {
            String msg = "创建测试失败，测试名称为：" + addTestingVO.getTestingName();
            modelAndView.addObject("msg", msg);
            System.out.println(msg);
            return modelAndView;
        }
        modelAndView.addObject("msg", "创建成功");
        return modelAndView;
    }
}
