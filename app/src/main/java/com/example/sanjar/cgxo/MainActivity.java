package com.example.sanjar.cgxo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {
        Button b00,b01,b02,b10,b11,b12,b20,b21,b22,br;
        TextView tv;
        View.OnClickListener oclBtn;
    GameGrid grid;
    GameLogic logic;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        oclBtn = new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                switch (view.getId()){
                    case R.id.b00:
                        update(0,0);
                        break;
                    case R.id.b01:
                        update(0,1);
                        break;
                    case R.id.b02:
                        update(0,2);
                        break;
                    case R.id.b10:
                        update(1,0);
                        break;
                    case R.id.b11:
                        update(1,1);
                        break;
                    case R.id.b12:
                        update(1,2);
                        break;
                    case R.id.b20:
                        update(2,0);
                        break;
                    case R.id.b21:
                        update(2,1);
                        break;
                    case R.id.b22:
                        update(2,2);
                        break;
                    case R.id.restart:
                        restart();
                        break;

                }

            }
        };
        init();
        draw();

    }
    public void init() {
        b00 = (Button) findViewById(R.id.b00);
        b01 = (Button) findViewById(R.id.b01);
        b02 = (Button) findViewById(R.id.b02);
        b10 = (Button) findViewById(R.id.b10);
        b11 = (Button) findViewById(R.id.b11);
        b12 = (Button) findViewById(R.id.b12);
        b20 = (Button) findViewById(R.id.b20);
        b21 = (Button) findViewById(R.id.b21);
        b22 = (Button) findViewById(R.id.b22);
        br = (Button) findViewById(R.id.restart);
        tv=(TextView)findViewById(R.id.textView);
        b00.setOnClickListener(oclBtn);
        b01.setOnClickListener(oclBtn);
        b02.setOnClickListener(oclBtn);
        b10.setOnClickListener(oclBtn);
        b11.setOnClickListener(oclBtn);
        b12.setOnClickListener(oclBtn);
        b20.setOnClickListener(oclBtn);
        b21.setOnClickListener(oclBtn);
        b22.setOnClickListener(oclBtn);
        br.setOnClickListener(oclBtn);
        grid = new GameGrid();
        logic = new GameLogic(grid);


    }

    public void update(int x, int y){
        //обновлять состояние ячейки X ili Y
        //и рисовать
        logic.press(x,y);
        tv.setText(grid.getMessage());

        draw();

    }

    public void restart(){
        //назначать ход Х
        //заного заполнить массив Е
        //нарисовать пустой
        logic.reset();
        draw();
        tv.setText(grid.getMessage());
    }

    public void draw(){
        drawButton(b00, 0, 0);
        drawButton(b01, 0, 1);
        drawButton(b02, 0, 2);
        drawButton(b10, 1, 0);
        drawButton(b11, 1, 1);
        drawButton(b12, 1, 2);
        drawButton(b20, 2,0);
        drawButton(b21, 2,1);
        drawButton(b22, 2,2);
    }

    private void drawButton(Button b, int x, int y) {
        //если в массиве Е, то сетТекст " "
        //иначе напиши Х или У
        if(grid.getContent(x,y)=='e'){
            b.setText(" ");
        }
        else{
            b.setText(String.valueOf(grid.getContent(x,y)));
        }

    }


}
