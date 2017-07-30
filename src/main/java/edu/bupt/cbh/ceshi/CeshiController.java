package edu.bupt.cbh.ceshi;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by scarlett on 2017/7/30.
 */
@Controller
@RequestMapping("/ceshi")
public class CeshiController {

    public Map<String, Object> login(String username, String password) {
        Map<String, Object> map = new HashMap<>();
        if (username == "cbh" && password == "cbh") {
            map.put("code", "0");
        } else {
            map.put("code", "1");
        }
        return map;
    }
}
