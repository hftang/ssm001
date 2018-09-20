package com.hftang.controller;

import com.hftang.pojo.Items;
import com.hftang.service.ItemsService;
import com.hftang.vo.QueryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/hftang")
public class ItemsController {

    @Autowired
    private ItemsService itemsService;


    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public ModelAndView itemList() throws Exception {

        List<Items> list = itemsService.list();

        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("itemList", list);
        modelAndView.setViewName("itemList");
        return modelAndView;
    }

    /***
     * 下面这些都是springmvc 默认参数 添加和删除 看需求要不要
     * @param httpServletRequest
     * @param httpServletResponse
     * @param httpSession
     * @param model
     * @return
     */

    @RequestMapping("/itemEdit")
    public String itemEdit(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, HttpSession httpSession, Model model) {
        String id = httpServletRequest.getParameter("id");
        Items items = itemsService.findItemById(Integer.parseInt(id));
        //       model 其实底层使用的是request 是对request进行的包装
        model.addAttribute("item", items);
        //如果返回的是字符串的话 其实就是返回到那个页面的名称
        return "editItem";
    }


    /**
     * updateitem
     * 添加一个
     */

//    @RequestMapping("/updateItem")
//    public String updateitem(Integer id, String name,Float price,String detail){
//
//        Items items = new Items();
//        items.setId(id);
//        items.setName(name);
//        items.setPrice(price);
//        items.setCreatetime(new Date());
//        items.setDetail(detail);
//
//        itemsService.updateItems(items);
//
//        return "success";
//    }

    /**
     * 传一个pojo对象
     *
     * @param items
     * @return
     */

    @RequestMapping("/updateItem")
    public String updateitem(Items items, Model model) throws ServletException, IOException {
        itemsService.updateItems(items);
        //这里的model 是对request进行了封装 所以在redirect 重定向时 还是可以携带数据的
        model.addAttribute("id", items.getId());
        //使用redirect 重定向 这里写的是相对路径 以/开头的是绝对路径 绝对路径是从项目名后开始的
        return "redirect:itemEdit.action";
    }


    @RequestMapping("/search")
    public String search(QueryBean queryBean) {
        String name = queryBean.getItems().getName();

        Float price = queryBean.getItems().getPrice();


        return "";
    }

    /***
     * 批量删除
     * @return
     */

    @RequestMapping("/delAll")
    public String delAll(QueryBean bean) {

        int[] ids = bean.getIds();

        System.out.print(ids);


        return "";
    }

    @RequestMapping("/updateAll")
    public String updateAll(QueryBean bean) {
        List<Items> itemsList = bean.getItemsList();
        for (Items items : itemsList) {

            System.out.print(items);
        }


        return "";
    }


}
