package codeJava.countingTheBillSystem.interfaces.services;

import codeJava.countingTheBillSystem.base.TypeOfOperation;

public interface WalletServiceInterface {
    void changeBalance(String uuid, TypeOfOperation typeOfOperation, Long amount);
    Long getBalance(String uuidStr);
}
