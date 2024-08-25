package com.cb.service;

import com.cb.model.Article;
import java.util.List;

public interface ArticleService {
    List<Article> searchByText(String query, int page, int perPage);

}
