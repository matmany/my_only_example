package com.example_api3.mamani.my_only_exemple;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class MainActivity extends AppCompatActivity {
 private TextView textJson;

    private Movie[] movies = new Movie[50];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textJson = (TextView) findViewById(R.id.textJSON);
    }


     class JsonTask extends AsyncTask<String,String,String>
     {


         @Override
         protected String doInBackground(String... param) {

             HttpURLConnection connection = null;
             BufferedReader reader = null;

             try {

                 URL url = new URL(param[0]);

                 connection = (HttpURLConnection) url.openConnection();
                 connection.connect();

                 InputStream stream = connection.getInputStream();

                 reader = new BufferedReader(new InputStreamReader(stream));

                 StringBuffer buffer = new StringBuffer();

                 String line = "";

                 while((line = reader.readLine()) != null)
                 {
                     buffer.append(line);
                 }

                 String arry = buffer.toString();

                   return arry;

             } catch (MalformedURLException e) {
                 e.printStackTrace();
             } catch (IOException e) {
                 e.printStackTrace();
             }


             return null;

         }

         @Override
         protected void onPostExecute(String s) {
             super.onPostExecute(s);
//             textJson.setText(s);
             String Jsontext="";

             try {
                 JSONObject parentJSON = new JSONObject(s);
                 JSONArray arryJSON = parentJSON.getJSONArray("movies");

                 for(int i=0; i<arryJSON.length();i++) {
                     movies[i] = new Movie();
                     JSONObject sonJSON = arryJSON.getJSONObject(i);

                     String name =  sonJSON.getString("movie");
                     int year = sonJSON.getInt("year");
                     int raiting = sonJSON.getInt("raiting");

                     movies[i].setmVname(name);
                     movies[i].setmVyear(year);
                     movies[i].setRating(raiting);

                     Jsontext += movies[i].string_name_year();
                     //Jsontext +="\nNames: "+name+"\n Year: "+year+"\n";
                 }

             } catch (JSONException e) {
                 e.printStackTrace();
             }

             textJson.setText(Jsontext);


         }

     }

    public void botttom(View v)
    {
        new JsonTask().execute("http://jsonparsing.parseapp.com/jsonData/moviesDemoList.txt");





    }
}
