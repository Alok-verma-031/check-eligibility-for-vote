package com.example.checkforvote.services;

import java.time.Year;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.example.checkforvote.dto.VoteDto;

@Service
public class MainService 
{
	public String checkEligibility(@ModelAttribute VoteDto dto)
	{
		String name=dto.getName();
		int birthYear=dto.getDobYear();
		String gender=dto.getGender();
		int age=0;
		int lessAge;
		int year=Year.now().getValue();
		age=year-birthYear;
		if(age>=18 && gender.equals("Male"))
		{
			return "Mr."+name+"</br>you are Eligible for vote.";
		}
		else if(age>=18 && gender.equals("Female"))
		{
			return "Mrs."+name+"</br>you are Eligible for vote.";
		}
		else if(age<18 && gender.equals("Male"))
		{
			lessAge=18-age;
			return "Mr."+name+"</br>you are not Eligible for vote.</br>After"+lessAge+" year you are eligible for vote.";
		}
		else if(age<18 && gender.equals("Female"))
		{
			lessAge=18-age;
			return "Mrs."+name+"</br>you are not Eligible for vote.</br>After"+lessAge+" year you are eligible for vote.";
		}
		else
		{
		return null;
		}
	}
}
