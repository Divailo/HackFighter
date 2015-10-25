package uk.co.ivaylokhr.hackfighter;
 
import android.annotation.TargetApi;
import android.app.ActionBar;
import android.app.FragmentTransaction;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.Point;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.GradientDrawable;
import android.media.Image;
import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;

public class ChooseCharacterActivity extends AppCompatActivity  implements TextView.OnClickListener {
 
    private LinearLayout mainLayout;
    private FrameLayout heroLayout;
    private ImageView portrait;
    private GridLayout grid;
    private ArrayList<CharTextView> characters;
 
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        characters = new ArrayList<CharTextView>();
        mainLayout = new LinearLayout(this);
        setContentView(mainLayout);
        mainLayout.setOrientation(LinearLayout.VERTICAL);
        mainLayout.setId(442);
        grid = new GridLayout(this);
        GridLayout.LayoutParams gridParams = new GridLayout.LayoutParams(GridLayout.spec(3), GridLayout.spec(7));
        grid.setId(444);
        int counter = 0;
        for(int i = 0; i < 7; ++i){
            for(int j = 0; j < 2; ++j){
                CharTextView iv = new CharTextView(this);
                Bitmap joeAvatar = BitmapFactory.decodeResource(getResources(), R.drawable.joe);
                Character joe = new Character(joeAvatar, "Joe Nash", 24, "United Kingdom");
                iv.setCharacterCell(joe);
                iv.setId(50 + counter);
                GridLayout.LayoutParams buttonparams = new GridLayout.LayoutParams(GridLayout.spec(j), GridLayout.spec(i));
                buttonparams.height = 200;
                buttonparams.width = 150;
                iv.setOnClickListener(this);
                grid.addView(iv, buttonparams);
                characters.add(iv);
                counter++;
            }
        }

        heroLayout = new FrameLayout(this);
        heroLayout.setId(443);
        FrameLayout.LayoutParams frameParams = new FrameLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        frameParams.height = 600;
        ImageView portrait = new ImageView(this);
        portrait.setImageBitmap( BitmapFactory.decodeResource(getResources(), R.drawable.joenash));
        heroLayout.addView(portrait);

        Button fightButton = new Button(this);
        fightButton.setText(R.string.fight);
        ViewGroup.LayoutParams buttonParams = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        buttonParams.height = 150;
        buttonParams.width = 650;

        mainLayout.addView(heroLayout, frameParams);
        mainLayout.addView(grid, gridParams);
        mainLayout.addView(fightButton, buttonParams);
        //znameto
//        heroLayout.setBackground();
        //String variable = "variable"
        //int Button = getResources().getIdentifier(variable, "drawable", getPackageName());
    }

    @Override
    public void onClick(View v) {
        for(int i = 0; i< characters.size(); ++i){
            characters.get(i).setClicked(true);
            characters.get(i).changeBorder();
        }
        ((CharTextView) v).setClicked(false);
        ((CharTextView) v).changeBorder();
    }

//    private void findViews(){
//        mainLayout = (LinearLayout) findViewById(R.id.mainLayout);
//        heroLayout = (FrameLayout) findViewById(R.id.heroLayout);
//        portrait = (ImageView) findViewById(R.id.portrait);
//        grid = (GridLayout) findViewById(R.id.gridLayout);
//        int counter = 0;
//        for(int i = 0; i < 8; ++i){
//            for(int j = 0; j < 2; ++j){
//                Log.i("PLSPLSPSLSP", Integer.toString(grid.getId()));
//                ImageView iv = new ImageView(this);
//                iv.setId(50+counter);
//                ViewGroup.LayoutParams imageParams = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
//                GradientDrawable gradientDrawable = new GradientDrawable();
//                gradientDrawable.setColor(0xFF00FF00); // Changes this drawbale to use a single color instead of a gradient
//                gradientDrawable.setCornerRadius(5);
//                gradientDrawable.setStroke(1, 0xFF000000);
//                iv.setLayoutParams(imageParams);
//                iv.setBackground(gradientDrawable);
//                grid.addView(iv);
//                counter++;
//            }
//        }
//    }

//    private void fillTheGrid(){
//        int counter = 0;
//        for(int i = 0; i < 8; ++i){
//            for(int j = 0; j < 8; ++j){
//                ImageView iv = new ImageView(this);
//                iv.setId(50+counter);
//                ViewGroup.LayoutParams imageParams = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
//                GradientDrawable gradientDrawable = new GradientDrawable();
//                gradientDrawable.setColor(0xFF00FF00); // Changes this drawbale to use a single color instead of a gradient
//                gradientDrawable.setCornerRadius(5);
//                gradientDrawable.setStroke(1, 0xFF000000);
//                iv.setBackground(gradientDrawable);
//                grid.addView(iv, i, j);
//                counter++;
//            }
//        }
//    }
}