package com.nxys.monet.volleydemo.myapplication;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

/**
 *  Android Volley 实现HTTP通信
 */
public class MainActivity extends AppCompatActivity {

    private Button button = null;
    private TextView textView = null;
    private Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = (Button)findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //获取到一个RequestQueue对象
                RequestQueue mQueue = Volley.newRequestQueue(getApplicationContext());

                //创建一个StringRequest对象,发出一条HTTP-get请求
                StringRequest stringRequest = new StringRequest("http://www.baidu.com", //目标服务器的URL地址
                        new Response.Listener<String>() {
                            @Override
                            public void onResponse(String response) { //服务器响应成功的回调
                                Log.d("TAG", response);
                            }
                        }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {  //服务器响应失败的回调
                        Log.e("TAG", error.getMessage(), error);
                    }
                });

                mQueue.add(stringRequest); //将这个StringRequest对象添加到RequestQueue里面就可以了
            }
        });
    }


}
