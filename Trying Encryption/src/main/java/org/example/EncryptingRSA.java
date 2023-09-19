package org.example;

import javax.crypto.Cipher;
import java.nio.charset.StandardCharsets;
import java.security.*;

public class EncryptingRSA {

    public static KeyPair generateRSAKKeyPair() throws Exception {
        KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA");
        keyPairGenerator.initialize(3072);
        return keyPairGenerator.generateKeyPair();
    }
    public static byte[] encrypt(String input, PublicKey publicKey)throws Exception{
        Cipher cipher=Cipher.getInstance("RSA");
        cipher.init(Cipher.ENCRYPT_MODE,publicKey);
        return cipher.doFinal(input.getBytes(StandardCharsets.UTF_8));
    }


    public static String decrypt(byte[] input, PrivateKey privateKey) throws Exception{
        Cipher cipher=Cipher.getInstance("RSA");
        cipher.init(Cipher.DECRYPT_MODE,privateKey);
        byte[] plaintext= cipher.doFinal(input);
        return new String(plaintext);

    }


}
