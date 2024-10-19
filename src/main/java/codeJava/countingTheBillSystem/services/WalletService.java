package codeJava.countingTheBillSystem.services;

import codeJava.countingTheBillSystem.repositories.WalletRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WalletService {

    @Autowired
    WalletRepository repository;
}
