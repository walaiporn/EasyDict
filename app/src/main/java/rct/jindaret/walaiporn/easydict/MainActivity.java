package rct.jindaret.walaiporn.easydict;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText editText;
    String searchString;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = (EditText) findViewById(R.id.editText);

    }

    public void clickSearch(View view) {

        searchString = editText.getText().toString().trim();

        if (searchString.equals("")) {
            //Have Space
            MyAlert myAlert = new MyAlert(MainActivity.this, "มีช่องว่าง", "กรุณากรอกทุกช่อง");
            myAlert.myDialog();
        } else {
            // No Space

            try {

                SynWord synWord = new SynWord(MainActivity.this);
                synWord.execute();
                String s = synWord.get();

                Log.d("5decV1", "JSON ==> " + s);

            } catch (Exception e) {
                Log.d("5devV1", "e search ==>" + e.toString());
            }




        }   // if

    }   // clickSearch

}   // Main Class
