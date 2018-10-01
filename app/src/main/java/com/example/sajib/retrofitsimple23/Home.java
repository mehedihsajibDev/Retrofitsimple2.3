package com.example.sajib.retrofitsimple23;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.sajib.retrofitsimple23.modelpackege.UserBody;
import com.example.sajib.retrofitsimple23.modelpackege.UserReturn;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Home extends AppCompatActivity {
    String baseUrl = "http://apptitive.com/projects/web/foodpeon_api/";
    String firstname,username,address,phone,password;
    private EditText editTextFirstname;
    private EditText editTextUsername;
    private EditText editTextAddress;
    private EditText editTextphone;
    private EditText  editpassword;
    private Button go;
    private TextView textDetails;
    private ProgressDialog dialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        editTextFirstname=findViewById(R.id.editname);
        editTextUsername=findViewById(R.id.edituser);
        editTextAddress=findViewById(R.id.editaddress);
        editTextphone=findViewById(R.id.editphone);
        editpassword=findViewById(R.id.editapassword);
        textDetails=findViewById(R.id.texdetailsid);
        dialog = new ProgressDialog(this);
        go = findViewById(R.id.go);
        go.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                firstname=editTextFirstname.getText().toString();
                username=editTextUsername.getText().toString();
                phone=editTextphone.getText().toString();
                password=editpassword.getText().toString();
                address=editTextAddress.getText().toString();
                if(firstname.isEmpty()){
                    editTextFirstname.setError("Error");
                }
                if (username.isEmpty()){
                    editTextUsername.setError("Error found");
                }
                if (phone.isEmpty()){
                    editTextphone.setError("Error found");
                }
                if (password.isEmpty()){
                    editpassword.setError("Error found");
                }
                if (address.isEmpty()){
                    editTextAddress.setError("Error found");
                }
                if(!username.isEmpty()&&!firstname.isEmpty()&&!phone.isEmpty()&&!password.isEmpty()&&!address.isEmpty()){
                    loadUser(new UserBody(firstname,username,phone,password,address));
                    dialog.setMessage("loading");
                    dialog.show();
                }
            }
        });
    }
    private void loadUser(UserBody userBody) {
        Gson gson = new GsonBuilder().setLenient().create();
        Log.d("" + gson, "JSON");
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        Log.i("JSON", "yahooo  " + gson);

        Api retroFIT = retrofit.create(Api.class);

        Call<UserReturn> call = retroFIT.getUser(userBody);

        call.enqueue(new Callback<UserReturn>() {
            @Override
            public void onResponse(Call<UserReturn> call, Response<UserReturn> response) {
                try {
                    if (response.code()==200) {
                        UserReturn userReturn = response.body();
                        String name=editTextFirstname.getText().toString();
                        String password=editpassword.getText().toString();
                        if(name.equals("")&& password.equals(""))
                        {
                            Toast.makeText(Home.this, "please Enter some Data", Toast.LENGTH_SHORT).show();
                            dialog.dismiss();
                        }
                        else {
                            SharedPreferences sharedPreferences = getSharedPreferences("userDeatils", Context.MODE_PRIVATE);
                            SharedPreferences.Editor editor = sharedPreferences.edit();
                            editor.putString("usernameKey", name);
                            editor.putString("userpasswordKey", password);
                            editor.commit();
                            editTextFirstname.setText("");
                            editpassword.setText("");
                            Toast.makeText(Home.this, "Insert Successfullyt", Toast.LENGTH_SHORT).show();
                            dialog.dismiss();
                        }
                        Toast.makeText(Home.this, userReturn.getMessage()+ " "+userReturn.getData().getCustFirstName(), Toast.LENGTH_SHORT).show();

                        dialog.dismiss();
                    }else if (response.code() == 422){
                        Toast.makeText(Home.this, "Customer Username"+ username+" has already been taken", Toast.LENGTH_SHORT).show();
                        dialog.dismiss();
                    }else {
                        Toast.makeText(Home.this, "error", Toast.LENGTH_SHORT).show();
                        dialog.dismiss();
                    }

                }catch (Exception e){
                    e.printStackTrace();
                }

            }

            @Override
            public void onFailure(Call<UserReturn> call, Throwable t) {
                Toast.makeText(Home.this, "Not done", Toast.LENGTH_SHORT).show();
                dialog.dismiss();
            }
        });

    }

    public void load(View view) {
        if(view.getId()==R.id.loadid){

            SharedPreferences sharedPreferences = getSharedPreferences("userDeatils", Context.MODE_PRIVATE);
            if(sharedPreferences.contains("usernameKey") && sharedPreferences.contains("userpasswordKey"))
            {
                String name=sharedPreferences.getString("usernameKey","Data not found");
                String password=sharedPreferences.getString("userpasswordKey","Data not fond");
                textDetails.setText(name+"\n"+password);
                dialog.dismiss();
            }
        }

    }
}
