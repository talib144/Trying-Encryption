package org.example;



import java.util.Scanner;


import static org.example.EncryptingDES.key;

public class Main
{
    public static void main(String[] args) throws Exception {

        Scanner in=new Scanner(System.in);
        System.out.println("Enter the Text to be Tested:");
        byte[] input=in.nextLine().getBytes();
        System.out.println("\n"+input);


        in.close();

     final byte[] Encrypted_Data=EncryptingDES.encrypt(input,key);
      System.out.println("The Hash Value of:"+ input+" is:\n"+ Encrypted_Data);
      System.out.println("\nThe public Key is:"+key.getEncoded());
      System.out.println("Trying something:"+new String(input));
      String Decrypted_Data= EncryptingDES.decrypt(Encrypted_Data,key);
      System.out.println("\n The Decrypted Message is:"+Decrypted_Data);






    }









//          byte[] Encrypted_data= EncryptingRSA.encrypt(input,publicKey)  ;
//
//          System.out.println("The Hash Value of:"+ input+" is:\n"+ Encrypted_data);
//
//System.out.println("\nThe public Key is:"+publicKey.getEncoded());
//
//        String Decrypted_data= EncryptingRSA.decrypt(Encrypted_data, privateKey);
//
//          System.out.println("\n The Decrypted Message is:"+Decrypted_data);



}