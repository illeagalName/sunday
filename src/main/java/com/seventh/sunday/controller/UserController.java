package com.seventh.sunday.controller;

import com.seventh.sunday.service.UserService;
import com.seventh.sunday.vo.UserVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ami
 */
@Controller
@RequestMapping("user/v1")
@Slf4j
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("{userId}")
    @ResponseBody
    public UserVO getUserById(@PathVariable Long userId) {
        return userService.getUserById(userId);
    }

    @GetMapping("list")
    public String index(Model model) {
        List<UserVO> userList = new ArrayList<>();
        int size = 10;
        for (int i = 0; i < size; i++) {
            userList.add(new UserVO(Long.valueOf(i), "张三" + i));
        }
        model.addAttribute("users", userList);
        return "list";
    }
}
