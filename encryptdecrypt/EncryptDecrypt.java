package encryptdecrypt;

public interface EncryptDecrypt {
    String decrypt(String encryptedMsg, int key);
    String encrypt(String msg, int key);
}
