package security;

import org.mindrot.jbcrypt.BCrypt;
import java.security.MessageDigest;
import java.util.Arrays;

public class HashExamples {
    public static void main(String[] args) throws Exception {
        System.out.println(hashUsingMD5("abccd"));
        System.out.println("==========================================");
        System.out.println(hashUsingSHA1("abccd"));


        System.out.println("==========================================");
        String hashedPassword = hash("prashant");
        System.out.println("hashedPassword :" + hashedPassword);
        System.out.println(verify("prashant", hashedPassword));
    }

    /*
        👉 Problem:
        Same password → same hash every time
        Easy to match with rainbow tables
        No brute force needed → instant crack
        Older systems (using MD5/SHA1) → vulnerable
        Modern apps (Spring Security, etc.) → safe by default
     */
    public static String hashUsingMD5(String input) throws Exception {
        MessageDigest md = MessageDigest.getInstance("MD5");
        System.out.println("input byte is :" + Arrays.toString(input.getBytes()));
        byte[] hashBytes = md.digest(input.getBytes());
        System.out.println("input hashBytes byte is :" + Arrays.toString(hashBytes));
        StringBuilder sb = new StringBuilder();
        for (byte b : hashBytes) {
            sb.append(String.format("%02x", b));
        }
        return sb.toString();
    }

    /* ️ How to prevent Rainbow Table attacks
        ✅ 1. Use Salting (MOST IMPORTANT)
        String salted = password + randomSalt;
        Use bcrypt or Argon2 or scrypt ----> Automatically add salt & hard to attack.
     */

    public static String hashUsingSHA1(String input) throws Exception {
        MessageDigest md = MessageDigest.getInstance("SHA1");
        System.out.println("input byte is :" + Arrays.toString(input.getBytes()));
        byte[] hashBytes = md.digest(input.getBytes());
        System.out.println("input hashBytes byte is :" + Arrays.toString(hashBytes));
        StringBuilder sb = new StringBuilder();
        for (byte b : hashBytes) {
            sb.append(String.format("%02x", b));
        }
        return sb.toString();
    }

    // Hash password
    public static String hash(String input) {
        return BCrypt.hashpw(input, BCrypt.gensalt(12)); // 12 = cost factor
    }

    // Verify password
    public static boolean verify(String input, String storedHash) {
        return BCrypt.checkpw(input, storedHash);
    }
}