package edu.bupt.cbh.ceshi;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by scarlett on 2017/7/30.
 */
@Controller
@RequestMapping("/ceshi")
public class CeshiController {

    @RequestMapping("/login")
    @ResponseBody
    public Map<String, Object> login(@RequestBody Map<String,Object> input) {
        Map<String, Object> map = new HashMap<>();
        String username = (String) input.get("username");
        String password = (String) input.get("password");
        if (username.equals("cbh") && password.equals("cbh")) {
            map.put("code", "0");
        } else {
            map.put("code", "1");
        }
        System.out.print(map);
        return map;
    }
}
