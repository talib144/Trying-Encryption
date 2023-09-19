package org.example;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import java.security.NoSuchAlgorithmException;

public class EncryptingDES
{
    public static SecretKey key;

    static {
        try {
            key = generateKey();
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }
    public static SecretKey generateKey() throws NoSuchAlgorithmException {
        KeyGenerator keygenerator = KeyGenerator.getInstance("DES");
        return keygenerator.generateKey();
    }

    public static byte[] encrypt( byte[] input, SecretKey key)
            throws Exception {
        Cipher cipher = Cipher.getInstance("DES/ECB/PKCS5Padding");
        cipher.init(Cipher.ENCRYPT_MODE, key);
        return cipher.doFinal(input);
    }

    public static String decrypt( byte[] input, SecretKey key)
            throws Exception {
        Cipher cipher = Cipher.getInstance("DES/ECB/PKCS5Padding");
        cipher.init(Cipher.DECRYPT_MODE, key);
        byte[] plaintext=cipher.doFinal(input);
        return new String(plaintext);
    }
}
