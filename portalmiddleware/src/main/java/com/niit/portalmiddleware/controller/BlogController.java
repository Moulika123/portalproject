package com.niit.portalmiddleware.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.niit.portalbackend.Blog;
import com.niit.portalbackend.dao.BlogDao;

@RestController
public class BlogController {
	
	@Autowired
	BlogDao blogDao;
	
	
	@PostMapping("/addblog")
	public ResponseEntity<?> addblog(@RequestBody Blog blog)
	{
		try {
			
			blog.setBlogDate(new Date());
			
			blogDao.addBlog(blog);
		}catch(Exception e)
		{
			return new ResponseEntity<String>("Error in adding  blog", HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<Boolean>(true, HttpStatus.OK);
	}

	
	@GetMapping("/blogslist")
	public ResponseEntity<?> blogslist(){
		try {
		
			List<Blog> blogs = blogDao.getAllBlogs();
			
			return new ResponseEntity<List<Blog>>(blogs, HttpStatus.OK);
		}catch(Exception e)
		{
			return new ResponseEntity<String>("error in getting blogs", HttpStatus.NOT_FOUND);
		}

	}
}