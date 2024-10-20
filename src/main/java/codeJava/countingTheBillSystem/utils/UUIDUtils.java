package codeJava.countingTheBillSystem.utils;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class UUIDUtils {

    public boolean validateUUIDString (String uuidStr){
        try {
            UUID.fromString(uuidStr);
            return true;
        } catch (IllegalArgumentException ex){
            return false;
        }
    }
}
