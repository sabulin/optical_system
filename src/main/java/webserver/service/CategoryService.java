package webserver.service;

import webserver.domain.Category;

import java.util.List;

public interface CategoryService{
    public List<Category> findAll();
}
