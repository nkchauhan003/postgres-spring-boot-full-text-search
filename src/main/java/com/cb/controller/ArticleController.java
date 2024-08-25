package com.cb.controller;

import com.cb.model.Article;
import com.cb.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ArticleController {

    @Autowired
    private ArticleService articleService;

    private static final int PER_PAGE = 10;

    @GetMapping("/search/{page}")
    public List<Article> searchArticles(@RequestParam String query, @PathVariable int page) {
        return articleService.searchByText(query, page, PER_PAGE);
    }
}
