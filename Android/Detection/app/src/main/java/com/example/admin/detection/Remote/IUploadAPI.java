package com.example.admin.detection.Remote;


import okhttp3.MultipartBody;
import retrofit2.Call;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;

/**
 * Created by admin on 02-02-2019.
 */

public interface IUploadAPI {

    @Multipart
    @POST("upload/upload.php")
    Call<String> uploadFile(@Part MultipartBody.Part file);
}
