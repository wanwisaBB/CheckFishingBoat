package rmutr.boonsathain.wanwisa.checkfishingboat;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class boat_out extends AppCompatActivity {
    //Explicit

    private String userIdString, statusString;

    private EditText data2EditText, data3EditText, data4EditText,
            data5EditText, data6EditText, data7EditText, data8EditText,
            data9EditText, data10EditText, data11EditText, data12EditText,
            data13EditText, data14EditText, data15EditText, data16EditText, data17EditText;

    private String data2String, data3String, data4String, data5String, data6String,
            data7String, data8String, data9String, data10String, data11String, data12String,
            data13String, data14String, data15String, data16String, data17String;

    @SuppressLint("NewApi")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_boat_out);

        userIdString = getIntent().getStringExtra("user_id");
        statusString = getIntent().getStringExtra("status");

        if (android.os.Build.VERSION.SDK_INT > 9) {
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);
        }

        //Bind Widget
        bindWidget();

    }   //Main Method

    private void bindWidget() {
        data2EditText = (EditText) findViewById(R.id.editText17);
        data2EditText.setNextFocusDownId(R.id.editText18);

        data3EditText = (EditText) findViewById(R.id.editText18);
        data3EditText.setNextFocusDownId(R.id.editText19);

        data4EditText = (EditText) findViewById(R.id.editText19);
        data4EditText.setNextFocusDownId(R.id.editText20);

        data5EditText = (EditText) findViewById(R.id.editText20);
        data5EditText.setNextFocusDownId(R.id.editText21);

        data6EditText = (EditText) findViewById(R.id.editText21);
        data6EditText.setNextFocusDownId(R.id.editText22);

        data7EditText = (EditText) findViewById(R.id.editText22);
        data7EditText.setNextFocusDownId(R.id.editText23);

        data8EditText = (EditText) findViewById(R.id.editText23);
        data8EditText.setNextFocusDownId(R.id.editText24);

        data9EditText = (EditText) findViewById(R.id.editText24);
        data9EditText.setNextFocusDownId(R.id.editText25);

        data10EditText = (EditText) findViewById(R.id.editText25);
        data10EditText.setNextFocusDownId(R.id.editText26);

        data11EditText = (EditText) findViewById(R.id.editText26);
        data11EditText.setNextFocusDownId(R.id.editText27);

        data12EditText = (EditText) findViewById(R.id.editText27);
        data12EditText.setNextFocusDownId(R.id.editText28);

        data13EditText = (EditText) findViewById(R.id.editText28);
        data13EditText.setNextFocusDownId(R.id.editText29);

        data14EditText = (EditText) findViewById(R.id.editText29);
        data14EditText.setNextFocusDownId(R.id.editText30);

        data15EditText = (EditText) findViewById(R.id.editText30);
        data15EditText.setNextFocusDownId(R.id.editText31);

        data16EditText = (EditText) findViewById(R.id.editText31);
        data16EditText.setNextFocusDownId(R.id.editText32);

        data17EditText = (EditText) findViewById(R.id.editText32);
    }

    public void clickSaveBoatOut(View view) {

        data2String = data2EditText.getText().toString().trim();
        data3String = data3EditText.getText().toString().trim();
        data4String = data4EditText.getText().toString().trim();
        data5String = data5EditText.getText().toString().trim();
        data6String = data6EditText.getText().toString().trim();
        data7String = data7EditText.getText().toString().trim();
        data8String = data8EditText.getText().toString().trim();
        data9String = data9EditText.getText().toString().trim();
        data10String = data10EditText.getText().toString().trim();
        data11String = data11EditText.getText().toString().trim();
        data12String = data12EditText.getText().toString().trim();
        data13String = data13EditText.getText().toString().trim();
        data14String = data14EditText.getText().toString().trim();
        data15String = data15EditText.getText().toString().trim();
        data16String = data16EditText.getText().toString().trim();
        data17String = data17EditText.getText().toString().trim();
        //Check Space
        if (checkSpace()) {
            //Have Space
            MyAlert myAlert = new MyAlert();
            myAlert.myDialog(this, "มีช่องว่าง", "กรุณากรอกให้ครบ ทุกช่องคะ");
        } else {
            //No Space
            updateDataToServer();

        }


    }   //Click Save

    public void boat_out_clear_text(View view){
        data2EditText.setText(null);
        data3EditText.setText(null);
        data4EditText.setText(null);
        data5EditText.setText(null);
        data6EditText.setText(null);
        data7EditText.setText(null);
        data8EditText.setText(null);
        data9EditText.setText(null);
        data10EditText.setText(null);
        data11EditText.setText(null);
        data12EditText.setText(null);
        data13EditText.setText(null);
        data14EditText.setText(null);
        data15EditText.setText(null);
        data16EditText.setText(null);
        data17EditText.setText(null);
    }   //clear_text

    public void boat_out_list(View view) {
        Intent intent = new Intent(getApplication(), boat_out_view.class);
        intent.putExtra("user_id", userIdString);
        intent.putExtra("status", statusString);
        startActivity(intent);
    }


    private void updateDataToServer() {
        MyAlert myAlert = new MyAlert();
        String url = MyConnection.url + "boat_out.php";

        List<NameValuePair> params = new ArrayList<>();
        params.add(new BasicNameValuePair("status", "y"));

        params.add(new BasicNameValuePair("data1", data2String));
        params.add(new BasicNameValuePair("data2", data3String));
        params.add(new BasicNameValuePair("data3", data4String));
        params.add(new BasicNameValuePair("data4", data5String));
        params.add(new BasicNameValuePair("data5", data6String));
        params.add(new BasicNameValuePair("data6", data7String));
        params.add(new BasicNameValuePair("data7", data8String));
        params.add(new BasicNameValuePair("data8", data9String));
        params.add(new BasicNameValuePair("data9", data10String));
        params.add(new BasicNameValuePair("data10", data11String));
        params.add(new BasicNameValuePair("data11", data12String));
        params.add(new BasicNameValuePair("data12", data13String));
        params.add(new BasicNameValuePair("data13", data14String));
        params.add(new BasicNameValuePair("data14", data15String));
        params.add(new BasicNameValuePair("data15", data16String));
        params.add(new BasicNameValuePair("data16", data17String));
        params.add(new BasicNameValuePair("user_id", userIdString));

        String resultServer = MyConnection.getHttpPost(url, params);
        String strStatusID = "0";
        String strTitle = "Unknow Status!";
        String strMessage = "Unknow Status!";

        JSONObject c;
        try {
            c = new JSONObject(resultServer);
            strStatusID = c.getString("StatusID");
            strTitle = c.getString("Title");
            strMessage = c.getString("Message");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        if (strStatusID.equals("0")) {
            myAlert.myDialog(this, strTitle, strMessage);
        } else if (strStatusID.equals("1")) {
            Toast.makeText(boat_out.this, strMessage, Toast.LENGTH_SHORT).show();
            /*
            Intent intent = new Intent(getApplication(), add_boat.class);
            intent.putExtra("status", strStatus);
            startActivity(intent);
            */
        }
    }   //updateToServer
    private boolean checkSpace() {

        boolean bolStatus = true;

        bolStatus = data2String.equals("") ||
                data3String.equals("") ||
                data4String.equals("") ||
                data5String.equals("") ||
                data6String.equals("") ||
                data7String.equals("") ||
                data8String.equals("") ||
                data9String.equals("") ||
                data10String.equals("") ||
                data11String.equals("") ||
                data12String.equals("") ||
                data13String.equals("") ||
                data14String.equals("") ||
                data15String.equals("") ||
                data16String.equals("") ||
                data17String.equals("");

        return bolStatus;
    }

}   // Main Class
