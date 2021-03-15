package com.example.admin.detection;

import android.Manifest;
import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;
import java.io.File;
import java.util.Timer;
import java.util.TimerTask;

import android.graphics.PorterDuff.Mode;
import android.graphics.Color;

import com.example.admin.detection.Remote.IUploadAPI;
import com.example.admin.detection.Remote.RetrofitClient;
import com.example.admin.detection.Utils.ProgressRequestBody;
import com.example.admin.detection.Utils.UploadCallBacks;
import com.ipaulpro.afilechooser.utils.FileUtils;

import okhttp3.MultipartBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity implements UploadCallBacks {

    public static final String BASE_URL = "http://192.168.0.3/";
    private static final int REQUEST_PERMISSION = 1000;
    private static final int PICK_FILE_REQUEST = 1001 ;

    IUploadAPI mService;
    Button btnUpload;
    ImageView imageView;
    Button btnconfirm;
    Timer timer;

    Uri selectedFileUri;

    ProgressDialog dialog;
    private boolean isExecuted = false;


    private IUploadAPI getAPIUpload(){

        return RetrofitClient.getClient(BASE_URL).create(IUploadAPI.class);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //check permission
        if(ActivityCompat.checkSelfPermission(this, Manifest.permission.READ_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED)
        {
            ActivityCompat.requestPermissions(this,new String[]{
                    Manifest.permission.READ_EXTERNAL_STORAGE
            },REQUEST_PERMISSION);
        }


        //service
        mService = getAPIUpload();

        //Init view
        btnUpload = (Button)findViewById(R.id.btn_upload);
        imageView = (ImageView)findViewById(R.id.image_view);



        //Event
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                chooseFile();
            }
        });

        btnUpload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                uploadFile();
            }
        });




    }




    private void uploadFile(){
        if(selectedFileUri != null)
        {
            dialog = new ProgressDialog(MainActivity.this);
            dialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
            dialog.setMessage("Uploading......");
            dialog.setIndeterminate(false);
            dialog.setMax(100);
            dialog.setCancelable(false);
            dialog.show();


            File file = FileUtils.getFile(this,selectedFileUri);
            ProgressRequestBody requestFile = new ProgressRequestBody(file,this);

            final MultipartBody.Part body = MultipartBody.Part.createFormData("uploaded_file",file.getName(),requestFile);

            new Thread(new Runnable() {
                @Override
                public void run() {
                    mService.uploadFile(body)
                            .enqueue(new Callback<String>() {
                                @Override
                                public void onResponse(Call<String> call, Response<String> response) {
                                    dialog.dismiss();
                                    Toast.makeText(MainActivity.this,"Uploaded !",Toast.LENGTH_SHORT).show();

                                    Handler h  = new Handler();
                                    h.postDelayed(new Runnable() {
                                        @Override
                                        public void run() {
                                            btnconfirm = (Button)findViewById(R.id.btn_confirm);
                                            btnconfirm.setEnabled(true);
                                        }
                                    },10000);


                                }

                                @Override
                                public void onFailure(Call<String> call, Throwable t) {
                                    dialog.dismiss();
                                    Toast.makeText(MainActivity.this, t.getMessage(), Toast.LENGTH_SHORT).show();

                                }
                            });

                }
            }).start();




        }


    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        switch (requestCode)
        {
            case REQUEST_PERMISSION:
            {
                if(grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED)
                    Toast.makeText(this,"permission granted",Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(this, "permission denied", Toast.LENGTH_SHORT).show();
            }
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == Activity.RESULT_OK)
            {
              if(requestCode == PICK_FILE_REQUEST)
              {
                  if(data != null)
                  {
                      selectedFileUri = data.getData();
                      if(selectedFileUri != null && !selectedFileUri.getPath().isEmpty())
                          imageView.setImageURI(selectedFileUri);
                      else
                          Toast.makeText(this,"Cannot upload file to server",Toast.LENGTH_SHORT).show();
                  }
              }

            }
        }


    private void chooseFile(){

        Intent intent = Intent.createChooser(FileUtils.createGetContentIntent(),"Select a file");
        startActivityForResult(intent,PICK_FILE_REQUEST);
    }

    @Override
    public void onProgressUpdate(int percentage) {
        dialog.setProgress(percentage);

    }
    public void bck_Click (View view) {

        if (view.getId() == R.id.imageView) {

           Intent intent = new Intent(Intent.ACTION_MAIN);intent.setClassName("com.example.admin.skinclinic","com.example.admin.skinclinic.Display");
           startActivity(intent);
        }


    }
    public void onConfirm(View view){

        if (view.getId() == R.id.btn_confirm){
            Intent i = getPackageManager().getLaunchIntentForPackage("com.example.admin.diseaseoutput");
            startActivity(i);
        }
    }
}
