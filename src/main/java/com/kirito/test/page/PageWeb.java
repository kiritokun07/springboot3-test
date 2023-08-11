package com.kirito.test.page;

import com.kirito.test.types.PageBO;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@Controller
public class PageWeb {

    @GetMapping("/page/view")
    public ModelAndView pageView(HttpServletRequest request) {
        ModelAndView modelAndView = new ModelAndView();
        // 普通参数
        modelAndView.addObject("name", "cicada");
        modelAndView.addObject("time", "2023-07-12");
        // 对象模型
        modelAndView.addObject("page", new PageBO(7, "页面数据模型"));
        // List集合
        List<PageBO> pageList = new ArrayList<>();
        pageList.add(new PageBO(1, "第一页"));
        pageList.add(new PageBO(2, "第二页"));
        modelAndView.addObject("pageList", pageList);
        // Array数组
        PageBO[] pageArr = new PageBO[]{new PageBO(6, "第六页"), new PageBO(7, "第七页")};
        modelAndView.addObject("pageArr", pageArr);
        modelAndView.setViewName("/page-view");
        return modelAndView;
    }
}