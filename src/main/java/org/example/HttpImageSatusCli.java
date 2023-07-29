package org.example;

import java.io.IOException;
import java.util.Scanner;

public class HttpImageSatusCli {

    public static void main(String[] args){
        HttpImageSatusCli httpImageSatusCli = new HttpImageSatusCli();
        httpImageSatusCli.askStatus();
    }

    public void askStatus(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter Http status code");

        if(scanner.hasNextInt()){
            int code = scanner.nextInt();
            HttpStatusImageDownloader httpStatusImageDownloader = new HttpStatusImageDownloader();
            try{
                httpStatusImageDownloader.downloadStatusImage(code);
            } catch (IOException e){
                System.out.println("There is no image for code " + code);
            }
        }
        else{
            System.out.println("Please enter valid number");
        }

    }
}
