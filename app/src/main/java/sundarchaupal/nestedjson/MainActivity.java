package sundarchaupal.nestedjson;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {
TextView tv1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv1=findViewById(R.id.tv1);
        String url="http://searchkero.com/a/data.json";

        StringRequest stringRequest=new StringRequest(1, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
            DataBreak(response);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
        RequestQueue requestQueue=Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);
        String url1="http://searchkero.com/a/math.json";
        StringRequest stringRequest1=new StringRequest(1, url1, new Response.Listener<String>() {
            @Override
            public void onResponse(String response1) {
          mathbreak(response1);
            }

        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });

    }

    private void mathbreak(String response1) {
        try {
            JSONObject jo=new JSONObject(response1);
            JSONObject jo1=jo.getJSONObject("quiz");
            JSONObject jo2=jo.getJSONObject("sport");
            JSONObject jo3=jo.getJSONObject("q1");
            JSONArray ja=jo3.getJSONArray("options");


        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    private void DataBreak(String response){
        try {
            JSONObject jo=new JSONObject(response);
            JSONObject jo1=jo.getJSONObject("web-app");
            JSONArray ja=jo1.getJSONArray("servlet");
            JSONObject jo2=ja.getJSONObject(4);
            JSONObject jo3=jo2.getJSONObject("init-param");
            String data=jo3.getString("log");
            tv1.setText(data);


        } catch (JSONException e) {
            e.printStackTrace();
        }


    }

}
