package codeJava.countingTheBillSystem.dto.responses;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class WalletBalanceResponse {
    private Long amount;
}
