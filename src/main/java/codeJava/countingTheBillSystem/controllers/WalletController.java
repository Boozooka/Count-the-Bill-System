package codeJava.countingTheBillSystem.controllers;

import codeJava.countingTheBillSystem.base.TypeOfOperation;
import codeJava.countingTheBillSystem.dto.requests.AddNewWalletRequest;
import codeJava.countingTheBillSystem.dto.requests.ChangeBillRequest;
import codeJava.countingTheBillSystem.exceptions.BadChangeRequestException;
import codeJava.countingTheBillSystem.exceptions.BadUUIDException;
import codeJava.countingTheBillSystem.interfaces.controllers.WalletControllerInterface;
import codeJava.countingTheBillSystem.interfaces.services.WalletServiceInterface;
import codeJava.countingTheBillSystem.services.WalletService;
import codeJava.countingTheBillSystem.utils.UUIDUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/v1")
public class WalletController implements WalletControllerInterface {

    @Autowired
    UUIDUtils uuidUtils;

    @Autowired
    WalletServiceInterface service;

    @PostMapping("/wallet")
    public ResponseEntity<?> changeBalance (@RequestBody ChangeBillRequest request){

        try {
            TypeOfOperation.valueOf(request.getOperationType());
        } catch (IllegalArgumentException ex){
            throw new BadChangeRequestException("There is no operation '" + request.getOperationType() + "'.");
        }

        if (!uuidUtils.validateUUIDString(request.getUuid())){
            throw new BadUUIDException("Invalid uuid: " + request.getUuid());
        }

        service.changeBalance(
                request.getUuid(),
                TypeOfOperation.valueOf(request.getOperationType()),
                request.getAmount());

        return ResponseEntity.ok("SUCCESSFULLY CHANGE OF BALANCE");
    }

    @GetMapping("/wallets/")
    public ResponseEntity<?> getWalletBalance (@RequestParam(name = "uuid") String uuid){
        if (!uuidUtils.validateUUIDString(uuid)){
            throw new BadUUIDException("Invalid uuid: " + uuid);
        }
        return ResponseEntity.ok(service.getBalance(uuid));
    }

    /*@PostMapping("/add-new-wallet")
    public ResponseEntity<?> addNewWallet (@RequestBody AddNewWalletRequest request){
        service.addNewWallet(request.getUuid());
        return ResponseEntity.ok("OK");
    }*/
}
