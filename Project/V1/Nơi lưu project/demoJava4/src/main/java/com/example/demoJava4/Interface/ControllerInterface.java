package com.example.demoJava4.Interface;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

public interface ControllerInterface<T, Dto, Id> {

    public String findById(Model model, Id id);

    public String getList(Model model, Integer sttPage); // sizePage = 20

    public String getCreate(Model model);
    public String postCreate(Dto dto);

    public String getUpdate(Model model, Id id);
    public String postUpdate(Id id, Dto dto);

    public String delete(Id id);

}

/*
 * get : /get/vatpham?id=5
 * 
 * get : /list/vatpham?page=5
 * 
 * get : /create/vatpham
 * post: /create/vatpham
 * 
 * get : /update/vatpham?id=5
 * post: /update/vatpham?id=5
 * 
 * get : /delete/vatpham?id=5
 * post: /delete/vatpham?id=5
 * 
 */