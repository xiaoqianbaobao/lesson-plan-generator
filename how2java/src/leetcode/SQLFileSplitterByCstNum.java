package leetcode;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class SQLFileSplitterByCstNum {
    public static void main(String[] args) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader("output.sql"));
            String line;

            FileWriter[] writers = new FileWriter[4];
            for (int i = 0; i < 4; i++) {
                writers[i] = new FileWriter("output_" + i + ".sql");
            }

            while ((line = reader.readLine()) != null) {
                String cstNum = extractCstNum(line);
                if (cstNum != null) {
                    int lastTwoDigits = Integer.parseInt(cstNum.substring(8));
                    int fileIndex = lastTwoDigits / 25;

                    if (fileIndex < 0) {
                        fileIndex = 0;
                    } else if (fileIndex > 3) {
                        fileIndex = 3;
                    }

                    writers[fileIndex].write(line + "\n");
                }
            }

            reader.close();
            for (FileWriter writer : writers) {
                writer.close();
            }

            System.out.println("Splitting complete!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static String extractCstNum(String sql) {
        int cstNumStart = sql.indexOf("CST_NUM");
        if (cstNumStart != -1) {
            int valueStart = sql.indexOf("'", cstNumStart) + 1;
            int valueEnd = sql.indexOf("'", valueStart);
            if (valueStart != -1 && valueEnd != -1) {
                return sql.substring(valueStart, valueEnd);
            }
        }
        return null;
    }
}

