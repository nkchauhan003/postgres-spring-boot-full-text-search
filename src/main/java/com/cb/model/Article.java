package com.cb.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "articles")
@Data
@NoArgsConstructor
public class Article {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String title;

    @Column(columnDefinition = "TEXT")
    private String content;

    @Transient
    private float rank;

    public Article(Integer id, String title, String content, float rank) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.rank = rank;
    }
}
