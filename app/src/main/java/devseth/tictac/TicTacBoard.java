package devseth.tictac;

import android.graphics.Color;
import android.widget.Button;
import android.widget.TextView;


/**
 * Created by Dev Seth on 6/26/2017.
 */

public class TicTacBoard {

    private int stepCount;              //how many moves have occurred? helps to track ties
    private Button btnArray[][];        //array of the buttons, used to change button labels & disable
    private int[][] xyArray;            //int array of 2D button array values, 1 for X, 0 for none, -1 for Y
    private int[][] emptyXYArray;       //an empty XY array used to reset values
    private boolean xDidThis = true;    //did x do this?
    private TextView victoryBoard;      //display winner at the end of a game
    private Button resetButton;         //the button used to reset the game

    public TicTacBoard(Button[][] inputArray, TextView label, Button rstButton){

        btnArray = inputArray;
        xyArray = new int[3][3];
        victoryBoard = label;
        emptyXYArray = new int[3][3];
        resetButton = rstButton;
        stepCount = 0;
        resetBoard();

    }

    private boolean rowCheck(int rowIndex){

        return (xyArray[rowIndex][0] == xyArray[rowIndex][1]) && (xyArray[rowIndex][1] == xyArray[rowIndex][2])
                && xyArray[rowIndex][1] != 0;
    }

    private boolean colCheck(int colIndex){

        return (xyArray[0][colIndex] == xyArray[1][colIndex]) && (xyArray[1][colIndex] == xyArray[2][colIndex])
                && xyArray[1][colIndex] != 0;

    }

    private boolean diagCheck(){

        return ((xyArray[0][0] == xyArray[1][1]) && (xyArray[1][1] == xyArray[2][2])
                && xyArray[1][1] != 0) || ((xyArray[0][2] == xyArray[1][1]) && (xyArray[1][1] == xyArray[2][0])
                && xyArray[1][1] != 0);

    }
    public boolean winCheck(){

        return rowCheck(0) || rowCheck(1) || rowCheck(2) || colCheck(0) || colCheck(1) || colCheck(2) || diagCheck();
    }

    public void pressTile(int row, int col){

        btnArray[row][col].setEnabled(false);
        stepCount++;

        if(xDidThis)
        {
            btnArray[row][col].setText("X");
            btnArray[row][col].setBackgroundColor(Color.rgb(219,112,147));
            xyArray[row][col] = 1;
        }

        else if(!xDidThis)
        {
            btnArray[row][col].setText("O");
            btnArray[row][col].setBackgroundColor(Color.rgb(15,82,186));
            xyArray[row][col] = -1;
        }



        if (winCheck()) {

            for(Button[] x : btnArray){
                for(Button b : x){
                b.setText("WIN");
                b.setBackgroundColor(Color.GREEN);
                    b.setEnabled(false);
            }}

            victoryBoard.setText((xDidThis ?  "X" : "O") + " has won!!!");
            resetButton.setText("RESTART");
            resetButton.setEnabled(true);
        }
        else if(stepCount>=9 && !winCheck())
        {
            victoryBoard.setText("A Damn Tie!");
            resetButton.setText("RESTART");

            resetButton.setEnabled(true);

        }
        xDidThis = !xDidThis;
    }


    public void resetBoard(){

            for(Button[] b : btnArray){
                for (Button x : b) {
                    x.setText("");
                    x.setBackgroundColor(Color.LTGRAY);
                    x.setEnabled(true);
                }
            }

            victoryBoard.setText("");

            resetButton.setBackgroundColor(Color.LTGRAY);
            resetButton.setTextColor(Color.BLACK);

            resetButton.setText("TAC");
        resetButton.setEnabled(false);
        xyArray = new int[][]{{0,0,0}, {0,0,0}, {0,0,0}};
            xDidThis = true;
            stepCount = 0;

    }
    }
