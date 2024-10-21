package config;

import codeJava.countingTheBillSystem.controllers.WalletController;
import codeJava.countingTheBillSystem.exceptions.WalletNotFoundException;
import codeJava.countingTheBillSystem.interfaces.repositories.WalletRepository;
import codeJava.countingTheBillSystem.interfaces.services.WalletServiceInterface;
import codeJava.countingTheBillSystem.models.Wallet;
import codeJava.countingTheBillSystem.services.WalletService;
import codeJava.countingTheBillSystem.utils.UUIDUtils;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;

import java.util.UUID;

@TestConfiguration
public class WalletTestConfiguration {

    @Bean
    UUIDUtils uuidUtils(){
        return new UUIDUtils();
    }

    @Bean
    WalletController walletController(){
        return new WalletController();
    }

    @Bean
    WalletRepository walletRepositoryMock(){
        WalletRepository walletRepositoryMock = Mockito.mock(WalletRepository.class);

        UUID uuid = UUID.fromString("f191962f-bec6-4783-a7e1-ea20a7feca10");
        UUID uuidUnknown = UUID.fromString("f191962f-bec6-4783-a7e1-ea20a7feca11");

        Wallet walletMock = new Wallet(uuid, 1000L);
        Mockito.when(walletRepositoryMock.getReferenceById(uuid)).thenReturn(walletMock);
        Mockito.when(walletRepositoryMock.getReferenceById(uuidUnknown)).thenThrow(WalletNotFoundException.class);
        return walletRepositoryMock;
    }

    @Bean
    WalletService walletService(){
        return new WalletService();
    }
}
