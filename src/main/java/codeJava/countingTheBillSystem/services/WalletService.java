package codeJava.countingTheBillSystem.services;

import codeJava.countingTheBillSystem.base.TypeOfOperation;
import codeJava.countingTheBillSystem.exceptions.WalletNotFoundException;
import codeJava.countingTheBillSystem.interfaces.repositories.WalletRepository;
import codeJava.countingTheBillSystem.interfaces.services.WalletServiceInterface;
import codeJava.countingTheBillSystem.models.Wallet;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.UUID;

@Service
public class WalletService implements WalletServiceInterface {

    @Autowired
    WalletRepository repository;

    @Override
    public void changeBalance(String uuidStr, TypeOfOperation typeOfOperation, Long amount) {
        UUID uuid = UUID.fromString(uuidStr);
        try {
            Wallet wallet = repository.getReferenceById(uuid);
            Long oldBalance = wallet.getBalance();
            switch (typeOfOperation){
                case DEFINITION -> wallet.setBalance(oldBalance += amount);
                case WITHDRAW -> wallet.setBalance(oldBalance -= amount);
            }
            repository.save(wallet);
        } catch (EntityNotFoundException ex){
            throw new WalletNotFoundException("Not found Wallet with uuid '" + uuidStr + "'.");
        }
    }

    @Override
    public Long getBalance(String uuidStr) {
        UUID uuid = UUID.fromString(uuidStr);
        try {
            Wallet wallet = repository.getReferenceById(uuid);
            return wallet.getBalance();
        } catch (EntityNotFoundException ex){
            throw new WalletNotFoundException("Not found Wallet with uuid '" + uuidStr + "'.");
        }
    }

    /*public void addNewWallet(String uuidStr){
        UUID uuid = UUID.fromString(uuidStr);

        Wallet wallet = new Wallet(uuid, 0L);
        repository.save(wallet);
    }*/
}
