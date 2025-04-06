package leetcode;


import java.io.FileWriter;
import java.io.IOException;

public class SQLGeneratorWithCstNum {
    public static void main(String[] args) {
        String templateSQL = "INSERT INTO your_table (CST_NUM) VALUES ('{{CST_NUM}}');";

        try {
            FileWriter writer = new FileWriter("output.sql");

            for (int i = 1; i <= 10000; i++) {
                String newSQL = generateNewSQL(templateSQL, i);
                writer.write(newSQL + "\n");
            }

            writer.close();
            System.out.println("SQL generation complete!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static String generateNewSQL(String templateSQL, int cstNum) {
        String newSQL = templateSQL.replace("{{CST_NUM}}", foddrmatCstNum(cstNum));
        return newSQL;
    }

    private static String foddrmatCstNum(int cstNum) {
        return String.format("%010d", cstNum);
    }
}
