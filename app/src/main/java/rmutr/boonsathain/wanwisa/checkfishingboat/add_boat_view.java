package rmutr.boonsathain.wanwisa.checkfishingboat;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
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

public class add_boat_view extends AppCompatActivity {

    //Explicit

    private String userIdString, statusString;

    private EditText sEditTextearch;
    private Button searcButton;
    private ListView searchListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_boat_view);

        userIdString = getIntent().getStringExtra("user_id");
        statusString = getIntent().getStringExtra("status");

        widget();
        getData();
    }

    private void getData() {
        String  searchString = sEditTextearch.getText().toString();
        String url = MyConnection.url + "boat_add_view_search.php";

        List<NameValuePair> params = new ArrayList<>();
        params.add(new BasicNameValuePair("search", "y"));
        params.add(new BasicNameValuePair("boat_name", searchString));

        try {
            JSONArray data = new JSONArray(MyConnection.getHttpPost(url, params));

            final String data1 = "boat_name", data2 = "boat_license", data3 = "id";
            final ArrayList<HashMap<String, String>> MyArrList = new ArrayList<>();
            HashMap<String, String> map;

            for (int i = 0; i < data.length(); i++) {
                JSONObject c = data.getJSONObject(i);

                map = new HashMap<>();
                map.put(data1, c.getString(data1));
                map.put(data2, c.getString(data2));
                map.put(data3, c.getString(data3));
                MyArrList.add(map);
            }

            SimpleAdapter sAdap;
            sAdap = new SimpleAdapter(add_boat_view.this, MyArrList, R.layout.list_boat_add_view_adap,
                    new String[]{data1, data2}, new int[]{R.id.textView48, R.id.textView57});
            searchListView.setAdapter(sAdap);

            searchListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    Intent intent = new Intent(getApplication(), add_boat_select.class);
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
        sEditTextearch = (EditText) findViewById(R.id.editText33);
        searcButton = (Button) findViewById(R.id.button6);
        searcButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getData();
            }
        });
        searchListView = (ListView) findViewById(R.id.listView);
    }
}