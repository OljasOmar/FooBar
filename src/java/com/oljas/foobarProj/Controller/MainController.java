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
    public String showResult(
            @RequestParam("long") Long number,
            Model model) throws IllegalStateException{
        String result = "";
        try {

            //Validating input number, throws appropriate exceptions
            numberValidator.validate(number);

            // call method to build string if matches any case
            fooBar.buildString(number);
            result = fooBar.getResult();
            model.addAttribute("result", result);
            return "result";

            // catch exceptions and return error messages
        } catch (NullPointerException e) {
            result = "Null Value Cannot Proceed";
            model.addAttribute("result", result);
            return "result";
        } catch (IllegalArgumentException e) {
            result = "Cannot process 0 and negative numbers";
            model.addAttribute("result", result);
            return "result";
        } catch (IllegalStateException e) {
            result = "Illegalstate";
            model.addAttribute("result", result);
            return "result";
        }
    }
}
