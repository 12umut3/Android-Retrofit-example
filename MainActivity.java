package umut;

import android.app.Activity;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.RetrofitError;
import retrofit.client.Response;
import utils.Constants;

public class MainActivity extends Activity {

    private Button start_button;
    private ListView listview;
    private RestAdapter restAdapter;
    private RestInterfaceController restInterface;
    private ProgressDialog progressDialog;
    private List<Items> list = new ArrayList<Items>();
    private CustomAdapter customAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        start_button = (Button)findViewById(R.id.startButton);

        listview = (ListView)findViewById(R.id.listview);
        //Refreshing Authentication token using Retrofit without modifying all calls
        restAdapter = new RestAdapter.Builder()
                .setEndpoint(Constants.URL)
                .build();
        // Take data from the RestInterfaceController class to the restInterface 
        //RestAdapter adapts a Java interface to a REST API.
        restInterface = restAdapter.create(RestInterfaceController.class);
        
        start_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                progressDialog = new ProgressDialog(MainActivity.this);
                progressDialog.setMessage("Download..");
                progressDialog.setCancelable(false);
                progressDialog.show();
                //getting JSON values from Restrofit Model
                restInterface.getJsonValues(new Callback<RetrofitModel[]>() {
                    @Override
                    public void success(RetrofitModel[] model, Response response) {


                        for (RetrofitModel modelValues : model) {

                            Items items = new Items();
                            items.setName(modelValues.getName());
                            items.setBookId(modelValues.getBookId());
                            items.setPrice(modelValues.getPrice());
                            items.setInStock(modelValues.getInStock());
                            list.add(items);

                        }

                        progressDialog.cancel();

                        customAdapter = new CustomAdapter(getApplicationContext(),list);
                        listview.setAdapter(customAdapter);

                    }

                    @Override
                    public void failure(RetrofitError error) {

                        String merror = error.getMessage();
                        Toast.makeText(getApplicationContext(),merror,Toast.LENGTH_LONG).show();
                    }
                });
            }
        });

    }
}
