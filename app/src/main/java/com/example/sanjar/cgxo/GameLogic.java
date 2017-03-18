package com.example.sanjar.cgxo;

/**
 * Created by Sanjar on 15.03.2017.
 */

public class GameLogic {

    private GameGrid grid;
    private String winner;
    private boolean active;



    public GameLogic(GameGrid grid){
        this.grid = grid;
        reset();

    }

    public void reset(){
        grid.restart();
        grid.setMessage("This turn of X");
        winner =" ";
        active = true;
    }

    public void press(int x, int y){
        if(active == true){
            if (grid.getContent(x,y) == 'e'){
                if (grid.getTurn()=='x'){
                    grid.setContent(x,y,'x');
                    grid.setTurn('o');
                    grid.setMessage("It's turn of O");
                }
                else if (grid.getTurn()=='o'){
                    grid.setContent(x,y,'o');
                    grid.setTurn('x');
                    grid.setMessage("it's turn of X");
                }
            }

            if(isVictory()){
                grid.setMessage("The winner is" + winner);
                active = false;
            }


        }

    }


    public boolean isVictory(){
        boolean state = false;
        if(grid.getContent(0,0) == 'x' && grid.getContent(0,1) == 'x' && grid.getContent(0,2) == 'x'){
            winner = "X";
            state = true;
        }
        return state;
    }

}
