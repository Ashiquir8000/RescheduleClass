package com.example.ashiquir.controller;


import com.example.ashiquir.Entity.ClassReshedulingRequest;
import com.example.ashiquir.service.ClassResheduleService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
@RequestMapping("/class-rescheduling-request")
public class ClassController {

    private final ClassResheduleService classResheduleService;

    @GetMapping
    public String showFullClassesList(Model model)
    {
        model.addAttribute("classesss", classResheduleService.getAllFromReshedule());
        return "starter";
    }

    @PostMapping("/save")
    public String saveClassesss(@Valid @ModelAttribute ClassReshedulingRequest classReshedulingRequest, BindingResult bindingResult)
    {
        if(bindingResult != null)
        {
            return "redirect:/class-rescheduling-request";
        }

        classResheduleService.createClassess(classReshedulingRequest);
        return "starter";
    }

    @GetMapping("/delete/{id}")
    public String delteUsingByIddd(@PathVariable String id)
    {
        classResheduleService.deleteClassesById(id);
        return "starter";
    }
}
