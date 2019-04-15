package com.sandvoxel.pacman.game;

import com.sandvoxel.pacman.Main;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Arrays;

public class GamePiece {
    private int x, y;
    private String ID;

    public GamePiece(Socket socket) {

        new EchoClientHandler(socket, this).start();
    }


    private static class EchoClientHandler extends Thread {
        private GamePiece gamePiece;
        private Socket clientSocket;
        private PrintWriter out;
        private BufferedReader in;

        public EchoClientHandler(Socket socket, GamePiece gamePiece) {
            this.clientSocket = socket;
            this.gamePiece = gamePiece;
        }

        public void run() {
            try {
                out = new PrintWriter(clientSocket.getOutputStream(), true);

                in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                String inputLine;
                out.println("this test MEME");

                while ((inputLine = in.readLine()) != null) {

                    if (".".equals(inputLine)) {
                        out.println("bye");
                        break;
                    }

                    String[] input = inputLine.split(",");

                    gamePiece.x = Integer.parseInt(input[0]);
                    gamePiece.y = Integer.parseInt(input[1]);
                    gamePiece.ID = "[" + Integer.getInteger(input[0]) + "," + Integer.getInteger(input[1]) + "]";

                    out.println("Connected ID: [" + inputLine + "]");
                }

                in.close();
                out.close();
                clientSocket.close();
            } catch (Exception e) {
                Main.gameManager.RemovePiece(gamePiece.x, gamePiece.y);
                e.printStackTrace();
            }
        }
    }
    public int[] getXY() {
        int[] XY = {x,y};
        return XY;
    }
    public void setXY(int X, int Y) {
        x = X;
        y = Y;
    }
    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getID() {
        return ID;
    }
}
