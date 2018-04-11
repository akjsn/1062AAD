package com.paperscissorsstonegame;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView mTxtComPlay, mTxtResult;
    private Button mBtnScissors, mBtnStone, mBtnPaper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTxtComPlay = (TextView)findViewById(R.id.txtComPlay);
        mTxtResult = (TextView)findViewById(R.id.txtResult);
        mBtnScissors = (Button)findViewById(R.id.btnScissors);
        mBtnStone = (Button)findViewById(R.id.btnStone);
        mBtnPaper = (Button)findViewById(R.id.btnPaper);

        mBtnScissors.setOnClickListener(btnScissorsOnClick);
        mBtnStone.setOnClickListener(btnStoneOnClick);
        mBtnPaper.setOnClickListener(btnPaperOnClick);
    }

    public int select()
    {
        double x= Math.random()*3;
        return (int) x + 1;
    }

    public int verdict(int x,int y)
    {
        if((x==1 && y==3)||(x==2 && y==1)||(x==3&&y==2)) return 100;
        else  if(x==y) return 50;
        else return 0;
    }

    public int sciplay(int iComPlay)
    {
        // 1 – 剪刀, 2 – 石頭, 3 – 布
        int score=verdict(1,iComPlay);
        if (score==50) {
            mTxtComPlay.setText(R.string.play_scissors);
            mTxtResult.setText(getString(R.string.result) +
                    getString(R.string.player_draw));
            return 50;
        }
        else if (score==0) {
            mTxtComPlay.setText(R.string.play_stone);
            mTxtResult.setText(getString(R.string.result) +
                    getString(R.string.player_lose));
            return 0;
        }
        else {
            mTxtComPlay.setText(R.string.play_paper);
            mTxtResult.setText(getString(R.string.result) +
                    getString(R.string.player_win));
            return 100;
        }
    }

    private View.OnClickListener btnScissorsOnClick = new View.OnClickListener() {
        public void onClick(View v) {
            // 決定電腦出拳.
            int iComPlay = select();
            sciplay(iComPlay);
        }
    };

    public int stoplay(int iComPlay)
    {
        // 1 – 剪刀, 2 – 石頭, 3 – 布.
        int score=verdict(2,iComPlay);
        if (score==100) {
            mTxtComPlay.setText(R.string.play_scissors);
            mTxtResult.setText(getString(R.string.result) +
                    getString(R.string.player_win));
            return 100;
        }
        else if (score==50) {
            mTxtComPlay.setText(R.string.play_stone);
            mTxtResult.setText(getString(R.string.result) +
                    getString(R.string.player_draw));
            return 50;
        }
        else {
            mTxtComPlay.setText(R.string.play_paper);
            mTxtResult.setText(getString(R.string.result) +
                    getString(R.string.player_lose));
            return 0;
        }
    }
    private View.OnClickListener btnStoneOnClick = new View.OnClickListener() {
        public void onClick(View v) {
            // 決定電腦出拳.
            int iComPlay = select();
            stoplay(iComPlay);
        }
    };

    public int papplay(int iComPlay)
    {
        // 1 – 剪刀, 2 – 石頭, 3 – 布.
        int score=verdict(3,iComPlay);
        if (score==0) {
            mTxtComPlay.setText(R.string.play_scissors);
            mTxtResult.setText(getString(R.string.result) +
                    getString(R.string.player_lose));
            return 0;
        }
        else if (score==100) {
            mTxtComPlay.setText(R.string.play_stone);
            mTxtResult.setText(getString(R.string.result) +
                    getString(R.string.player_win));
            return 100;
        }
        else {
            mTxtComPlay.setText(R.string.play_paper);
            mTxtResult.setText(getString(R.string.result) +
                    getString(R.string.player_draw));
            return 50;
        }
    }

    private View.OnClickListener btnPaperOnClick = new View.OnClickListener() {
        public void onClick(View v) {
            // 決定電腦出拳.
            int iComPlay = select();
            papplay(iComPlay);
        }
    };
}
