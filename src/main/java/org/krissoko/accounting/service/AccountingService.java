package org.krissoko.accounting.service;

import org.krissoko.accounting.beans.Expense;
import org.krissoko.accounting.dao.ExpenseDAO;
//import org.krissoko.accounting.dao.ExpenseDAO;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * Created by Krzysiek on 2016-02-07.
 *
 * Main accounting service, responsible for dealing with expense entries
 *
 */
// @Configurable
@Service(Services.ACCOUNTING_SERVICE)
public class AccountingService implements AbstractAccountingService, InitializingBean {

    @Override
    public String toString() {
        return "accounting-service";
    }

    @Autowired
    private ExpenseDAO expenseDAO;

    private List<Expense> allExpenses;


    public void doSomethingWithDao(String someStringyInfo, Date createDate) {

        logEntry(someStringyInfo, createDate);

    }

    private void logEntry(String expenseName, Date createDate) {

        Expense expense = new Expense(createDate, expenseName);
        expenseDAO.save(expense);
    }

    public List<Expense> getAllExpenses() {
        return expenseDAO.findAll();
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("Accounting Service - afterPropertiesSet - initializing...");
    }
}
