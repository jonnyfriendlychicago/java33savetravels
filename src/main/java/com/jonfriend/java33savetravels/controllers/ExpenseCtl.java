package com.jonfriend.java33savetravels.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.jonfriend.java33savetravels.models.Book;
import com.jonfriend.java33savetravels.models.ExpenseMdl;
import com.jonfriend.java33savetravels.services.ExpenseSrv;

@Controller
public class ExpenseCtl {

	@Autowired
	ExpenseSrv expenseSrv; 
	
	@RequestMapping("/expenses")
	public String expenseList(Model model) {
		List<ExpenseMdl> expenseListy = expenseSrv.allExpense();
		model.addAttribute("expenseListy", expenseListy); 
		return "expenselist.jsp"; 
	}

	@RequestMapping("/expenses/{expenseID}") 
	public String expenseView(Model model, @PathVariable("expenseId") Long expenseId) {
		
		ExpenseMdl expenseMdl = expenseSrv.findExpense(expenseId); 
		model.addAttribute("expense", expenseMdl);  
		 
		
//		List<Book> bookListy = bookservice.allBooks(); 
//		model.addAttribute("bookListy", bookListy); 
		
		return "expenseprofile.jsp"; 
	}
	
	@RequestMapping("/expenses/new")
	public String createExpense( @ModelAttribute("expense") ExpenseMdl expenseMdl ) {
		return "expensecreatenew.jsp";
	}
	
	@PostMapping("/processNewExpense") 
	public String processNewExpense(
		@Valid 
		@ModelAttribute("expense") ExpenseMdl expenseMdl, 
		BindingResult result
		
	) {
		if (result.hasErrors()) {
            return "expensecreatenew.jsp"; 
        } else {
        	expenseSrv.createExpense(expenseMdl);
            return "redirect:/expenses";
        }
	}
// end ctl
}
