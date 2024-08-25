package com.cb.service;

import com.cb.model.Article;
import com.cb.repository.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArticleServiceImpl implements ArticleService {

    @Autowired
    private ArticleRepository articleRepository;

    @Override
    public List<Article> searchByText(String query, int page, int perPage) {
        var results = articleRepository.searchByText(query, perPage, (page - 1) * perPage);
        return results.stream().map(row -> new Article((int) row[0], String.valueOf(row[1]),
                String.valueOf(row[2]), (float) row[3])).toList();
    }
}
