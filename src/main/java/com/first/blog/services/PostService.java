package com.first.blog.services;

import java.util.List;

import com.first.blog.entities.Category;
import com.first.blog.entities.Post;
import com.first.blog.payloads.PostDto;
import com.first.blog.payloads.PostResponse;

public interface PostService {
	
	//create
	
	PostDto createPost(PostDto postDto,Integer userId,Integer  categoryId);
	
	//update
	PostDto updatePost(PostDto postDto,Integer postId);
	//delete
	void deletePost(Integer postId);
	//get all posts
	PostResponse getAllPost(Integer pageNumber, Integer pageSize,String sortBy,String sortDir);
	//get post by id
	PostDto getPostById(Integer postId);
	
	PostResponse getPostsByCategory(Integer categoryId, Integer pageNumber, Integer pageSize);
	
	PostResponse getPostsByUser(Integer userId,Integer pageNumber,Integer pageSize);
	
	List<PostDto> searchPosts(String keyword);
	
	

}
