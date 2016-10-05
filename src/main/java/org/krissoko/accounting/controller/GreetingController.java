package org.krissoko.accounting.controller;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.krissoko.accounting.beans.Expense;
import org.krissoko.accounting.dao.ExpenseDAO;
import org.krissoko.accounting.service.AccountingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class GreetingController {

	@Autowired
	AccountingService accountingService;
	

    @RequestMapping("/greeting")
    public String greeting(@RequestParam(value="name", required=false, defaultValue="World") String name, Model model) {
    	
    	System.out.println("Entering GreetingControler");
    	
        model.addAttribute("name", name);
        
        List<Expense> expenses = accountingService.getAllExpenses();
        int count = expenses.size();
        model.addAttribute("count", count);
        System.out.println("size = " + count);

        StringBuffer sb = new StringBuffer();
        // --------------------------
        for (Expense e : expenses) {
//        	sb.append(e.getId()).append(e.getExpenseName()).append(e.getAmount().toString()).append("\n");
        	sb.append(e.getId()).append(e.getExpenseName()).append("<br/>");
        }
        // --------------------------
        model.addAttribute("output", sb.toString());
        
        System.out.println("end.");
        
        return "greeting";
    }
    
    @RequestMapping("/greeting/aa")
    public String greetingAa(String name, Model model){
    	
    return "aa";	
    }

	//============================================================================================//
	//Insert record
	@RequestMapping(method = RequestMethod.POST, path = "/insert")
	public Map<String, Object> newCustomer(@RequestBody Map<String, Object> customerMap) {
//
//		Expense mCustomer = new Expense();
//		mCustomerRepository.save(mCustomer);
//
		Map<String, Object> successMessage = new LinkedHashMap<String, Object>();
//		successMessage.put("message", "Developer hired Successfully");
//		successMessage.put("customer", mCustomerRepository.save(mCustomer));

		return successMessage;
	}
	//===========================================================================================//
}
