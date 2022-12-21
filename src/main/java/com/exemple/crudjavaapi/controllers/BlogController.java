package com.exemple.crudjavaapi.controllers;

import com.exemple.crudjavaapi.repositories.BlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/blog")
public class BlogController {
    @Autowired
    private BlogRepository blogRepository;

    @GetMapping
    public List<Blog> listBlogs() {
        return blogRepository.findAll();
    }

    @GetMapping("/{id}")
    public Blog BlogById(@PathVariable Integer id) {
        Optional<Blog> optionalBlog = blogRepository.findById(id);
        if (optionalBlog.isPresent()) {
            return optionalBlog.get();
        }
        throw new ResponseStatusException(HttpStatus.NO_CONTENT, "Aucun article disponible");
    }

    @BlogMapping
    public Blog createBlog(@RequestBody Blog blog) {
        return blogRepository.save(Blog);
    }

    @PutMapping("/{id}")
    public Blog updateBlog(@PathVariable Integer id, @RequestBody Blog blog) {
        blog.setId(id);
        return blogRepository.save(blog);
    }

    @DeleteMapping("/{id}")
    public void deleteBlog(@PathVariable Integer id){
        try {
            blogRepository.deleteById(id);
        } catch (EmptyResultDataAccessException exception) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

}
