package encryptdecrypt;

public class Unicode implements EncryptDecrypt {
    @Override
    public String decrypt(String encryptedMsg, int key) {
        char[] chars = encryptedMsg.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            chars[i] = (char) (chars[i] - key);

        }
        return new String(chars);
    }

    @Override
    public String encrypt(String msg, int key) {
        char[] chars = msg.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            chars[i] = (char) (chars[i] + key);

        }
        return new String(chars);
    }
}
