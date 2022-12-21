package com.exemple.crudjavaapi.repositories;

import com.exemple.crudjavaapi.entities.Blog;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BlogRepository extends JpaRepository<Blog, Integer> {
}
