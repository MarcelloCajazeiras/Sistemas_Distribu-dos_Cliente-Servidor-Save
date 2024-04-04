package org.example;

import java.net.*;
import java.io.*;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;

public class Cliente {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("localhost", 5000);
        OutputStream outputStream = socket.getOutputStream();

        BufferedImage image = ImageIO.read(new File("logopython.png"));
        ImageIO.write(image, "png", outputStream);
        outputStream.flush();
        socket.shutdownOutput();

        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        String path = in.readLine();
        System.out.println("Imagem salva em: " + path);

        socket.close();
    }
}
