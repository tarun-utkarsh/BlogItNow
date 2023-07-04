package com.first.blog.services;

import org.springframework.stereotype.Service;

import com.first.blog.payloads.CommentDto;

@Service
public interface CommentService {
	
	CommentDto createComment(CommentDto commentDto, Integer postId);
	
	void deleteComment(Integer commentId);

}
