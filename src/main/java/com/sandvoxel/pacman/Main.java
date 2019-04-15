package com.sandvoxel.pacman;

import com.sandvoxel.pacman.game.GameManager;
import com.sandvoxel.pacman.network.PacManServer;

public class Main {

    public static GameManager gameManager = new GameManager();

    public static void main(String[] args) {
        PacManServer pacManServer = new PacManServer();
        pacManServer.start(6666);
    }



}
