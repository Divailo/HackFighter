package uk.co.ivaylokhr.hackfighter;

import android.app.FragmentTransaction;
import android.graphics.Point;
import android.media.Image;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class ChooseCharacterActivity extends AppCompatActivity {

    private LinearLayout mainLayout;
    private FrameLayout heroLayout;
    private ImageView portrait;
    private GridLayout grid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_hero);
        findViews();
        //znameto
//        heroLayout.setBackground();
        //String variable = "variable"
        //int Button = getResources().getIdentifier(variable, "drawable", getPackageName());
    }

    private void findViews(){
        mainLayout = (LinearLayout) findViewById(R.id.mainLayout);
        heroLayout = (FrameLayout) findViewById(R.id.heroLayout);
        portrait = (ImageView) findViewById(R.id.portrait);
        grid = (GridLayout) findViewById(R.id.gridLayout);
    }

    private void fillTheGrid(){
        int counter = 0;
        for(int i = 0; i < 8; ++i){
            for(int j = 0; j < 8; ++j){
                ImageView iv = new ImageView(this);
                iv.setId(50+ counter);
                ViewGroup.LayoutParams imageParams = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
                grid.addView(iv, i, j);
                counter++;
            }
        }
    }
}
