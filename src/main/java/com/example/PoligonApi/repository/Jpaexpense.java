package com.example.PoligonApi.repository;

import com.example.PoligonApi.model.PoligonExpense;
import java.util.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
//import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface Jpaexpense extends JpaRepository<PoligonExpense, Integer> {
  @Query(
    "select p from PoligonExpense as  p where p.expenseAmount>=?1 and p.category = ?2 "
  )
  public List<PoligonExpense> findByAmountandCategory(
    int expenseAmount,
    String category
  );
}
