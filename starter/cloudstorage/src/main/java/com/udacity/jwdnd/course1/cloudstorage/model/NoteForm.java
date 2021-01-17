package com.udacity.jwdnd.course1.cloudstorage.model;

import org.springframework.web.bind.annotation.ModelAttribute;


public class NoteForm {

    private String title;
    private String description;
    private Integer userId;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }
}
