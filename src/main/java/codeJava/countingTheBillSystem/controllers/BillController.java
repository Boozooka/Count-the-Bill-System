package codeJava.countingTheBillSystem.controllers;

import codeJava.countingTheBillSystem.dto.requests.ChangeBillRequest;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
public class BillController {

    @PostMapping("/wallet")
    public ResponseBody changeBalance (@RequestBody ChangeBillRequest request){

    }

    @GetMapping("/wallets/")
    public ResponseBody getWalletBalance (){

    }
}
