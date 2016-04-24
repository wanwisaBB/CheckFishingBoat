package rmutr.boonsathain.wanwisa.checkfishingboat;

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

public class MainActivity extends AppCompatActivity {

    private EditText usernameEditText, passwordEditText;
    private String usernameString, passwordString;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (android.os.Build.VERSION.SDK_INT > 9) {
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);
        }
        widget();
    }

    private void widget() {
        usernameEditText = (EditText) findViewById(R.id.editText);
        passwordEditText = (EditText) findViewById(R.id.editText2);
    }

    public void checkinput(View view) {
        usernameString = usernameEditText.getText().toString();
        passwordString = passwordEditText.getText().toString();

        if (usernameString.equals("") || passwordString.equals("")) {
            MyAlert myAlert = new MyAlert();
            myAlert.myDialog(this, "มีช่องว่าง", "กรุณากรอกข้อมูลให้ครบ");
        } else {
            checkLogin();
        }
    }

    private void checkLogin() {
        MyAlert myAlert = new MyAlert();
        String url = MyConnection.url + "user_login.php";

        List<NameValuePair> params = new ArrayList<>();
        params.add(new BasicNameValuePair("username", usernameString));
        params.add(new BasicNameValuePair("password", passwordString));

        String resultServer = MyConnection.getHttpPost(url, params);
        String strStatusID = "0";
        String strTitle = "Unknow Status!";
        String strMessage = "Unknow Status!";
        String strUserID = "0";
        String strFirstname = "0";
        String strLastname = "0";
        String strStatus = "0";

        JSONObject c;
        try {
            c = new JSONObject(resultServer);
            strStatusID = c.getString("StatusID");
            strTitle = c.getString("Title");
            strMessage = c.getString("Message");
            strUserID = c.getString("user_id");
            strFirstname = c.getString("firstname");
            strLastname = c.getString("surname");
            strStatus = c.getString("status");

        } catch (JSONException e) {
            e.printStackTrace();
        }
        if (strStatusID.equals("0")) {
            myAlert.myDialog(this, strTitle, strMessage);
        } else {
            Toast.makeText(MainActivity.this, strMessage, Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(getApplication(), hub_service.class);
            intent.putExtra("user_id", strUserID);
            intent.putExtra("firstname", strFirstname);
            intent.putExtra("lastname", strLastname);
            intent.putExtra("status", strStatus);
            startActivity(intent);
        }
    }
}