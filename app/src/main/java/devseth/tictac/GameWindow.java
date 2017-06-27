package devseth.tictac;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

public class GameWindow extends AppCompatActivity {
    TicTacBoard board;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_window);

        TextView victoryBoard = (TextView) findViewById(R.id.textView2);
        Button btn1 = (Button) findViewById(R.id.button);
        Button btn2 = (Button) findViewById(R.id.button2);
        Button btn3 = (Button) findViewById(R.id.button3);
        Button btn4 = (Button) findViewById(R.id.button4);
        Button btn5 = (Button) findViewById(R.id.button5);
        Button btn6 = (Button) findViewById(R.id.button6);
        Button btn7 = (Button) findViewById(R.id.button7);
        Button btn8 = (Button) findViewById(R.id.button8);
        Button btn9 = (Button) findViewById(R.id.button9);
        Button resetButton = (Button) findViewById(R.id.resetbutton);
        Button[][] btnArray = {{btn1, btn2, btn3}, {btn4, btn5, btn6}, {btn7, btn8, btn9}};
        board = new TicTacBoard(btnArray, victoryBoard, resetButton);



    }

    public void myBtnClick(View v) {
        switch (v.getId()){

            case R.id.button :
                board.pressTile(0, 0);
                break;
            case R.id.button2 :
                board.pressTile(0, 1);

                break;
            case R.id.button3 :
                board.pressTile(0, 2);

                break;
            case R.id.button4 :
                board.pressTile(1, 0);

                break;
            case R.id.button5 :
                board.pressTile(1, 1);

                break;
            case R.id.button6 :
                board.pressTile(1, 2);

                break;
            case R.id.button7 :
                board.pressTile(2, 0);

                break;
            case R.id.button8 :
                board.pressTile(2, 1);

                break;
            case R.id.button9 :
                board.pressTile(2, 2);
                break;
            case R.id.resetbutton :
                board.resetBoard();

                break;
        }
    }
}
