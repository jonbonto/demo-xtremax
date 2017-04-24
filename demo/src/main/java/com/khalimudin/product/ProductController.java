package com.khalimudin.product;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ProductController {
	@Autowired
	ProductRepository prodRep;
	
	@GetMapping("/")
    public String Home() {
               
        return "index";
    }
	
    @GetMapping("/addproduct")
    public String addProduct(Model model) {
        model.addAttribute("product", new Product());        
        return "product";
    }
    
    @GetMapping("/products")
    public String listProduct(Model model, @RequestParam(required=false) boolean success) {
    	List<Product> products = prodRep.findAll();
        model.addAttribute("products", products);
        if(success)
        	model.addAttribute("success","You have added product");
        return "productlist";
      
    }
    
    @GetMapping("/product/{id}")
    public String product(Model model, @PathVariable long id) {
    	Product product = prodRep.findOne(id);
        model.addAttribute("product", product);
        
        return "productdetails";
    }
    
    
    @PostMapping("/addproduct")
    public String addProductProcess(@ModelAttribute @Valid Product product, BindingResult bindingResult, HttpServletRequest request) {
    	if (bindingResult.hasErrors()) {
			
			return "product";
		}
    	prodRep.save(product);
        return "redirect:/products?success=true";
    	
    }

}