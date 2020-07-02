package com.oljas.foobarProj.Controller;

import com.oljas.foobarProj.FooBar;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.converter.json.GsonBuilderUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.w3c.dom.ls.LSOutput;

@Controller
public class MainController {
    @Autowired
    FooBar fooBar;

    @GetMapping("/")
    public String showPage(Model model){
        model.addAttribute("FooBar", fooBar);
        return "home";
    }

    @RequestMapping(value="/showResults", method=RequestMethod.POST)
    public String welcomeUser(@RequestParam("integer") Integer number, Model model) {
        fooBar.buildString(number);
        String result = fooBar.getResult();
        model.addAttribute("result", result);
        return "result";
    }

}
