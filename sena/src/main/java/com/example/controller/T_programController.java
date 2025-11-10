package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.entity.T_program;
import com.example.service.T_programService;

@Controller
public class T_programController {

    @Autowired
    private T_programService programService;

    @GetMapping("/listProgram")
    public String listPrograms(Model model) {
        try {
            List<T_program> listPrograms = programService.findAll();
            model.addAttribute("programs", listPrograms);
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
        return "/admin/program/index";
    }

    @GetMapping("/addProgram")
    public String addProgram(Model model) {
        try {
            model.addAttribute("program", new T_program());
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
        return "/admin/program/add";
    }

    @GetMapping("/delProgram/{code}")
    public String deleteProgram(@PathVariable int code) {
        try {
            programService.deleteById(code);
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
        return "redirect:/listProgram";
    }
}
