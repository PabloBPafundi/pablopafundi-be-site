package com.pablopafundi.site.keygeneration;

import org.springframework.stereotype.Service;

import java.security.SecureRandom;
import java.util.Base64;

@Service
public class KeyGenerationService {

    public String generateKey(KeySize keySize) {
        int byteLength = keySize.getBitLength() / 8;
        byte[] randomBytes = new byte[byteLength];

        SecureRandom secureRandom = new SecureRandom();
        secureRandom.nextBytes(randomBytes);

        return Base64.getEncoder().encodeToString(randomBytes);
    }
}