package app.stockcontrol.controller;

import java.security.MessageDigest;

public class EncryptMD5 {

    private String hash;
    public String returnHash(String password) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(password.getBytes());
            byte[] bytes = md.digest();

            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < bytes.length; i++) {
                sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
            }
            this.hash = sb.toString();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        return hash;
    }
}
