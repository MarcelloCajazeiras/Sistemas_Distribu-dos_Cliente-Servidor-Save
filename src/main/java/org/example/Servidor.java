package org.example;
import java.net.*;
import java.io.*;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;

public class Servidor {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(5000);
        System.out.println("O Servidor está Executando...");

        while (true) {
            Socket socket = serverSocket.accept();
            InputStream inputStream = socket.getInputStream();
            BufferedImage image = ImageIO.read(inputStream);

            File outputfile = new File("saved.png");
            ImageIO.write(image, "png", outputfile);

            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            out.println(outputfile.getAbsolutePath());

            socket.close();
        }
    }
}

