package com.example.sanjar.cgxo;

import java.security.PublicKey;
import java.util.Arrays;

/**
 * Created by Sanjar on 15.03.2017.
 */

public class GameGrid {

    private char[][] gridArray;
    private char turn;
    private String message;

//отвечает за состояние игры, хранит в себе инфу, какое сообщение вставить и тд и что вставить

    public GameGrid(){
        gridArray = new char[3][3];
        restart();
    }

    public void restart() {
        //назначать ход Х
        //заного заполнить массив Е
        Arrays.fill(gridArray[0], 'e');  //заполняем по строкам Ешками
        Arrays.fill(gridArray[1], 'e');
        Arrays.fill(gridArray[2], 'e');

        turn = 'x';
        message = "";
    }

    public char getContent(int x, int y){
        return gridArray[x][y];
    }

    public void setContent(int x, int y, char symbol){
        gridArray[x][y]=symbol;
    }

    public char getTurn(){
        return turn;
    }

    public void setTurn(char symbol){
        this.turn = symbol;
    }

    public String getMessage(){
        return message;
    }

    public void setMessage(String message){
        this.message = message;
    }




}
