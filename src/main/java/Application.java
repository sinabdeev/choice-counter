import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;


public class Application {

    static String[] colors = {
            "80FFDB",
            "BFA0F2",
            "0F6E19",
            "0C00BA",
            "282A36",
            "FACE8D"};


    public static void main(String... args) {

        try {

            String dir = "E:\\Downloads\\";
            String fileString = readFile(dir + "2019_09_09_novaia_forma.csv");
            System.out.println("  ");
            System.out.println("  ");
            for (String color: Arrays.asList(colors)) {
                System.out.print("  ");
                System.out.print(color);
                System.out.print(" ---> ");
                Integer x = count(fileString, color);
                System.out.print(x);
                System.out.println("  ");
            }
            System.out.println("  ");


        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    private static Integer count(String str, String findStr) {

        int lastIndex = 0;
        int count = 0;

        while(lastIndex != -1){

            lastIndex = str.indexOf(findStr,lastIndex);

            if(lastIndex != -1){
                count ++;
                lastIndex += findStr.length();
            }
        }
        return count;
    }


    private static String readFile(String fileName) {
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader(fileName));
        } catch (FileNotFoundException e) {

        }
        String line;
        StringBuilder stringBuilder = new StringBuilder();

        try {
            try {
                while ((line = reader.readLine()) != null) {
                    stringBuilder.append(line);
                }
            } catch (IOException e) {

            }

            return stringBuilder.toString();
        } finally {
            try {
                reader.close();
            } catch (IOException e) {

            }
        }
    }




}

