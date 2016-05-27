package com.example.lenovo.a;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Toast;

import com.squareup.okhttp.Call;
import com.squareup.okhttp.Callback;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

import java.io.IOException;

public class MainActivity extends AppCompatActivity {
  private String url="http://suggest.taobao.com/sug?code=utf-8&q=p&callback=cb";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //创建okHttpClient对象
        OkHttpClient mOkHttpClient = new OkHttpClient();
//创建一个Request
        final Request request = new Request.Builder()
                .url("http://base.dancebook.com.cn/common/user/getTopUserList?order=3&type=5&top=3")
                .build();
//new call
        Call call = mOkHttpClient.newCall(request);
//请求加入调度
        call.enqueue(new Callback() {

            public void onFailure(Request request, IOException e) {

            }


            public void onResponse(final Response response) throws IOException {
                final String htmlStr =  response.body().string();
                runOnUiThread(new Runnable()
                {
                    @Override
                    public void run() {
                        Log.d("MainActivity", htmlStr);
                        Toast.makeText(MainActivity.this,htmlStr,0).show();
                    }

                });
            }
        });

    }
}
