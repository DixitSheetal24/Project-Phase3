package com.example.demo.controller;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import com.example.demo.model.Products;
import com.example.demo.model.Register;

import jakarta.servlet.http.HttpSession;

import com.example.demo.Repository.Productrepository;
import com.example.demo.Repository.UserRepository;



@Controller
public class homeController 
{
	@Autowired
	private Productrepository productrepo;
	@GetMapping("/")
	public String home() 
	{
		return "home";
	}
	
	@GetMapping("/productreport")
		public String productreport(Model m){
	List<Products> list=productrepo.findAll();
	m.addAttribute("all_products",list);
	  	return "viewproduct";
		}
	
	
	
	@GetMapping("/Register")
	public String user()
	{
		return "Register";
	}
	
	@GetMapping("/user")
	public String Login()
	{
		return "Login";
	}
	
	
	@PostMapping("/save_products")
	public String save_products(@ModelAttribute Products products,HttpSession session)
	{
		productrepo.save(products);
		session.setAttribute("msg", "Product added Succesfully..");
		return "redirect:/add";
		
	}
	
	@PostMapping("/update_products")
	public String updateproducts(@ModelAttribute Products products,HttpSession session)
	{
		productrepo.save(products);
		session.setAttribute("msg", "Product updated Succesfully..");
		return "redirect:/add";
	}
	
	@Autowired 
	private UserRepository user_repo;
	
	@PostMapping("/save_user")
	public String save_user(@ModelAttribute Register register,HttpSession session)
	{
		user_repo.save(register);
		session.setAttribute("msg", "Product added Succesfully..");
		return "redirect:/Login";
	}
	
	@GetMapping("/edit_form/{id}")
	public String edit_form(@PathVariable(value="id")String id,Model m)
	{
		Optional<Products> product=productrepo.findById(id);
		Products pro = product.get();
		m.addAttribute("product",pro);
		return "edit";
	}
	@GetMapping("/delet_form/{id}")
	public String delet_form(@PathVariable(value="id")String id,HttpSession session)
	{
		productrepo.deleteById(id);
		session.setAttribute("msg", "Product deleted succesfully");
       return "redirect:/productreport";	
	}
	
	@GetMapping("/add")
	public String saveproducts()
	{
	return "add";
	}
	
	
	@GetMapping("/admin")
	public String admin()
	{
	return "report";
	}
		
    @GetMapping("/userreport")
	public String userreport()
	{
		return("viewuser");
	}
}