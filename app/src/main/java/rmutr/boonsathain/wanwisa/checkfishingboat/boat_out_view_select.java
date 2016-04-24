package rmutr.boonsathain.wanwisa.checkfishingboat;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class boat_out_view_select extends AppCompatActivity {
    MyAlert myAlert = new MyAlert();
    private String userIdString, statusString, boat_id;

    private EditText data2EditText, data3EditText, data4EditText,
            data5EditText, data6EditText, data7EditText, data8EditText,
            data9EditText, data10EditText, data11EditText, data12EditText,
            data13EditText, data14EditText, data15EditText, data16EditText, data17EditText;
    private Button backButton;

    private String data1String, data2String, data3String, data4String, data5String, data6String,
            data7String, data8String, data9String, data10String, data11String, data12String,
            data13String, data14String, data15String, data16String;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_boat_out_view_select);

        userIdString = getIntent().getStringExtra("user_id");
        statusString = getIntent().getStringExtra("status");
        boat_id = getIntent().getStringExtra("boat_id");
        bindWidget();
        getBoatData();
    }

    private void getBoatData() {
        String url = MyConnection.url + "boat_out_view_select.php";

        List<NameValuePair> params = new ArrayList<>();
        params.add(new BasicNameValuePair("search", "y"));
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
            data16String = c.getString("data16");
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
            data12EditText.setText(data12String);
            data13EditText.setText(data12String);
            data14EditText.setText(data13String);
            data15EditText.setText(data14String);
            data16EditText.setText(data15String);
            data17EditText.setText(data16String);
        }

    }

    private void bindWidget() {

        data2EditText = (EditText) findViewById(R.id.editText69);
        data2EditText.setNextFocusDownId(R.id.editText70);

        data3EditText = (EditText) findViewById(R.id.editText70);
        data3EditText.setNextFocusDownId(R.id.editText71);

        data4EditText = (EditText) findViewById(R.id.editText71);
        data4EditText.setNextFocusDownId(R.id.editText72);

        data5EditText = (EditText) findViewById(R.id.editText72);
        data5EditText.setNextFocusDownId(R.id.editText73);

        data6EditText = (EditText) findViewById(R.id.editText73);
        data6EditText.setNextFocusDownId(R.id.editText74);

        data7EditText = (EditText) findViewById(R.id.editText74);
        data7EditText.setNextFocusDownId(R.id.editText75);

        data8EditText = (EditText) findViewById(R.id.editText75);
        data8EditText.setNextFocusDownId(R.id.editText76);

        data9EditText = (EditText) findViewById(R.id.editText76);
        data9EditText.setNextFocusDownId(R.id.editText77);

        data10EditText = (EditText) findViewById(R.id.editText77);
        data10EditText.setNextFocusDownId(R.id.editText78);

        data11EditText = (EditText) findViewById(R.id.editText78);
        data11EditText.setNextFocusDownId(R.id.editText79);

        data12EditText = (EditText) findViewById(R.id.editText79);
        data12EditText.setNextFocusDownId(R.id.editText80);

        data13EditText = (EditText) findViewById(R.id.editText80);
        data13EditText.setNextFocusDownId(R.id.editText81);

        data14EditText = (EditText) findViewById(R.id.editText81);
        data14EditText.setNextFocusDownId(R.id.editText82);

        data15EditText = (EditText) findViewById(R.id.editText82);
        data15EditText.setNextFocusDownId(R.id.editText83);

        data16EditText = (EditText) findViewById(R.id.editText83);
        data16EditText.setNextFocusDownId(R.id.editText84);

        data17EditText = (EditText) findViewById(R.id.editText84);
        backButton = (Button) findViewById(R.id.button17);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplication(), boat_out_view.class);
                intent.putExtra("user_id", userIdString);
                intent.putExtra("status", statusString);
                startActivity(intent);
            }
        });
    }

}
