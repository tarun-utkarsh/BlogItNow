package com.first.blog.repositories;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.first.blog.entities.Category;
import com.first.blog.entities.Post;
import com.first.blog.entities.User;

public interface PostRepo extends JpaRepository<Post, Integer> {

	Page<Post> findByUser(User user, Pageable p);

	Page<Post> findByCategory(Category category, Pageable p);
	
	List<Post> findByTitleContaining(String title);

}
