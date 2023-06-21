package com.me.injin.stock_issue.facade;

import com.me.injin.stock_issue.repository.LockRepository;
import com.me.injin.stock_issue.service.StockService;
import org.springframework.stereotype.Component;

@Component
public class NamedLockStockFacade {

    private final LockRepository lockRepository;

    private final StockService stockService;

    public NamedLockStockFacade(LockRepository lockRepository, StockService stockService) {
        this.lockRepository = lockRepository;
        this.stockService = stockService;
    }

    public void decrease(Long id, Long quantity) {
        try {
            lockRepository.getLock(id.toString());
            stockService.decrease(id, quantity);

        } finally {
            lockRepository.releaseLock(id.toString());
        }
    }
}
