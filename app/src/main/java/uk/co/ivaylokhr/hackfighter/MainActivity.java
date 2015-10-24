package uk.co.ivaylokhr.hackfighter;

import android.app.ActionBar;
import android.content.Intent;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.GridLayout;

public class MainActivity extends AppCompatActivity {
    Button newGame;
    Button quitGame;
    Button cheatCodes;
    GridLayout gl;
    MediaPlayer mp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        gl = new GridLayout(this);
        setContentView(gl);
        gl.setRowCount(3);
        gl.setColumnCount(5);
        gl.setBackgroundResource(R.drawable.roskataivo);

        GridLayout.Spec rowSpecCheat = GridLayout.spec(2);
        GridLayout.Spec colsSpecCheat = GridLayout.spec(2);
        GridLayout.LayoutParams paramsCheat = new GridLayout.LayoutParams(rowSpecCheat, colsSpecCheat);
        paramsCheat.width=300;
        paramsCheat.height=130;
        paramsCheat.setMargins(20,5,32,70);

        GridLayout.Spec rowSpecNew = GridLayout.spec(2);
        GridLayout.Spec colsSpecNew = GridLayout.spec(3);
        GridLayout.LayoutParams paramsNew = new GridLayout.LayoutParams(rowSpecNew, colsSpecNew);
        paramsNew.width=300;
        paramsNew.height=130;
        paramsNew.setMargins(32,90,12,0);

        GridLayout.Spec rowSpecQuit = GridLayout.spec(2);
        GridLayout.Spec colsSpecQuit = GridLayout.spec(4);
        GridLayout.LayoutParams paramsQuit = new GridLayout.LayoutParams(rowSpecQuit, colsSpecQuit);
        paramsQuit.width=300;
        paramsQuit.height=130;
        paramsQuit.setMargins(10,10,10,10);

        mp = MediaPlayer.create(this, R.raw.epicsaxguy);

        newGame = new Button(this);
        newGame.setBackgroundColor(Color.GREEN);
        newGame.setText("New game");
        newGame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                stopMusic(v);
                changeActivity(v);
            }
        });

        cheatCodes = new Button(this);
        cheatCodes.setText("Cheat codes");
        cheatCodes.setBackgroundColor(Color.WHITE);
        cheatCodes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mp.isPlaying()){
                    stopMusic(v);
                }
                else {
                    playMusic(v);
                }
            }
        });

        quitGame = new Button(this);
        quitGame.setBackgroundColor(Color.RED);
        quitGame.setText("Quit");
        quitGame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                stopMusic(v);
                finish();
            }
        });

        gl.addView(newGame, paramsNew);
        gl.addView(cheatCodes, paramsCheat);
        gl.addView(quitGame, paramsQuit);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void changeActivity(View view){
        Intent intent = new Intent(MainActivity.this, CreateFighterActivity.class);
        startActivity(intent);
    }

    public void playMusic(View view){
        mp.start();
    }

    public void stopMusic(View view){
        mp.stop();
    }
}
