package cryptography.des.java;

import io.github.pixee.security.BoundedLineReader;
import java.io.*;

public class IO {

    private final String INPUT_FILE_PATH;

    private final String OUTPUT_FILE_PATH;

    public IO(String inputFilePath, String outputFilePath) {
        this.INPUT_FILE_PATH = inputFilePath;
        this.OUTPUT_FILE_PATH = outputFilePath;
    }

    public String readMessageFromFile() {
        try (BufferedReader reader = new BufferedReader(new FileReader(INPUT_FILE_PATH))) {
            return BoundedLineReader.readLine(reader, 5_000_000);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

    public String readKeyFromFile() {
        try (BufferedReader reader = new BufferedReader(new FileReader(INPUT_FILE_PATH))) {
            BoundedLineReader.readLine(reader, 5_000_000);
            return BoundedLineReader.readLine(reader, 5_000_000);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

    public void writeStringInFile(String text) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(OUTPUT_FILE_PATH))) {
            writer.write(text);
            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
