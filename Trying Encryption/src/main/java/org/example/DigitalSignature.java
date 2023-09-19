package org.example;

import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.Signature;

public class DigitalSignature {

    public static byte[] signed(String input, PrivateKey privateKey)throws Exception{
        Signature signature=Signature.getInstance("SHA256withRSA");
        signature.initSign(privateKey);
        signature.update(input.getBytes());
        byte[] sign= signature.sign();
        return sign;

    }

    public static boolean verifysign(byte[] sign, PublicKey publicKey, String input)throws Exception{
        Signature verify=Signature.getInstance("SHA256withRSA");
        verify.initVerify(publicKey);
        verify.update(input.getBytes());
        boolean matches=verify.verify(sign);
        return matches;



    }

}
