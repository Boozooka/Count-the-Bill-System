package codeJava.countingTheBillSystem.controllers;

import codeJava.countingTheBillSystem.dto.requests.ChangeBillRequest;
import codeJava.countingTheBillSystem.services.WalletService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
public class WalletController {

    @Autowired
    WalletService service;

    @PostMapping("/wallet")
    public ResponseEntity<?> changeBalance (@RequestBody ChangeBillRequest request){
        return ResponseEntity.ok("OK");
    }

    @GetMapping("/wallets/")
    public ResponseEntity<?> getWalletBalance (){
        return ResponseEntity.ok("OK");
    }
}
