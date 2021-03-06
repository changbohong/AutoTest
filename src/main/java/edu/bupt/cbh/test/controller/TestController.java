package edu.bupt.cbh.test.controller;

import edu.bupt.cbh.common.Constants;
import edu.bupt.cbh.test.entity.Test;
import edu.bupt.cbh.test.entity.TestResult;
import edu.bupt.cbh.test.service.TestService;
import edu.bupt.cbh.test.vo.CreateTestVO;
import edu.bupt.cbh.testing.entity.Testing;
import edu.bupt.cbh.testing.service.TestingService;
import edu.bupt.cbh.user.service.UserService;
import org.omg.CORBA.INTERNAL;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by scarlett on 2017/5/22.
 */
@Controller
@RequestMapping("/test")
public class TestController {

    @Autowired
    private TestService testService;

    @Autowired
    private TestingService testingService;

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/toCreate")
    public ModelAndView toCreate(HttpSession httpSession) {
        ModelAndView modelAndView = new ModelAndView("test/createTest");
        modelAndView.addObject("currentTime", new Date());
        return modelAndView;
    }

    //springMVC接收前端Date数据，格式转换
    @InitBinder
    public void initBinder(ServletRequestDataBinder bin) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        CustomDateEditor cust = new CustomDateEditor(sdf, true);
        bin.registerCustomEditor(Date.class, cust);
    }

    @RequestMapping(value = "/createTest", method = RequestMethod.POST)
    public ModelAndView createTest(CreateTestVO createTestVO) {
        //保存Test
        ModelAndView modelAndView = new ModelAndView("main/main");
         Integer testId = testService.createTest(createTestVO);
        if (testId == null) {
            String msg = "创建测试失败，测试名称为：" + createTestVO.getName();
            modelAndView.addObject("msg", msg);
            System.out.println(msg);
            return modelAndView;
        }
        modelAndView.addObject("msg", "创建成功");
        return modelAndView;
    }

    @RequestMapping(value = "/searchTest")
    public ModelAndView searchTest(String name, Integer page) {
        ModelAndView modelAndView = new ModelAndView("test/listTest");
        List<Test> testList = testService.searchTestLikeName(name);
        Integer maxPage = getMaxPage(testList.size());
        modelAndView.addObject("testList", testList);
        modelAndView.addObject("maxPage", maxPage);
        return modelAndView;
    }

    /**
     * 展示详情和修改都使用此接口
     * 展示详情为只读
     * 修改为可提交的表单
     * 返回test详情
     *
     * @param id
     * @return
     */
    @RequestMapping(value = "/testDetails")
    public ModelAndView testDetails(Integer id) {
        ModelAndView modelAndView = new ModelAndView("test/testDetails");
        Test test = testService.getTestById(id);
        modelAndView.addObject("test", test);
        List<Testing> testingList = testingService.getAllTestings(id);
        modelAndView.addObject("testingList", testingList);
        return modelAndView;
    }

    /**
     * 测试报告
     * @param id
     * @return
     */
    @RequestMapping(value = "/testReport")
    public ModelAndView testReport(Integer id) {
        ModelAndView modelAndView = new ModelAndView("test/testReport");
        Test test = testService.getTestById(id);
        modelAndView.addObject("test", test);
        List<Testing> testingList = testingService.getAllTestings(id);
        modelAndView.addObject("testingList", testingList);
        return modelAndView;
    }

    /**
     * 执行测试
     *
     * @param id
     * @return
     */
    @RequestMapping("/testRun")
    public ModelAndView testRun(Integer id) throws IOException {
        ModelAndView modelAndView = new ModelAndView("main/main");
        testService.testRun(id);
        return modelAndView;
    }

    @RequestMapping(value = "/update")
    public ModelAndView updateTest(Integer id) {
        ModelAndView modelAndView = new ModelAndView();
        return modelAndView;
    }

    public int getMaxPage(int count) {
        return (count - 1) / Constants.PAGE_SIZE + 1;
    }
}
