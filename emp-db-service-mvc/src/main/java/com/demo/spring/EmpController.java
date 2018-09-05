package com.demo.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.demo.spring.entity.Emp;
import com.demo.spring.repo.EmpRepository;

@Controller
public class EmpController {

	@Autowired
	EmpRepository repo;

	@RequestMapping(path = "/addEmp", method = RequestMethod.GET)
	public String getPage() {
		return "addEmp";
	}

	@RequestMapping(path = "/addEmp", method = RequestMethod.POST)
	public ModelAndView processAddEmp(Emp emp) {

		ModelAndView mv = new ModelAndView();
		if (emp.getEmpId() >=1) {
			if(!repo.existsById(emp.getEmpId())) {
			repo.save(emp);
			mv.addObject("emp", emp);
			mv.setViewName("successAdd");
			}else {
				mv.addObject("status","Employee Already Exists");
				mv.setViewName("failureAdd");
			}
		} else {
			mv.addObject("status", "OOPS! Something Went Wrong..");
			mv.setViewName("failureAdd");
		}
		return mv;
	}
}
