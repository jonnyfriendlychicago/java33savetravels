package com.jonfriend.java33savetravels.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.jonfriend.java33savetravels.models.Book;
import com.jonfriend.java33savetravels.services.BookService;

@Controller
public class BookController {
	
	@Autowired
	BookService bookservice; 
	
	
	@RequestMapping("/books")
	public String index(Model model) {
		List<Book> bookListy = bookservice.allBooks(); 
		model.addAttribute("bookListy", bookListy);

//		List<Book> books = bookservice.allBooks();
//	    model.addAttribute("books", books);
//		model.addAttribute("book", book); 
		
		return "booklist.jsp";
	}


	@RequestMapping("/books/{bookId}") 
	public String index(Model model, @PathVariable("bookId") Long bookId) {
		
		Book book = bookservice.findBook(bookId); 
		model.addAttribute("book", book);  
		 
		
//		List<Book> bookListy = bookservice.allBooks(); 
//		model.addAttribute("bookListy", bookListy); 
		
		return "bookprofile.jsp"; 
	}

	@RequestMapping("/books/new")
	public String createBook() {
		return "bookcreatenew.jsp";
	}
	
	@PostMapping("/processNewBook") 
		public String processNewBook(
			@RequestParam("title") String title
			, @RequestParam("description") String description
			, @RequestParam("language") String language
			, @RequestParam("numberOfPages") Integer numberOfPages
			
		) {
		System.out.println("title: " + title); 
		System.out.println("description: " + description); 
		System.out.println("language: " + language); 
		System.out.println("numberOfPages: " + numberOfPages); 
		
		Book bookInternalVar = new Book(title, description, language, numberOfPages); 
		bookInternalVar = bookservice.createBook(bookInternalVar); 
			
		return "redirect:/books";
	}
	
// end of methods
}
