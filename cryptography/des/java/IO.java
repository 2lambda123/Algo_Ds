package cryptography.des.java;

import java.io.*;
import java.nio.file.Files;

public class IO {

    private final String INPUT_FILE_PATH;

    private final String OUTPUT_FILE_PATH;

    public IO(String inputFilePath, String outputFilePath) {
        this.INPUT_FILE_PATH = inputFilePath;
        this.OUTPUT_FILE_PATH = outputFilePath;
    }

    public String readMessageFromFile() {
        try (BufferedReader reader = new BufferedReader(new FileReader(INPUT_FILE_PATH))) {
            return reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

    public String readKeyFromFile() {
        try (BufferedReader reader = new BufferedReader(new FileReader(INPUT_FILE_PATH))) {
            reader.readLine();
            return reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

    public void writeStringInFile(String text) {
        try (BufferedWriter writer = Files.newBufferedWriter(OUTPUT_FILE_PATH.toPath())) {
            writer.write(text);
            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
