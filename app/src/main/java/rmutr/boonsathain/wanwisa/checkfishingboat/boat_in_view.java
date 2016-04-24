package rmutr.boonsathain.wanwisa.checkfishingboat;

import android.content.Intent;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class boat_in_view extends AppCompatActivity {

    private String userIdString, statusString;

    private EditText searchEditText;
    private ListView searchListView;
    private Button searchButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_boat_in_view);

        userIdString = getIntent().getStringExtra("user_id");
        statusString = getIntent().getStringExtra("status");

        if (android.os.Build.VERSION.SDK_INT > 9) {
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);
        }

        widget();
        getData();
    }

    private void getData() {
        String  searchString = searchEditText.getText().toString();
        String url = MyConnection.url + "boat_in_view_search.php";

        List<NameValuePair> params = new ArrayList<>();
        params.add(new BasicNameValuePair("search", "y"));
        params.add(new BasicNameValuePair("boat_name", searchString));

        try {
            JSONArray data = new JSONArray(MyConnection.getHttpPost(url, params));

            final String data1 = "boat_name", data3 = "id";
            final ArrayList<HashMap<String, String>> MyArrList = new ArrayList<>();
            HashMap<String, String> map;

            for (int i = 0; i < data.length(); i++) {
                JSONObject c = data.getJSONObject(i);

                map = new HashMap<>();
                map.put(data1, c.getString(data1));
                map.put(data3, c.getString(data3));
                MyArrList.add(map);
            }

            SimpleAdapter sAdap;
            sAdap = new SimpleAdapter(boat_in_view.this, MyArrList, R.layout.list_boat_in_view_adap,
                    new String[]{data1}, new int[]{R.id.textView48});
            searchListView.setAdapter(sAdap);

            searchListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    Intent intent = new Intent(getApplication(), boat_in_view_select.class);
                    intent.putExtra("user_id", userIdString);
                    intent.putExtra("status", statusString);
                    intent.putExtra("boat_id", MyArrList.get(position).get(data3));
                    startActivity(intent);
                }
            });

        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    private void widget() {
        searchEditText = (EditText) findViewById(R.id.editText58);
        searchListView = (ListView) findViewById(R.id.listView2);
        searchButton = (Button) findViewById(R.id.button7);
        searchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getData();
            }
        });
    }
}
