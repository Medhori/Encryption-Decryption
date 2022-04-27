package encryptdecrypt;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Main {
    public static void main(String[] args) {
        String in = "";
        String out = "";
        String option = "enc";
        String msg = "data";
        int key = 0;
        EncryptDecrypt encDec = new Shift();
        String alg;
        boolean isDataExist = false;
        if (args.length > 0) {
            for (int i = 0; i < args.length; i++) {
                switch (args[i]) {
                    case "-mode":
                        option = args[i + 1];
                        break;
                    case "-alg":
                        alg = args[i + 1];
                        if ("shift".equals(alg)) {
                            encDec = new Shift();
                        } else {
                            encDec = new Unicode();
                        }
                        break;
                    case "-in":
                        in = args[i + 1];
                        break;
                    case "-out":
                        out = args[i + 1];
                        break;
                    case "-key":
                        key = Integer.parseInt(args[i + 1]);
                        break;
                    case "-data":
                        msg = args[i + 1];
                        isDataExist = true;
                        break;
                }
            }
        }


        if (!in.isEmpty() && !isDataExist) {
            try {
                msg = readFileAsString(in);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        switch (option) {
            case "enc":
                msg = encDec.encrypt(msg, key);
                if (!out.isEmpty()) {
                    writeMsg(msg, out);
                } else {
                    System.out.println(msg);
                }

                break;
            case "dec":
                msg = encDec.decrypt(msg, key);
                if (!out.isEmpty()) {
                    writeMsg(msg, out);
                } else {
                    System.out.println(msg);
                }

                break;
            default:
                System.out.println("Error invalid operation!");
                break;
        }
    }

    private static void writeMsg(String msg, String filename) {
        File file = new File(filename);
        try (FileWriter writer = new FileWriter(file)) {
            writer.write(msg);
        } catch (IOException e) {
            System.out.printf("Error %s", e.getMessage());
        }

    }

    public static String readFileAsString(String fileName) throws IOException {
        return new String(Files.readAllBytes(Paths.get(fileName)));
    }
}
