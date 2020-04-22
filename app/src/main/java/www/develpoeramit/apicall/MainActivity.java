package www.develpoeramit.apicall;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.HashMap;

import www.develpoeramit.mapicall.ApiCallBuilder;

public class MainActivity extends AppCompatActivity {

    private TextView tv_result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv_result=findViewById(R.id.tv_result);

    }

    private HashMap<String, String> getParam() {
        HashMap<String,String>param=new HashMap<>();
        return param;
    }

    public void onContinue(View view) {
        ApiCallBuilder.build(this)
                .isShowProgressBar(true)
                .setUrl("http://doctor-cars.com/health/webservice/get_banner")
                .execute(new ApiCallBuilder.onResponse() {
                    @Override
                    public void Success(String response) {
                        tv_result.setText(response);
                    }

                    @Override
                    public void Failed(String error) {
                        Toast.makeText(MainActivity.this, ""+error, Toast.LENGTH_SHORT).show();
                        tv_result.setText(error);
                    }
                });
    }
}
