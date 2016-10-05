package org.krissoko.accounting.service;

import java.util.List;

import org.krissoko.accounting.beans.Expense;

/**
 * Created by Krzysiek on 2016-02-15.
 */
public interface AbstractAccountingService {

    public List<Expense> getAllExpenses();
}
