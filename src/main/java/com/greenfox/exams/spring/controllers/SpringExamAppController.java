/// Created by BB on 2017-01-11.
package com.greenfox.exams.spring.controllers;

import com.greenfox.exams.spring.domain.Review;
import com.greenfox.exams.spring.services.ProjectService;
import com.greenfox.exams.spring.services.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class SpringExamAppController {

    @Autowired
    private ReviewService reviewService;

    @Autowired
    private ProjectService projectService;

    @GetMapping(value="/welcome")
    public String welcome(Model model, @RequestParam(name = "error", defaultValue = "") String error) {
        model.addAttribute("errormessage", error);
        model.addAttribute("newreview", new Review());
        return "welcome";
    }

    @PostMapping(value="/submitAndValidate")
    public String submitAndValidate(Model model, @ModelAttribute("newreview") Review review) {
        if (reviewService.validate(review).equals("")) {
            reviewService.submit(review);
        return "redirect:/thankyou";
        } else {
            return "redirect:/welcome?error=" + reviewService.validate(review) ;
        }
    }

    @GetMapping(value="/thankyou")
    public String thankyou (Model model) {
        model.addAttribute("projects", projectService.findall());
        return "thankyou";
    }
}
