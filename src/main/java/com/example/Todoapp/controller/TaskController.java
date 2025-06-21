package com.example.Todoapp.controller;


import com.example.Todoapp.model.Todo;
import com.example.Todoapp.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class TaskController {

    @Autowired
    private TaskRepository taskRepository;

    @GetMapping("/")
    public String viewHomepage(Model model)
    {
        List<Todo> list = taskRepository.findAll();
        model.addAttribute("taskList",list);
        model.addAttribute("todo", new Todo());
        return "index";

    }

    @PostMapping("/add")
    public String addTask(@ModelAttribute Todo todo) {
        taskRepository.save(todo);
        return "redirect:/";
    }

    @PostMapping("/update")
    public String updateTask(@ModelAttribute Todo todo) {
        Todo existingTask = taskRepository.findById(todo.getId()).orElse(null);
        if (existingTask != null) {
            existingTask.setCompleted(todo.isCompleted());
            taskRepository.save(existingTask);
        }
        return "redirect:/";
    }

    @PostMapping("/delete")
    public String deleteTask(@ModelAttribute Todo todo) {
        taskRepository.deleteById(todo.getId());
        return "redirect:/";
    }



}
