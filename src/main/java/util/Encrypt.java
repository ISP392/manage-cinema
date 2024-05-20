package util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Scanner;

public class Encrypt {
    public static String toSHA1(String input) throws NoSuchAlgorithmException {
        MessageDigest mDigest = MessageDigest.getInstance("SHA1");
        byte[] result = mDigest.digest(input.getBytes());
        StringBuilder sb = new StringBuilder();
        for (byte b : result) {
            sb.append(Integer.toString((b & 0xff) + 0x100, 16).substring(1));
        }

        return sb.toString();
    }

    public static void main(String[] args) throws NoSuchAlgorithmException {
        System.out.println("Enter your password: ");
        Scanner sc = new Scanner(System.in);
        String password = sc.nextLine();
        if(toSHA1(password).equals("aaf4c61ddcc5e8a2dabede0f3b482cd9aea9434d")){ // password is "hello"
            System.out.println("Correct password");
        }else{
            System.out.println("Incorrect password");
        }
    }
}
