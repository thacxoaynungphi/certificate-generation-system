package com.hueic.CerGS.util;

import com.sun.crypto.provider.SunJCE;
import javax.crypto.*;
import javax.crypto.spec.*;
import java.io.IOException;
import java.security.*;
import org.omg.CORBA.SystemException;

import sun.misc.*;

public class DESPasswordEncrypt {

    private static String characterEncoding = "ASCII";
    private static Cipher encryptCipher;
    private static Cipher decryptCipher;
    private static BASE64Encoder base64Encoder = new BASE64Encoder();
    private static BASE64Decoder base64Decoder = new BASE64Decoder();
    private static DESPasswordEncrypt inst = null;
    private static Object lock = new Object();
    private static final byte[] keyBytes = {0x01, 0x02, 0x04, 0x08, 0x08, 0x04, 0x02, 0x01};
    private static final byte[] ivBytes = {0x00, 0x01, 0x02, 0x03, 0x04, 0x05, 0x06, 0x07};

    private DESPasswordEncrypt() {
    }

    public static DESPasswordEncrypt getInstance() throws SystemException {
        try {

            if (inst == null) {
                synchronized (lock) {

                    if (inst == null) {
                        inst = new DESPasswordEncrypt();
                        Security.addProvider(new SunJCE());
                        SecretKey key = new SecretKeySpec(keyBytes, "DES");
                        IvParameterSpec iv = new IvParameterSpec(ivBytes);

                        encryptCipher = Cipher.getInstance("DES/CBC/PKCS5Padding", "SunJCE");
                        encryptCipher.init(Cipher.ENCRYPT_MODE, key, iv);

                        decryptCipher = Cipher.getInstance("DES/CBC/PKCS5Padding", "SunJCE");
                        decryptCipher.init(Cipher.DECRYPT_MODE, key, iv);
                    }
                }
            }
        } catch (NoSuchAlgorithmException ne) {
        } catch (NoSuchPaddingException pe) {
        } catch (InvalidKeyException ie) {
        } catch (InvalidAlgorithmParameterException iae) {
        } catch (NoSuchProviderException npe) {
        }

        return inst;
    }

    synchronized public String encrypt(String password) throws SystemException {

        String encodedEncryptedPassword = null;
        // Make sure SUN are a valid provider
        Security.addProvider(new com.sun.crypto.provider.SunJCE());

        try {
            byte[] passwordBytes = password.getBytes(characterEncoding);
            byte[] encryptedPasswordBytes = encryptCipher.doFinal(passwordBytes);

            encodedEncryptedPassword = base64Encoder.encode(encryptedPasswordBytes);

        } catch (IOException ioe) {
        } catch (BadPaddingException be) {
        } catch (IllegalBlockSizeException ie) {
        }

        return encodedEncryptedPassword;
    }

    synchronized public String decrypt(String encodedEncryptedPassword) throws SystemException {
        if (encodedEncryptedPassword == null) {
            return null;
        }

        String recoveredPassword = null;
        // Make sure SUN are a valid provider
        Security.addProvider(new com.sun.crypto.provider.SunJCE());

        try {
            byte[] encryptedPasswordBytes = base64Decoder.decodeBuffer(encodedEncryptedPassword);
            byte[] passwordBytes = decryptCipher.doFinal(encryptedPasswordBytes);

            recoveredPassword = new String(passwordBytes, characterEncoding);

        } catch (IOException ioe) {
        } catch (BadPaddingException be) {
        } catch (IllegalBlockSizeException ie) {
        }

        return recoveredPassword;
    }
    // <editor-fold defaultstate="collapsed" desc=" Example Main Method ">
    /*
    public static void main(String[] args) {
    try {
    //	Make sure SUN are a valid provider
    // Security.addProvider(new com.sun.crypto.provider.SunJCE());
    //		Password encrypt agent that assumes the password is only ASCII characters
    DESPasswordEncrypt passwordEncryptAgent = DESPasswordEncrypt.getInstance();
    String password = "minhnguyen";
    // Since the example password encrypter is setup to convert the password to ASCII bytes
    // before encrypting, make sure that the password is in fact ASCII (in this case printable ASCII).
    //if (!password.matches("[ -~]{6,}"))
    //throw new IllegalArgumentException("Password must be printable ASCII");
    System.out.println(
    "Password ....................[" + password + "]");
    String encodedEncryptedPassword =
    passwordEncryptAgent.encrypt(password);
    System.out.println(
    " Encoded encrypted password ..["
    + encodedEncryptedPassword
    + "]");
    System.out.println(
    "Length of Encr Pwd:" + encodedEncryptedPassword.length());
    String recoveredPassword = passwordEncryptAgent.decrypt(encodedEncryptedPassword);
    System.out.println("Recovered password ..........[" + recoveredPassword + "]");
    } catch (SystemException se) {
    se.printStackTrace();
    }
    }
     */
    // </editor-fold>
}
