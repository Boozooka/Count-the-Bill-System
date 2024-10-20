package codeJava.countingTheBillSystem.controllers;

import codeJava.countingTheBillSystem.base.TypeOfOperation;
import codeJava.countingTheBillSystem.dto.requests.ChangeBillRequest;
import codeJava.countingTheBillSystem.interfaces.controllers.WalletControllerInterface;
import codeJava.countingTheBillSystem.services.WalletService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
public class WalletController implements WalletControllerInterface {

    @Autowired
    WalletService service;

    @PostMapping("/wallet")
    public ResponseEntity<?> changeBalance (@RequestBody ChangeBillRequest request){

        service.changeBalance(
                request.getUuid(),
                TypeOfOperation.valueOf(request.getOperationType()),
                request.getAmount());

        return ResponseEntity.ok("SUCCESSFULLY CHANGE OF BALANCE");
    }

    @GetMapping("/wallets/")
    public ResponseEntity<?> getWalletBalance (@RequestParam(name = "uuid") String uuid){
        return ResponseEntity.ok(service.getBalance(uuid));
    }
}
