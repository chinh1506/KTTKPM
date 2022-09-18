package com.example.jwtextuan3.controller;

import com.example.jwtextuan3.model.News;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/news")
public class NewController {
    @RequestMapping(method = RequestMethod.GET)
    public List<News> news(HttpServletRequest request) {
        List<News> news= new ArrayList<>();
        news.add(new News("Title 1","hello","chinh"));
        news.add(new News("Title 2","hello","chinh"));
        news.add(new News("Title 4","hello","chinh"));
        return news;
    }
}
