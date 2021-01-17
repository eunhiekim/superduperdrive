package com.udacity.jwdnd.course1.cloudstorage.controller;

import com.udacity.jwdnd.course1.cloudstorage.model.NoteForm;
import com.udacity.jwdnd.course1.cloudstorage.services.NoteService;
import com.udacity.jwdnd.course1.cloudstorage.services.UserService;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/note")
public class NoteController {

    private NoteService noteService;
    private UserService userService;

    public NoteController(NoteService noteService, UserService userService) {
        this.noteService = noteService;
        this.userService = userService;
    }

    @GetMapping()
    public String getNotesList(@ModelAttribute("noteForm") NoteForm noteForm, Model model) {
        model.addAttribute("notes", this.noteService.getNotes(noteForm.getUserId()));
        return "note";
    }

    @PostMapping("/add")
    public String addNote(@ModelAttribute("noteForm") NoteForm noteForm, Authentication authentication, Model model) {
        noteForm.setUserId(userService.getUser(authentication.getName()).getUserId());
        noteService.addNote(noteForm);
        model.addAttribute("notes", noteService.getNotes(noteForm.getUserId()));
        noteForm.setTitle("");
        noteForm.setDescription("");
        return "note";
    }
}
