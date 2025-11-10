package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.entity.Apprentice;
import com.example.service.apprenticeService;



@Controller
public class apprenticeController {

    @Autowired
    private apprenticeService appService;

    @GetMapping("/listApprentice")
    public String listApprentices(Model model) {
        try {
            List<Apprentice> listApprentices = appService.findAll();
            model.addAttribute("apprentices", listApprentices);
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
        return "admin/apprentice/listApprentice";


    }

    @GetMapping("/addApprentice")
    public String addApprentice(Model model) {
        try {
            model.addAttribute("apprentice", new Apprentice());
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
        return "admin/apprentice/Add_apprentice";
    }

    @GetMapping("/delApprentice/{id}")
    public String deleteApprentice(@PathVariable int id) {
        try {
            appService.deleteById(id);
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
        return "redirect:/listApprentice";
    }
    
    @GetMapping("/test")
    public String test() {
        return "test";
    }
}
