package org.krissoko.accounting.dao;

import org.krissoko.accounting.beans.Expense;
import org.springframework.stereotype.Repository;

/**
 * Created by Krzysiek on 2016-02-07.
 *
 */
@Repository(DAOs.EXPENSE_DAO)
public class ExpenseDAO extends AbstractDAO<Expense> {

    public ExpenseDAO() {
        super();
    }

    // TO BE CONTINUED...


    @Override
    public String toString() {
        return "expense-dao";
    }

}
