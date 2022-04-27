package encryptdecrypt;

public class Shift implements EncryptDecrypt {

    @Override
    public String decrypt(String encryptedMsg, int key) {
        return encrypt(encryptedMsg, 26 - (key % 26));
    }

    @Override
    public String encrypt(String msg, int key) {
        char[] chars = msg.toCharArray();

        for (int i = 0; i < chars.length; i++) {
            if (Character.isLetter(chars[i])) {
                if (Character.isUpperCase(chars[i])) {
                    int originalAlphabetPosition = chars[i] - 'A';
                    int newAlphabetPosition = (originalAlphabetPosition + key) % 26;
                    chars[i] = (char) ('A' + newAlphabetPosition);
                } else {
                    int originalAlphabetPosition = chars[i] - 'a';
                    int newAlphabetPosition = (originalAlphabetPosition + key) % 26;
                    chars[i] = (char) ('a' + newAlphabetPosition);
                }

            }
        }

        return new String(chars);
    }
}
