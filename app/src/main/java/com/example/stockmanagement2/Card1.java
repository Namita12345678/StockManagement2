package com.example.stockmanagement2;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.Login_Getter_Setter;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Card1 extends AppCompatActivity {

    private static final String product_url="https://screechy-buzzers.000webhostapp.com/Stock/products.php?title=iPhone";

    //the recyclerview
    RecyclerView recyclerView;
    EditText search;

    ProductAdapter adapter;

    final ExecutorService executorService = Executors.newSingleThreadExecutor();

    //a list to store all the products
    List<Product> productList;

    String result;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_card1);

        //getting the recyclerview from xml
        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        search = findViewById(R.id.edtxt_search);

        //initializing the productlist
        productList = new ArrayList<Product>();

        //this method will fetch and parse json
        //to display it in recyclerview
        loadsearch(product_url);


        search.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                String search_url= "https://screechy-buzzers.000webhostapp.com/Stock/search_view.php?title="+charSequence;
                String s =search_url;
                Log.d("TAG", "Search_url: "+s);
                loadsearch(search_url);

            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });




    }

   /* @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.id.searchView);
        return super.onCreateOptionsMenu(menu);
    }
*/
   /* private void loadProducts(String search_url) {
        /*
         * Creating a String Request
         * The request type is GET defined by first parameter
         * The URL is defined in the second parameter
         * Then we have a Response Listener and a Error Listener
         * In response listener we will get the JSON response as a String
         * */
     /*   StringRequest stringRequest = new StringRequest(Request.Method.GET, search_url,
        new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    //converting the string to json array object
                    JSONArray array = new JSONArray(response);

                    productList = new ArrayList<>();
                    //traversing through all the object
                    Log.v("url","Response: "+response);

                    Log.d("TAG", "array length: "+array.length());
                    for (int i = 0; i < array.length(); i++) {

                        //getting product object from json array
                        JSONObject jsonObject11 = array.getJSONObject(i);

                        Product product = new Product();

                        //adding the product to product list

                        product.setId(jsonObject11.getInt("id"));
                        product.setTitle(jsonObject11.getString("title"));
                        product.setShortdesc(jsonObject11.getString("shortdesc"));
                        product.setRating(jsonObject11.getDouble("rating"));
                        product.setPrice(jsonObject11.getDouble("price"));
                        product.setImage(jsonObject11.getString("image"));

                        productList.add(product);
                    }

        //creating recyclerview adapter
        ProductAdapter adapter = new ProductAdapter(Card1.this, productList);

        //setting adapter to recyclerview
        recyclerView.setAdapter((RecyclerView.Adapter) adapter);

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                    }
                });

        //adding our stringrequest to queue
        Volley.newRequestQueue(this).add(stringRequest);

      /*  Intent intent = new Intent(Card1.this, Card1.class);
        intent.putExtra("URL", url);
        startActivity(intent);


    }*/

    private void loadsearch(String search_url){

        executorService.execute(new Runnable() {
            @Override
            public void run() {

                try
                {
                    JsonParser o = new JsonParser();
                    result = o.insert(search_url);
                    productList = new ArrayList<>();

                    Log.d("search_url", "run: "+search_url);

                    JSONObject jsonObject = new JSONObject(result);
                    JSONArray jsonArray = jsonObject.getJSONArray("res");

                    Log.v("Login_DATA",""+result);

                    for (int i = 0; i < jsonArray.length(); i++) {

                        JSONObject jsonObject11 = jsonArray.getJSONObject(i);
                        Product product = new Product();

                        product.setId(jsonObject11.getInt("id"));
                        product.setTitle(jsonObject11.getString("title"));
                        product.setShortdesc(jsonObject11.getString("shortdesc"));
                        product.setRating(jsonObject11.getDouble("rating"));
                        product.setPrice(jsonObject11.getDouble("price"));
                        product.setImage(jsonObject11.getString("image"));

                        productList.add(product);

                    }
                }
                catch ( JSONException e)
                {
                    e.printStackTrace();
                    //  Toast.makeText(Login.this, "Please check your Internet Connection and Retry", Toast.LENGTH_LONG).show();
                }

                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        //write your UI part here....

                        ProductAdapter adapter = new ProductAdapter(Card1.this, productList);

                        //setting adapter to recyclerview
                        recyclerView.setAdapter((RecyclerView.Adapter) adapter);

                    }
                });

            }
        });

    }

}

