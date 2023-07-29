package org.example;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.file.Path;
import java.nio.file.Paths;

public class HttpStatusImageDownloader {
    public void downloadStatusImage(int code) throws IOException {
        HttpStatusChecker statusChecker = new HttpStatusChecker();
        String link = statusChecker.getStatusImage(code);
        URL url = new URL(link);

        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        InputStream inputStream = connection.getInputStream();
        Path path = Paths.get(code + ".jpg");
        FileOutputStream outputStream = new FileOutputStream(path.toFile());
        byte[] buffer = new byte[4096];
        int bytesRead;
        while((bytesRead = inputStream.read(buffer)) != -1){
            outputStream.write(buffer, 0, bytesRead);
        }

    }
}
