package com.example.admin.diseaseoutput;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URI;

public class MainActivity extends AppCompatActivity {

    ListView listView;
    ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


         listView = (ListView) findViewById(R.id.ListView);
         adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1);
         listView.setAdapter(adapter);
        new Connection().execute();
    }

    class Connection extends AsyncTask<String,String, String>{

        @Override
        protected String doInBackground(String... strings) {

            String result ="";
            String host ="http://192.168.0.3/upload/finalresult.php";

            try{
                HttpClient client = new DefaultHttpClient();
                HttpGet request = new HttpGet();
                request.setURI(new URI(host));
                HttpResponse response = client.execute(request);
                BufferedReader reader = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));

                StringBuffer stringBuffer = new StringBuffer("");

                String line = "";
                while((line = reader.readLine()) != null){
                    stringBuffer.append(line);
                    break;

                }
                reader.close();
                result = stringBuffer.toString();
            }
            catch(Exception e){
                return new String("There exception "+e.getMessage());
            }


            return result;
        }
        @Override
        protected void onPostExecute(String result){
            try {
                JSONObject jsonResult = new JSONObject(result);
                int success = jsonResult.getInt("success");
                if(success == 1){

                    JSONArray a = jsonResult.getJSONArray("a");
                    for(int i=0; i < a.length(); i++){
                        JSONObject b = a.getJSONObject(i);
                        String output = b.getString("output");
                        String line = output;
                        adapter.add(line);
                    }
                }
                else{
                    Toast.makeText(getApplicationContext(),"Something",Toast.LENGTH_SHORT).show();
                }

            }
            catch (JSONException e) {
                e.printStackTrace();
            }

        }
    }
    public void close(View view){
        if (view.getId() == R.id.button){
            Intent i = getPackageManager().getLaunchIntentForPackage("com.example.admin.skinclinic");
            startActivity(i);
        }
    }

}
