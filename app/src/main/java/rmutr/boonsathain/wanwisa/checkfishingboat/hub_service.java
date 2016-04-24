package rmutr.boonsathain.wanwisa.checkfishingboat;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class hub_service extends AppCompatActivity {
    //Explicit
    private ImageView hub4ImageView;
    private TextView hub4TextView, showNameTextView;
    private String userIdString,nameString, surnameString, statusString;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hub_service);

        //Bind Widget
        hub4ImageView = (ImageView) findViewById(R.id.imageView5);
        hub4TextView = (TextView) findViewById(R.id.textView8);
        showNameTextView = (TextView) findViewById(R.id.textView4);

        //Show View
        userIdString = getIntent().getStringExtra("user_id");
        nameString = getIntent().getStringExtra("firstname");
        surnameString = getIntent().getStringExtra("lastname");
        showNameTextView.setText(nameString + " " + surnameString);
        statusString = getIntent().getStringExtra("status");

        //Check Status
        checkStatus();



    }   // Main Method

    public void clickBoatCheck(View view) {
        Intent intent = new Intent(getApplication(), boat_check.class);
        intent.putExtra("user_id", userIdString);
        intent.putExtra("status", statusString);
        startActivity(intent);
    }
    public void clickBoatIn(View view) {
        Intent intent = new Intent(getApplication(), boat_in.class);
        intent.putExtra("user_id", userIdString);
        intent.putExtra("status", statusString);
        startActivity(intent);
    }
    public void clickBoatOut(View view) {
        Intent intent = new Intent(getApplication(), boat_out.class);
        intent.putExtra("user_id", userIdString);
        intent.putExtra("status", statusString);
        startActivity(intent);
    }

    public void clickAddBoat(View view) {
        Intent intent = new Intent(getApplication(), add_boat.class);
        intent.putExtra("user_id", userIdString);
        intent.putExtra("status", statusString);
        startActivity(intent);
    }

    private void checkStatus() {
        if (statusString.equals("0")) {

            hub4ImageView.setVisibility(View.INVISIBLE);
            hub4TextView.setVisibility(View.INVISIBLE);

        }   // if

    }   // checkStatus


}   // Main Class
