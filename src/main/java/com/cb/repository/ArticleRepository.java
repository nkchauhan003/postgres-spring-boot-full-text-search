package com.cb.repository;

import com.cb.model.Article;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ArticleRepository extends JpaRepository<Article, Long> {

    static final String ARTICLE_SEARCH_QUERY = """
            SELECT   id,
                     title,
                     content,
                     Ts_rank(ts, Phraseto_tsquery('english', :query)) AS rank
            FROM     articles
            WHERE    ts @@ phraseto_tsquery('english', :query)
            ORDER BY rank DESC,
                     title limit :limit offset :offset
            """;

    @Query(value = ARTICLE_SEARCH_QUERY, nativeQuery = true)
    List<Object[]> searchByText(@Param("query") String query, @Param("limit") int limit, @Param("offset") int offset);
}
