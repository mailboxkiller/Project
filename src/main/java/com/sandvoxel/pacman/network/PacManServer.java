package com.sandvoxel.pacman.network;

import com.sandvoxel.pacman.Main;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class PacManServer {
    private ServerSocket serverSocket;

    public void start(int port) {
        try {
            serverSocket = new ServerSocket(port);
            while (true)
                Main.gameManager.addPiece(serverSocket.accept());

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void stop() {
        try {
            serverSocket.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}