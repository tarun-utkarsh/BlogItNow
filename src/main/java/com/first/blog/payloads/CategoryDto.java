package com.first.blog.payloads;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class CategoryDto {
	
	private int categoryId;
	
	@NotBlank
	@Size(min=4,message = "Minimum size is 4")
	private String categoryTitle;
	
	@NotBlank
	@Size(min =10,message = "Minimum size is 10")
	private String categoryDescription;
	

}
