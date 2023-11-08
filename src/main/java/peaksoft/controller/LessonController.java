package peaksoft.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import peaksoft.model.Lesson;
import peaksoft.service.LessonService;

@Controller
@RequestMapping("/lessons")
@RequiredArgsConstructor
public class LessonController {

    private final LessonService lessonService;

    @GetMapping
    public String getAllLessons(Model model){
       model.addAttribute("getAllLessons",lessonService.getAllLessons());
        return "lessons";
    }

    @GetMapping("/create")
    public String createLesson(Model model){
        model.addAttribute("newLesson",new Lesson());
        return "createLesson";
    }

    @PostMapping("/save")
    public String saveLesson(@ModelAttribute("newLesson") Lesson lesson){
        lessonService.saveLesson(lesson);
        return "redirect:/lessons";
    }

    @DeleteMapping("/delete/{id}")
    public String deleteLesson( @PathVariable("id") Long id){
        lessonService.deleteLesson(id);
        return "redirect:/lessons";
    }
}
