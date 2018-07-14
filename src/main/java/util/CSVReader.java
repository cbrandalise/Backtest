package util;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class CSVReader {
    public static String[][] read(String path, String separator) {
        String line = "";
        ArrayList<String[]> result = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            while((line = br.readLine()) != null) {
                String[] data = line.split(separator);
                result.add(data);
            }
            String[][] converter = new String[result.size()][result.get(0).length];
            return result.toArray(converter);
        }
        catch(IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
