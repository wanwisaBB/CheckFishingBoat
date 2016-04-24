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

public class boat_in extends AppCompatActivity {

    private String userIdString, statusString;

    private EditText data1EditText, data2EditText, data3EditText, data4EditText, data5EditText, data6EditText, data7EditText, data8EditText, data9EditText, data10EditText;
    private String data1String, data2String, data3String, data4String, data5String, data6String, data7String, data8String, data9String, data10String;

    MyAlert myAlert = new MyAlert();

    @SuppressLint("NewApi")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_boat_in);

        userIdString = getIntent().getStringExtra("user_id");
        statusString = getIntent().getStringExtra("status");

        if (android.os.Build.VERSION.SDK_INT > 9) {
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);
        }
        widget();
    }

    private void widget() {
        data1EditText = (EditText) findViewById(R.id.editText34);
        data1EditText.setNextFocusDownId(R.id.editText35);

        data2EditText = (EditText) findViewById(R.id.editText35);
        data2EditText.setNextFocusDownId(R.id.editText36);

        data3EditText = (EditText) findViewById(R.id.editText36);
        data3EditText.setNextFocusDownId(R.id.editText39);

        data4EditText = (EditText) findViewById(R.id.editText39);
        data4EditText.setNextFocusDownId(R.id.editText40);

        data5EditText = (EditText) findViewById(R.id.editText40);
        data5EditText.setNextFocusDownId(R.id.editText41);

        data6EditText = (EditText) findViewById(R.id.editText41);
        data6EditText.setNextFocusDownId(R.id.editText42);

        data7EditText = (EditText) findViewById(R.id.editText42);
        data7EditText.setNextFocusDownId(R.id.editText43);

        data8EditText = (EditText) findViewById(R.id.editText43);
        data8EditText.setNextFocusDownId(R.id.editText44);

        data9EditText = (EditText) findViewById(R.id.editText44);
        data9EditText.setNextFocusDownId(R.id.editText45);

        data10EditText = (EditText) findViewById(R.id.editText45);
    }

    public void boatInClearText(View view) {

        data1EditText.setText(null);
        data2EditText.setText(null);
        data3EditText.setText(null);
        data4EditText.setText(null);
        data5EditText.setText(null);
        data6EditText.setText(null);
        data7EditText.setText(null);
        data8EditText.setText(null);
        data9EditText.setText(null);
        data10EditText.setText(null);

    }

    public void boatInView(View view) {
        boatInViewIntent();
    }

    private void boatInViewIntent() {

        Intent intent = new Intent(getApplication(), boat_in_view.class);
        intent.putExtra("user_id", userIdString);
        intent.putExtra("status", statusString);
        startActivity(intent);
    }

    public void boatInSave(View view) {
        data1String = data1EditText.getText().toString();
        data2String = data2EditText.getText().toString();
        data3String = data3EditText.getText().toString();
        data4String = data4EditText.getText().toString();
        data5String = data5EditText.getText().toString();
        data6String = data6EditText.getText().toString();
        data7String = data7EditText.getText().toString();
        data8String = data8EditText.getText().toString();
        data9String = data9EditText.getText().toString();
        data10String = data10EditText.getText().toString();

        String url = MyConnection.url + "boat_in.php";

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
            Toast.makeText(boat_in.this, strMessage, Toast.LENGTH_SHORT).show();
        }

    }
}