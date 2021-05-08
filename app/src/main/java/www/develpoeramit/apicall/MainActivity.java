package www.develpoeramit.apicall;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import java.util.HashMap;

import www.develpoeramit.mapicall.ApiCallBuilder;
import www.develpoeramit.mapicall.Method;

public class MainActivity extends AppCompatActivity {

    private TextView tv_result;
    private final String AWS_TOKEN="Bearer v^1.1#i^1#I^3#f^0#p^1#r^0#t^H4sIAAAAAAAAAOVYa2wURRzv9UWwtmKCgFD1XKuN1t2b3XvtLfSSK23TaumDO5u2YJp9zLZL73avO7NtL4WkVm2MfpFogBBJWkhUYtREAlYF/WCioUEMWiM2CoiGQBD5YqSRDzi3V8q1EmjpGZt4ueRuZv7P3/wfMwMG8pc+MVQzdKXQsSR7eAAMZDscbAFYmp9XVpSTvTovC6QROIYHSgZyB3POr0NiLBoXNkIUN3QEnX2xqI4Ee7KcskxdMESkIUEXYxAJWBbCoQ11AscAIW4a2JCNKOWsrSyn/B7RHfB5ZD/wwoCbDZBZ/brMiFFOiT6/j+eg1+fl/Rz0+ck6Qhas1REWdVxOcYBjaeClAR9hgeDmyZcBwNdGOZuhiTRDJyQMoIK2uYLNa6bZemtTRYSgiYkQKlgbqg43hGorq+oj61xpsoJTOISxiC00c7TeUKCzWYxa8NZqkE0thC1ZhghRrmBKw0yhQui6MXdgvg21T5VlkYN+WSGgE1AzAmW1YcZEfGs7kjOaQqs2qQB1rOHE7RAlaEhboIynRvVERG2lM/nTZIlRTdWgWU5VVYRaQ42NVDAMe6AeMmP0jT8VLbTIuT0+VnKztCixvCTy/JSilLQpmGdpWm/oipYEDTnrDVwBidVwNjZcGjaEqEFvMEMqTlqUTsdNYwjakpua2kULd+rJfYUxAoTTHt5+B6a5MTY1ycJwWsLsBRsikjbxuKZQsxftWJwKnz5UTnViHBdcrt7eXqbXzRhmh4sDgHW1bKgLy50wJlKENpnrKXrt9gy0ZrsiQ8KJNAEn4sSWPhKrxAC9gwq6fV4v4KZwn2lWcPbsPybSfHbNzIhMZYgSAD5Z9kker8frVwGfiQwJTgWpK2kHlMQEHRPNLojjUVGGtEzizIpBU1MEt1fl3LwKacUXUGlPQFVpyav4aFaFEEAoSXKA/z8lylxDPQxlE+KMxHrG4rylE0W6+gK8t+kprUpuaeHatlR1N/aaqsVbPqulp66ysUpX1reKXrl8rtlwU+fXRzWCTITozwQAyVzPHAg1BsJQWZB7YdmIw0YjqsmJxbXBblNpFE2cqLASZByG0Sj5WZCroXi8NjMVO2NOzrNY3JnfmetU/1GXuqlXKBm4i8urJD8iAsS4xpA+lMz1BCMbMZchkkNIcrrdtto5i/CmRC7JSjAdFkSYWKKQc+CcmTRSzBnS0pS5s6QaJnFi7izkkqFYMr4jRXZnZgiaWkcnRvPS2bcQUCQr2rWgoNPI5WFRhRxxN+W3pqRO/YztPIN6ZMaEyLBMcuFhGpKH4IjRBXVypMCmEY1Cs5ldcDGNxSwsSlG42KpqBqqLJs7vvJM76Bj71/1ifRzw+IGbXVg/kO0TTfti6wmZ7oXzuNu4Zr60BLPsDzvoOAIGHR9lOxzAD2i2DDyen/NMbs7dFCLVhEGirkhGH6OJKkMKmS5iy4RMF0zERc3MzndoE+PyZNobz/CzYNX0K8/SHLYg7ckHFN9YyWPvWVnIscALeBa4eTffBh65sZrLrshdrly4OvzGi6+Fq74++vHWh4dqxs+8OgYKp4kcjrwsEpBZ6tmJNW+OdJXqP2z1DFxqXzK5+rMDb39xb3dwsqzp243tK4vDm5aPHVcvfnV/5A860X/sbG323n3OTa0lf7137dSj+R+Mf7iiOvDzueKng+fGRz7NLu0+uhs9lPX7+ZcjRVdGrOrC7ed3NdT9ti2r9PSTQ5Gh734aP3FP7+jBzSOrYiVXl5X2T+w+8Zij/9D3PTuqS7ccq5k8+P7OXCrYPyLuOvnW6J7hkrbjDZ9Xbz517MfwvrsKHIWHysp+KSou+LPoAn5hdM2yS5Wj+09v3/vOmQcv3bfTufPkjtMTJc/3ftmsvnTkgXf3t46E+q+Fxw7w7OH6bd9IVy6+snbP5aOHm3Yf4K+hXz+RLr/+XPfa1Db+DeTc1A99EwAA";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv_result=findViewById(R.id.tv_result);

    }
    public HashMap<String,String>getAWSHeader(){
        HashMap<String,String>param=new HashMap<>();
        param.put("Authorization",AWS_TOKEN);
        param.put("Content-Type","application/json");
        param.put("X-EBAY-C-MARKETPLACE-ID","EBAY_IN");
        param.put("X-EBAY-C-ENDUSERCTX","affiliateCampaignId=<ePNCampaignId>,affiliateReferenceId=<referenceId>");
        return param;
    }

    public void onContinue(View view) {
        ApiCallBuilder.build(this).setMethod(Method.GET)
                .setUrl("https://api.sandbox.ebay.com/buy/browse/v1/item_summary/search?q=drone&limit=3")
                .setHeader(getAWSHeader())
                .isShowProgressBar(true)
                .setTimeOut(10)
                .execute(new ApiCallBuilder.onResponse() {
                    @Override
                    public void Success(String response) {
                        Log.e("Response",response);
                        tv_result.setText(response);
                    }

                    @Override
                    public void Failed(String error) {
                        Log.e("error",error);
                        tv_result.setText(error);
                    }
                });
    }
}
