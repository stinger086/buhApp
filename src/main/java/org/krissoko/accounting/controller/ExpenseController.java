package org.krissoko.accounting.controller;

import org.krissoko.accounting.beans.Expense;
import org.krissoko.accounting.service.AccountingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.List;

import javax.annotation.ManagedBean;

/**
 * Created by Krzysiek on 2016-02-08.
 *
 * Trying my first controller
 * Everything was good when accessing from static main() context, but problems appeared when accessing from Tomcat
 * server with @Autowire annotations.
 */

@ManagedBean
@Controller(Controllers.EXPENSE_CONTROLLER)
//@SessionScoped
public class ExpenseController {

    @Override
    public String toString() {
        return "expense-controller";
    }

    @Autowired
    private AccountingService accountingService;


    private List<Expense> expenseList;

    private final String SCOPE_NAME = "Session";

    public String getSomething() {
        return "something1";
    }

    public void loadAll(){

        if (accountingService == null) {
//            AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DIConfiguration.class);
//            accountingService = context.getBean(AccountingService.class);

            System.out.println("accountingService in ExpenseController is still NULL !!!");

        }
        else {
            expenseList = accountingService.getAllExpenses();
        }

    }

    public List<Expense> getExpenseList(){

        if (expenseList == null)
            loadAll();

        return expenseList;
    }

}
