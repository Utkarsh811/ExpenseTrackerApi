package com.example.PoligonApi.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

// Requirement for JPA
@Component
@Scope("prototype")
@Entity
//Requirement for JPA
public class PoligonExpense {

  @Id
  private int id;

  private String category;
  private int expenseAmount;
  private String description;

  //constructor

  //getters   setters

  public void setid(int id) {
    this.id = id;
  }

  public void setcategory(String category) {
    this.category = category;
  }

  public void setexpenseAmount(int expenseAmount) {
    this.expenseAmount = expenseAmount;
  }

  public void setdescription(String description) {
    this.description = description;
  }

  public int getid() {
    return this.id;
  }

  public String getcategory() {
    return this.category;
  }

  public int getexpenseAmount(int expenseAmount) {
    return this.expenseAmount;
  }

  public String getdescription(String description) {
    return this.description;
  }
}
