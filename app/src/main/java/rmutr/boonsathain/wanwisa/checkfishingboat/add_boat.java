package rmutr.boonsathain.wanwisa.checkfishingboat;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class add_boat extends AppCompatActivity {

    //Explicit

    private String userIdString, statusString;

    private EditText data2EditText, data3EditText, data4EditText,
            data5EditText, data6EditText, data7EditText, data8EditText,
            data9EditText, data10EditText, data11EditText, data12EditText,
            data13EditText, data14EditText, data15EditText;
    private String data1String, data2String, data3String, data4String, data5String,
            data6String, data7String, data8String, data9String, data10String, data11String,
            data12String, data13String, data14String, data15String;
    private Spinner spinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_boat);

        userIdString = getIntent().getStringExtra("user_id");
        statusString = getIntent().getStringExtra("status");

        //Bind Widget
        bindWidget();

        //Create Spinner
        createSpinner();

    }   // Main Method

    private void createSpinner() {

        final String[] typeBoatStrings = getResources().getStringArray(R.array.typeboat);
        ArrayAdapter<String> stringArrayAdapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, typeBoatStrings);
        spinner.setAdapter(stringArrayAdapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                data15String = typeBoatStrings[i];
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                data15String = typeBoatStrings[0];
            }
        });

    }   // createSpinner

    private void bindWidget() {

        data2EditText = (EditText) findViewById(R.id.editText3);
        data2EditText.setNextFocusDownId(R.id.editText4);

        data3EditText = (EditText) findViewById(R.id.editText4);
        data3EditText.setNextFocusDownId(R.id.editText5);

        data4EditText = (EditText) findViewById(R.id.editText5);
        data4EditText.setNextFocusDownId(R.id.editText6);

        data5EditText = (EditText) findViewById(R.id.editText6);
        data5EditText.setNextFocusDownId(R.id.editText7);

        data6EditText = (EditText) findViewById(R.id.editText7);
        data6EditText.setNextFocusDownId(R.id.editText8);

        data7EditText = (EditText) findViewById(R.id.editText8);
        data7EditText.setNextFocusDownId(R.id.editText9);

        data8EditText = (EditText) findViewById(R.id.editText9);
        data8EditText.setNextFocusDownId(R.id.editText10);

        data9EditText = (EditText) findViewById(R.id.editText10);
        data9EditText.setNextFocusDownId(R.id.editText11);

        data10EditText = (EditText) findViewById(R.id.editText11);
        data10EditText.setNextFocusDownId(R.id.editText12);

        data11EditText = (EditText) findViewById(R.id.editText12);
        data11EditText.setNextFocusDownId(R.id.editText13);

        data12EditText = (EditText) findViewById(R.id.editText13);
        data12EditText.setNextFocusDownId(R.id.editText14);

        data13EditText = (EditText) findViewById(R.id.editText14);
        data13EditText.setNextFocusDownId(R.id.editText15);

        data14EditText = (EditText) findViewById(R.id.editText15);
        data14EditText.setNextFocusDownId(R.id.editText16);

        data15EditText = (EditText) findViewById(R.id.editText16);
        spinner = (Spinner) findViewById(R.id.spinner);

    }   // bindWidget

    public void clickSaveAddBoat(View view) {

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
        String url = MyConnection.url + "add_boat.php";

        List<NameValuePair> params = new ArrayList<>();
        params.add(new BasicNameValuePair("status", "y"));

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
        } else if (strStatusID.equals("1")) {
            Toast.makeText(add_boat.this, strMessage, Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(getApplication(), hub_service.class);
            intent.putExtra("user_id", userIdString);
            intent.putExtra("status", statusString);
            startActivity(intent);
            finish();
        }
    }
    // updateToServer

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

    public void clickEditAddBoat(View view) {
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

    public void clickVIEWAddBoat(View view) {
        Intent intent = new Intent(getApplication(), add_boat_view.class);
        intent.putExtra("user_id", userIdString);
        intent.putExtra("status", statusString);
        startActivity(intent);
    }

}   // Main Class