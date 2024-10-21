import static org.junit.jupiter.api.Assertions.*;

import codeJava.countingTheBillSystem.base.TypeOfOperation;
import codeJava.countingTheBillSystem.controllers.WalletController;
import codeJava.countingTheBillSystem.dto.requests.ChangeBillRequest;
import codeJava.countingTheBillSystem.exceptions.BadChangeRequestException;
import codeJava.countingTheBillSystem.exceptions.BadUUIDException;
import codeJava.countingTheBillSystem.exceptions.WalletNotFoundException;
import codeJava.countingTheBillSystem.services.WalletService;
import codeJava.countingTheBillSystem.utils.UUIDUtils;
import config.WalletTestConfiguration;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

import java.util.List;


@SpringBootTest(classes = ApplicationRunner.class)
@ContextConfiguration(classes = WalletTestConfiguration.class)
public class WalletTests {

    private final static String VALID_UUID_STR = "f191962f-bec6-4783-a7e1-ea20a7feca10";
    private final static String VALID_UNKNOWN_UUID_STR = "f191962f-bec6-4783-a7e1-ea20a7feca11";
    private final static String INVALID_UUID_STR = "19197e1-ea20eca10";
    private final static String VALID_OPERATION_TYPE = "DEFINITION";
    private final static String INVALID_OPERATION_TYPE = "null";

    @Autowired
    UUIDUtils uuidUtils;

    @Autowired
    WalletController walletController;

    @Autowired
    WalletService walletService;

    @Test
    void testUUIDUtilsValidation(){
        uuidUtils = new UUIDUtils();

        assertTrue(uuidUtils.validateUUIDString(VALID_UUID_STR));
        assertFalse(uuidUtils.validateUUIDString(INVALID_UUID_STR));
    }

    @Test
    void testWalletController(){
        ChangeBillRequest changeBillRequestValid = new ChangeBillRequest(
                VALID_UUID_STR,
                VALID_OPERATION_TYPE,
                1000L
        );

        ChangeBillRequest changeBillRequestInvalidUUID = new ChangeBillRequest(
                INVALID_UUID_STR,
                VALID_OPERATION_TYPE,
                1000L
        );

        ChangeBillRequest changeBillRequestInvalidOperationType = new ChangeBillRequest(
                VALID_UUID_STR,
                INVALID_OPERATION_TYPE,
                1000L
        );

        assertDoesNotThrow(() -> {
            walletController.changeBalance(changeBillRequestValid);
        });

        assertThrows(BadUUIDException.class, () -> {
            walletController.changeBalance(changeBillRequestInvalidUUID);
        });

        assertThrows(BadChangeRequestException.class, () -> {
            walletController.changeBalance(changeBillRequestInvalidOperationType);
        });
    }

    @Test
    void testWalletService(){
        assertDoesNotThrow(() -> {
            walletService.changeBalance(
                    VALID_UUID_STR,
                    TypeOfOperation.valueOf(VALID_OPERATION_TYPE),
                    1000L);
        });

        assertThrows(WalletNotFoundException.class, () -> {
            walletService.changeBalance(
                    VALID_UNKNOWN_UUID_STR,
                    TypeOfOperation.valueOf(VALID_OPERATION_TYPE),
                    1000L
            );
        });
    }
}
