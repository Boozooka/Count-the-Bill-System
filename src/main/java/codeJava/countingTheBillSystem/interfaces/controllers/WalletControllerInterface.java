package codeJava.countingTheBillSystem.interfaces.controllers;

import codeJava.countingTheBillSystem.dto.requests.ChangeBillRequest;
import org.springframework.http.ResponseEntity;

public interface WalletControllerInterface {
    ResponseEntity<?> changeBalance(ChangeBillRequest request);
    ResponseEntity<?> getWalletBalance(String uuid);
}
