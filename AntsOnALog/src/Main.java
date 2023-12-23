import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        File input = new File("antsInput.txt");
        File output = new File("antsOutput.txt");

        Scanner scan = new Scanner(input);
        try {
            FileWriter writer = new FileWriter(output);

            int[] log = new int[Integer.parseInt(scan.nextLine())]; //log length is initialized
            //black is -1, green is 1
            String[] greenAsStrings = scan.nextLine().split(" ");
            String[] blackAsStrings = scan.nextLine().split(" ");

            for (String str : greenAsStrings) {
                log[Integer.parseInt(str)] = 1;
            }
            for (String str : blackAsStrings) {
                log[Integer.parseInt(str)] = -1;
            }

            for (int i = 0; i < log.length; i++)
                if (log[i] != 1 && log[i] != -1)
                    log[i] = 0;


            int numOfSticks = 0;
            int i = 0;


            while (log[i] == 0)
                i++; //find the first ant

            int currentScore = log[i];


            while (i < 14) {
                currentScore += log[i + 1];
                if (currentScore < -1) //two black "in a row"
                    currentScore++;
                if (currentScore > 1) //two green "in a row"
                    currentScore--;
                if (currentScore == 0) {
                    numOfSticks++;
                    currentScore = log[i + 1];
                }
                i++;
            }

            writer.write(numOfSticks + "");
            writer.close();


        }

        catch (IOException e) {
            System.out.println("File output cannot be found");
        }

    }
}