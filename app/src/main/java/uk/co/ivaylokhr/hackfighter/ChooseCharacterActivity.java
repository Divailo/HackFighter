package uk.co.ivaylokhr.hackfighter;

import android.app.FragmentTransaction;
import android.graphics.Point;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class ChooseCharacterActivity extends AppCompatActivity implements OnMapReadyCallback {
    MapFragment mapFragment;
    LinearLayout mainLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_hero);

        mapFragment = (MapFragment) getFragmentManager()
                .findFragmentById(R.id.mapFragment);
        mapFragment.getMapAsync(this);


    }

    private void setFragmentWidth(){
        mainLayout = (LinearLayout) findViewById(R.id.mainLayout);
        ViewGroup.LayoutParams mapParams = mapFragment.getView().getLayoutParams();
        Point size = new Point();
        Display display = getWindowManager().getDefaultDisplay();
        display.getSize(size);
        int screenWidth = size.x;
        mapParams.height = screenWidth;
    }

    @Override
    public void onMapReady(GoogleMap mapFragment) {
        mapFragment.addMarker(new MarkerOptions()
                .position(new LatLng(0, 0))
                .title("Marker"));
    }
}
