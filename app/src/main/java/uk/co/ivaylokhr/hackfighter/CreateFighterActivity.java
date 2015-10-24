package uk.co.ivaylokhr.hackfighter;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.InputFilter;
import android.text.method.KeyListener;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

import java.io.ByteArrayOutputStream;

public class CreateFighterActivity extends AppCompatActivity {

    private static int RESULT_LOAD_IMG = 1;
    String imgDecodableString;
    SharedPreferences prefs;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_fighter);
        Spinner spinner = (Spinner) findViewById(R.id.spinnerCountry);
        ArrayAdapter<CharSequence> adapter  = ArrayAdapter.createFromResource(this,R.array.countries,android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        prefs  = this.getSharedPreferences("uk.co.ivaylokhr.hackfighter", Context.MODE_PRIVATE);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_create_fighter, menu);
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

    public void loadImagefromGallery(View view) {
        // Create intent to Open Image applications like Gallery, Google Photos
        Intent galleryIntent = new Intent(Intent.ACTION_PICK,
                android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        // Start the Intent
        startActivityForResult(galleryIntent, RESULT_LOAD_IMG);
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        try {
            // When an Image is picked
            if (requestCode == RESULT_LOAD_IMG && resultCode == RESULT_OK
                    && null != data) {
                // Get the Image from data

                Uri selectedImage = data.getData();
                String[] filePathColumn = { MediaStore.Images.Media.DATA };

                // Get the cursor
                Cursor cursor = getContentResolver().query(selectedImage,
                        filePathColumn, null, null, null);
                // Move to first row
                cursor.moveToFirst();

                int columnIndex = cursor.getColumnIndex(filePathColumn[0]);
                imgDecodableString = cursor.getString(columnIndex);
                cursor.close();
                ImageView imgView = (ImageView) findViewById(R.id.imgView);
                // Set the Image in ImageView after decoding the String
                imgView.setImageBitmap(BitmapFactory
                        .decodeFile(imgDecodableString));

            } else {
                Toast.makeText(this, "You haven't picked Image",
                        Toast.LENGTH_LONG).show();
            }
        } catch (Exception e) {
            Toast.makeText(this, "Something went wrong", Toast.LENGTH_LONG)
                    .show();
        }

    }

    public void nextActivity(View v){
        Intent intent = new Intent(CreateFighterActivity.this,ChooseHeroActivity.class);

        Bitmap bmp =  ((BitmapDrawable)((ImageView) findViewById(R.id.imgView)).getDrawable()).getBitmap();

//        prefs.edit().putString("FIGHTER_NAME", String.valueOf(((EditText) findViewById(R.id.editTextName)).getText()));
//        prefs.edit().putString("FIGHTER_DAY", String.valueOf(((EditText) findViewById(R.id.editText)).getText()));
//        prefs.edit().putString("FIGHTER_MONTH", String.valueOf(((EditText) findViewById(R.id.editText2)).getText()));
//        prefs.edit().putString("FIGHTER_YEAR", String.valueOf(((EditText) findViewById(R.id.editText3)).getText()));
//        prefs.edit().putString("FIGHTER_COUNTRY",((Spinner)findViewById(R.id.spinnerCountry)).getSelectedItem().toString());
        intent.putExtra("FIGHTER_AVATAR",bmp);
        intent.putExtra("FIGHTER_NAME", ((EditText) findViewById(R.id.editTextName)).getText());
        intent.putExtra("FIGHTER_DAY", ((EditText) findViewById(R.id.editText)).getText());
        intent.putExtra("FIGHTER_MONTH",((EditText) findViewById(R.id.editText2)).getText());
        intent.putExtra("FIGHTER_YEAR",((EditText) findViewById(R.id.editText3)).getText());
        intent.putExtra("FIGHTER_COUNTRY",((Spinner)findViewById(R.id.spinnerCountry)).getSelectedItem().toString());

        startActivity(intent);




    }








}
