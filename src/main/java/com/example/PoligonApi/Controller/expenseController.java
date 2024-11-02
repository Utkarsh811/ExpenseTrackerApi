package com.example.PoligonApi.Controller;

import com.example.PoligonApi.model.PoligonExpense;
import com.example.PoligonApi.repository.Jpaexpense;
import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class expenseController {

  @Autowired
  private PoligonExpense expense;

  @Autowired
  private Jpaexpense expensedb;

  //read expenses by the user
  @GetMapping("ExpenseTracker")
  public List<PoligonExpense> getallexpenses() {
    List<PoligonExpense> lists = expensedb.findAll();
    return lists;
  }

  //reading expenses by id sending id with function to the server
  @GetMapping("ExpenseTracker/{id}")
  public void getexpensesbyid(@PathVariable("id") int id) {
    expensedb.findById(id);
  }

  //create expense by the user
  @PostMapping("ExpenseTracker")
  public PoligonExpense createExpense(@RequestBody PoligonExpense expense) {
    //inserting data into the database
    //RequestBody is used to send the data  from the client to database
    //listc.add(expense);

    PoligonExpense exp = expensedb.save(expense);
    return exp;
  }

  //update any expense by the user

  @PutMapping("ExpenseTracker")
  public PoligonExpense updateExpense(@RequestBody PoligonExpense expense) { // user sending updated expenses JSON to the sever so use @RequestBody
    PoligonExpense exp = expensedb.save(expense); // we can use save in JPA to send the update request in the database
    return exp;
  }

  //delete any expense by using its id
  @DeleteMapping("ExpenseTracker/{id}")
  public void deletebyId(@PathVariable("id") int id) {
    expensedb.deleteById(id);
  }

  //reading any expense whose expenseamount >250 rupees and category is Grocery
  @GetMapping("ExpenseTracker/{expenseAmount}/{category}")
  public List<PoligonExpense> getexpensesByamountAndcategory(
    @PathVariable("expenseAmount") int expenseAmount,
    @PathVariable("category") String category
  ) {
    List<PoligonExpense> lists = expensedb.findByAmountandCategory(
      expenseAmount,
      category
    );
    return lists;
  }
}
