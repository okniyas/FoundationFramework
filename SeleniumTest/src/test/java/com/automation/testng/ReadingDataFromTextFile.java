package com.automation.testng;

import java.io.*;
import java.util.Scanner;

public class ReadingDataFromTextFile {
    public static void main(String[] args) throws IOException {

        //1way

//        FileReader fr = new FileReader("src/test/resources/data/dataName.txt");
//        BufferedReader bf = new BufferedReader(fr);
//        String line;
//        while((line = bf.readLine()) !=null){
//            System.out.println(line);
//        }

        //2way

        Scanner scan = new Scanner(new FileInputStream("src/test/resources/data/dataName.txt"));
        while(scan.hasNextLine()){
            System.out.println(scan.nextLine());
        }

    }
}
