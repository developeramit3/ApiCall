package www.develpoeramit.apicall;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.HashMap;

import www.develpoeramit.mapicall.ApiCallBuilder;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        new ApiCallBuilder().build(this)
                .isShowProgressBar(true)
                .setParam(getParam())
                .setUrl("url")
                .setFile("image","file_path")
                .execute(new ApiCallBuilder.onResponse() {
                    @Override
                    public void Success(String response) {

                    }

                    @Override
                    public void Failed(String error) {

                    }
                });
    }

    private HashMap<String, String> getParam() {
        return null;
    }
}
