package rmutr.boonsathain.wanwisa.checkfishingboat;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SimpleAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class add_boat_select extends AppCompatActivity {
    MyAlert myAlert = new MyAlert();
    private String userIdString, statusString, boat_id;

    private EditText data2EditText, data3EditText, data4EditText,
            data5EditText, data6EditText, data7EditText, data8EditText,
            data9EditText, data10EditText, data11EditText, data12EditText,
            data13EditText, data14EditText, data15EditText;
    private String data1String, data2String, data3String, data4String, data5String,
            data6String, data7String, data8String, data9String, data10String, data11String,
            data12String, data13String, data14String, data15String;
    private Button backButton;
    private Spinner spinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_boat_select);

        userIdString = getIntent().getStringExtra("user_id");
        statusString = getIntent().getStringExtra("status");
        boat_id = getIntent().getStringExtra("boat_id");

        bindWidget();
        getSpinerData();
        getBoatData();
    }

    private void getBoatData() {
        String url = MyConnection.url + "boat_add_view_select.php";

        List<NameValuePair> params = new ArrayList<>();
        params.add(new BasicNameValuePair("search", "y2"));
        params.add(new BasicNameValuePair("boat_id", boat_id));
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
            data1String = c.getString("data1");
            data2String = c.getString("data2");
            data3String = c.getString("data3");
            data4String = c.getString("data4");
            data5String = c.getString("data5");
            data6String = c.getString("data6");
            data7String = c.getString("data7");
            data8String = c.getString("data8");
            data9String = c.getString("data9");
            data10String = c.getString("data10");
            data11String = c.getString("data11");
            data12String = c.getString("data12");
            data13String = c.getString("data13");
            data14String = c.getString("data14");
            data15String = c.getString("data15");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        if (strStatusID.equals("0")) {
            myAlert.myDialog(this, strTitle, strMessage);
        } else {
            data2EditText.setText(data1String);
            data3EditText.setText(data2String);
            data4EditText.setText(data3String);
            data5EditText.setText(data4String);
            data6EditText.setText(data5String);
            data7EditText.setText(data6String);
            data8EditText.setText(data7String);
            data9EditText.setText(data8String);
            data10EditText.setText(data9String);
            data11EditText.setText(data10String);
            data12EditText.setText(data11String);
            data13EditText.setText(data12String);
            data14EditText.setText(data13String);
            data15EditText.setText(data14String);
        }

    }

    private void bindWidget() {

        data2EditText = (EditText) findViewById(R.id.editText37);
        data2EditText.setNextFocusDownId(R.id.editText38);

        data3EditText = (EditText) findViewById(R.id.editText38);
        data3EditText.setNextFocusDownId(R.id.editText46);

        data4EditText = (EditText) findViewById(R.id.editText46);
        data4EditText.setNextFocusDownId(R.id.editText47);

        data5EditText = (EditText) findViewById(R.id.editText47);
        data5EditText.setNextFocusDownId(R.id.editText48);

        data6EditText = (EditText) findViewById(R.id.editText48);
        data6EditText.setNextFocusDownId(R.id.editText49);

        data7EditText = (EditText) findViewById(R.id.editText49);
        data7EditText.setNextFocusDownId(R.id.editText50);

        data8EditText = (EditText) findViewById(R.id.editText50);
        data8EditText.setNextFocusDownId(R.id.editText51);

        data9EditText = (EditText) findViewById(R.id.editText51);
        data9EditText.setNextFocusDownId(R.id.editText52);

        data10EditText = (EditText) findViewById(R.id.editText52);
        data10EditText.setNextFocusDownId(R.id.editText53);

        data11EditText = (EditText) findViewById(R.id.editText53);
        data11EditText.setNextFocusDownId(R.id.editText54);

        data12EditText = (EditText) findViewById(R.id.editText54);
        data12EditText.setNextFocusDownId(R.id.editText55);

        data13EditText = (EditText) findViewById(R.id.editText55);
        data13EditText.setNextFocusDownId(R.id.editText56);

        data14EditText = (EditText) findViewById(R.id.editText56);
        data14EditText.setNextFocusDownId(R.id.editText57);

        data15EditText = (EditText) findViewById(R.id.editText57);

        spinner = (Spinner) findViewById(R.id.spinner2);

        backButton = (Button) findViewById(R.id.button12);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplication(), add_boat_view.class);
                intent.putExtra("user_id", userIdString);
                intent.putExtra("status", statusString);
                startActivity(intent);
            }
        });

    }   // bindWidget

    public void clickSaveSelectBoat(View view) {

        data1String = data2EditText.getText().toString().trim();
        data2String = data3EditText.getText().toString().trim();
        data3String = data4EditText.getText().toString().trim();
        data4String = data5EditText.getText().toString().trim();
        data5String = data6EditText.getText().toString().trim();
        data6String = data7EditText.getText().toString().trim();
        data7String = data8EditText.getText().toString().trim();
        data8String = data9EditText.getText().toString().trim();
        data9String = data10EditText.getText().toString().trim();
        data10String = data11EditText.getText().toString().trim();
        data11String = data12EditText.getText().toString().trim();
        data12String = data13EditText.getText().toString().trim();
        data13String = data14EditText.getText().toString().trim();
        data14String = data15EditText.getText().toString().trim();

        //Check Space
        if (checkSpace()) {
            //Have Space
            MyAlert myAlert = new MyAlert();
            myAlert.myDialog(this, "มีช่องว่าง", "กรุณากรอกให้ครบ ทุกช่องคะ");
        } else {
            //No Space
            updateDataToServer();

        }

    }   // clickSave

    private void updateDataToServer() {
        MyAlert myAlert = new MyAlert();
        String url = MyConnection.url + "boat_selected_edit.php";

        List<NameValuePair> params = new ArrayList<>();
        params.add(new BasicNameValuePair("status", "y"));
        params.add(new BasicNameValuePair("boat_id", boat_id));
        params.add(new BasicNameValuePair("data1", data1String));
        params.add(new BasicNameValuePair("data2", data2String));
        params.add(new BasicNameValuePair("data3", data3String));
        params.add(new BasicNameValuePair("data4", data4String));
        params.add(new BasicNameValuePair("data5", data5String));
        params.add(new BasicNameValuePair("data6", data6String));
        params.add(new BasicNameValuePair("data7", data7String));
        params.add(new BasicNameValuePair("data8", data8String));
        params.add(new BasicNameValuePair("data9", data9String));
        params.add(new BasicNameValuePair("data10", data10String));
        params.add(new BasicNameValuePair("data11", data11String));
        params.add(new BasicNameValuePair("data12", data12String));
        params.add(new BasicNameValuePair("data13", data13String));
        params.add(new BasicNameValuePair("data14", data14String));
        params.add(new BasicNameValuePair("data15", data15String));
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
        } else {
            Toast.makeText(add_boat_select.this, strMessage, Toast.LENGTH_SHORT).show();
/*
            Intent intent = new Intent(getApplication(), add_boat_view.class);
            startActivity(intent);
*/        }

    }
    // updateToServer

    private void getSpinerData() {
        String url = MyConnection.url + "boat_add_view_select.php";

        List<NameValuePair> params = new ArrayList<>();
        params.add(new BasicNameValuePair("search", "y1"));
        params.add(new BasicNameValuePair("boat_id", boat_id));
        try {

            JSONArray data = new JSONArray(MyConnection.getHttpPost(url, params));

            final ArrayList<HashMap<String, String>> MyArrList = new ArrayList<HashMap<String, String>>();
            HashMap<String, String> map;
            String data15 = "data15";

            for (int i = 0; i < data.length(); i++) {
                JSONObject c = data.getJSONObject(i);

                map = new HashMap<String, String>();
                map.put(data15, c.getString(data15));
                MyArrList.add(map);

            }
            SimpleAdapter sAdap;
            sAdap = new SimpleAdapter(add_boat_select.this, MyArrList, R.layout.spiner_add_boat_select_adap,
                    new String[]{data15}, new int[]{R.id.textView74});
            spinner.setAdapter(sAdap);

            data2EditText.setText(data15String);

        } catch (JSONException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    // getData

    private boolean checkSpace() {

        boolean bolStatus = true;

        bolStatus = data1String.equals("") ||
                data2String.equals("") ||
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
                data15String.equals("");

        return bolStatus;
    }

    public void clickEditSelectBoat(View view) {
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
    }

}