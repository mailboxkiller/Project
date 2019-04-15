package com.sandvoxel.pacman.game;

import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class GameManager {
    private List<List<GamePiece>> gamePieces = new ArrayList<>();
    private int connectedGamePieces = 0;


    public void addPiece(Socket socket){
        GamePiece gamePiece = new GamePiece(socket);
        List<GamePiece> gamePieces = new ArrayList<>();
        gamePieces.add(gamePiece.getY(),gamePiece);
        this.gamePieces.add(gamePiece.getX(),gamePieces);
        connectedGamePieces++;
    }

    public void RemovePiece(int x, int y){
        gamePieces.get(x).remove(y);
        connectedGamePieces--;
    }

}
