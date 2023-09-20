import java.io.*;
import java.util.Scanner;

public class Assignment3 {
    public static void main(String[] args) {

        //Create a new directory using java code
        Scanner directoryObj = new Scanner(System.in);
        System.out.println("Enter the directory name : ");
        String directoryName = directoryObj.nextLine();
        File directory = new File(directoryName);
        if (!directory.exists()) {
            if (directory.mkdir()) {
                System.out.println("Directory created: " + directory);
            }
        }
        else {
            System.out.println("There have some problem in time of creating directory");
            return;
        }

        //create a new file with name and ID
        String fileName = "Md.Moien_Uddin_30132.docx";
        File file = new File(directory, fileName);
        try {
            if (file.createNewFile()) {
                System.out.println("Created File Name is: " + fileName);
            } else System.out.println("File already exists");
        } catch (IOException ioe) {
            System.out.println("There have some problem");
            ioe.printStackTrace();
            return;
        }

        //Get file path through java coding
        String filePath = file.getAbsolutePath();
        System.out.println("File path is: " + filePath);

        //Write something on the newly created file
        try (FileOutputStream writeStream = new FileOutputStream(file)) {
            Scanner textObj = new Scanner(System.in);
            System.out.println("Write what you want : ");
            String text = textObj.nextLine();
            byte[] bytes = text.getBytes();
            writeStream.write(bytes);
        } catch (IOException ioe) {
            System.out.println("There have some problem");
            ioe.printStackTrace();
        }

        //Read from the first file then write to a new Output File
        String OutputFileName = "newFileCreated.txt";
        File outputFile = new File(directory, OutputFileName);
        try (FileInputStream inputStream = new FileInputStream(file);
             FileOutputStream outputStream = new FileOutputStream(outputFile)) {
            int temp;
            while ((temp = inputStream.read()) != -1) {
                outputStream.write((byte)temp);
            }
            System.out.println("Written in the output file");
        } catch (IOException ioe) {
            System.out.println("Sorry for error");
            ioe.printStackTrace();
        }
    }
}
