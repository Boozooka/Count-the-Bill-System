package codeJava.countingTheBillSystem.dto.requests;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ChangeBillRequest {
    private String uuid;
    private String operationType;
    private Long amount;
}
