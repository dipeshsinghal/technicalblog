package com.assignment.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "categories")
public class Category {

    @Id
    //@GeneratedValue(strategy= GenerationType.AUTO)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "CATEGORY_ENTITY_SEQ")
    @SequenceGenerator(name = "CATEGORY_ENTITY_SEQ", sequenceName = "CATEGORY_ENTITY_SEQ", allocationSize = 1)
    @Column(name = "id")
    private Long id;

    @Column(name = "category")
    private String category;

    @ManyToMany(mappedBy = "categories", fetch = FetchType.LAZY)
    private List<Post> posts = new ArrayList<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

}
