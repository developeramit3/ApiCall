package www.develpoeramit.mapicall;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.net.Uri;
import android.os.Handler;
import android.os.StrictMode;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class ApiCallBuilder {
    private Handler mHandler;
    private static final String TAG = "ApiCallBuilder";
    private MultipartBody.Builder builder;
    private Activity mContext;
    private ProgressDialogBuilder progress;
    private String mUrl="";
    private boolean isSetFile=true;

    public ApiCallBuilder build(Activity context){
        this.mContext=context;
        builder = new MultipartBody.Builder().setType(MultipartBody.FORM);
        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
        return this;
    }
    public ApiCallBuilder setUrl(String url){
        this.mUrl=url;
        return this;
    }
    public ApiCallBuilder isShowProgressBar(boolean b){
        if (b&&mContext!=null){
           progress=new ProgressDialogBuilder(mContext)
                    .setProgressStyle(ProgressStyle.STYLE_3);
           progress.show();
        }
        return this;
    }
    public ApiCallBuilder isShowProgressBar(boolean b,ProgressStyle style){
        if (b&&mContext!=null){
           progress=new ProgressDialogBuilder(mContext)
                    .setProgressStyle(style);
           progress.show();
        }
        return this;
    }
    public ApiCallBuilder setParam(HashMap<String,String> map){
        for (Map.Entry<String, String> entry : map.entrySet()) {
            builder.addFormDataPart(entry.getKey(),entry.getValue());
        }
        return this;
    }
    public ApiCallBuilder setFilePathArray(String key, ArrayList<String> filePaths){
        isSetFile=filePaths.isEmpty();
        for (int i = 0; i < filePaths.size(); i++) {
            Uri resimUri = Uri.parse(filePaths.get(i));
            File file = new File(resimUri.getPath());
            builder.addFormDataPart(key, file.getName(), RequestBody.create(MediaType.parse("multipart/form-data"), file));
        }
        return this;
    }
    public ApiCallBuilder setFileUriArray(String key,ArrayList<Uri> filePaths){
        isSetFile=filePaths.isEmpty();
        for (int i = 0; i < filePaths.size(); i++) {
            File file = new File(filePaths.get(i).getPath());
            builder.addFormDataPart(key, file.getName(), RequestBody.create(MediaType.parse("multipart/form-data"), file));
        }
        return this;
    }
    public ApiCallBuilder setFile(String key,Uri imageUri){
        if (imageUri!=null) {
            File file = new File(imageUri.getPath());
            builder.addFormDataPart(key, file.getName(), RequestBody.create(MediaType.parse("multipart/form-data"), file));
        }else {
            isSetFile=false;
        }
        return this;
    }
    public ApiCallBuilder setFile(String key,File file){
        if (file.exists()) {
            builder.addFormDataPart(key, file.getName(), RequestBody.create(MediaType.parse("multipart/form-data"), file));
        }else {
            isSetFile=false;
        }
        return this;
    }
    public ApiCallBuilder setFile(String key,String path){
        File file = new File(path);
        if (file.exists()) {
            builder.addFormDataPart(key, file.getName(), RequestBody.create(MediaType.parse("multipart/form-data"), file));
        }else {
            isSetFile=false;
        }
        return this;
    }
    public void execute(final onResponse callback) {
        if (progress!=null) progress.show();
        if (mUrl=="") {callback.Failed("Url not set.");return;}
        RequestBody requestBody = builder.build();
        Request request = new Request.Builder()
                .url(mUrl)
                .post(requestBody)
                .build();
        OkHttpClient client = new OkHttpClient();
        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, final IOException e) {
                mContext.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        if (progress != null)
                            progress.dismiss();
                        callback.Failed(e.getLocalizedMessage());
                    }
                });
            }

            @Override
            public void onResponse(Call call, final Response response) throws IOException {
                mContext.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        if (progress != null)
                            progress.dismiss();
                        try {
                            callback.Success(response.body().string());
                        } catch (IOException e) {
                            e.printStackTrace();
                        }
                    }
                });
            }
        });
    }
    public interface onResponse{
        void Success(String response);
        void Failed(String error);
    }
}
