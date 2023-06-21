package com.me.injin.stock_issue.repository;

import com.me.injin.stock_issue.domain.Stock;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StockRepository extends JpaRepository<Stock, Long> {
}
