package uk.co.ivaylokhr.hackfighter;

import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.view.View;
import android.widget.TextView;

import org.w3c.dom.Text;

/**
 * Created by Ivaylo on 25/10/2015.
 */
public class CharTextView extends TextView {

    private boolean clicked;
    private Character hero;

    public CharTextView(Context context) {
        super(context);
        clicked = false;
    }

    public void setCharacterCell(Character hero){
        this.hero = hero;
        BitmapDrawable avatar = new BitmapDrawable(getResources(), hero.getAvatar());
        this.setBackground(avatar);
    }

    public boolean isClicked(){
        return clicked;
    }

    public void setClicked(boolean b){
        clicked = b;
    }

    public void changeBorder() {
        if(!clicked){
            //trqbwa method za bordered kartinka
            this.setBackgroundResource(R.drawable.joebordered);
            clicked = true;
        }
        else{
            setCharacterCell(hero);
            clicked = false;
        }
    }
}
