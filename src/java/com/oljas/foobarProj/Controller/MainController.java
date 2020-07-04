package com.oljas.foobarProj.Controller;

import com.oljas.foobarProj.Service.FooBarService;
import com.oljas.foobarProj.validator.NumericInputValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class MainController {


    @Autowired
    FooBarService fooBar;
    @Autowired
    NumericInputValidator numberValidator;

    @GetMapping("/")
    public String showPage(Model model){
        model.addAttribute("FooBar", fooBar);
        return "home";
    }


    @ExceptionHandler
    @RequestMapping(value="/showResults", method=RequestMethod.POST)
    public String welcomeUser(@RequestParam("long") Long number, Model model) {
        String result = "";
        try {
            numberValidator.validate(number);

            fooBar.buildString(number);
            result = fooBar.getResult();
            model.addAttribute("result", result);
            return "result";

        } catch (NullPointerException e) {
            result = "Null Value Cannot Proceed";
            model.addAttribute("result", result);
            return "result";
        } catch (IllegalStateException exp) {
            result = exp.getMessage();
            model.addAttribute("result", result);
            return "result";
        }
    }
}
