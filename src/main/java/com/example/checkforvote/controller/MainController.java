package com.example.checkforvote.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.checkforvote.dto.VoteDto;
import com.example.checkforvote.services.MainService;

@Controller
public class MainController {
	
	private MainService mainService;
	public MainController(MainService mainService)
	{
		this.mainService=mainService;
	}
	@GetMapping("/")
	public String showIndex(Model model)
	{
		VoteDto dto=new VoteDto();
		model.addAttribute("dto", dto);
		return "index";
	}
	
	@PostMapping("/")
	public String check(@ModelAttribute VoteDto dto,RedirectAttributes attrib)
	{
		String eligibility=mainService.checkEligibility(dto);
		attrib.addFlashAttribute("msg", eligibility);
		return "redirect:/";
		
	}

}
