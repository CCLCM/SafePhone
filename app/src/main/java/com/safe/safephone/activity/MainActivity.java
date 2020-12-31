package com.safe.safephone.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.widget.TextView;

import com.safe.safephone.BuildConfig;
import com.safe.safephone.R;
import com.safe.safephone.utils.StreamUtils;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URL;
import java.net.URLConnection;

public class MainActivity extends AppCompatActivity {

    private TextView tv_version;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv_version = findViewById(R.id.tv_version);
        tv_version.setText("版本号:" + getVersionName());
    }

    public String  getVersionName() {
        PackageManager packageManager = getPackageManager();
        try {
            PackageInfo packageInfo = packageManager.getPackageInfo(getPackageName(), 0);
           return packageInfo.getLongVersionCode()+"";

        } catch (PackageManager.NameNotFoundException e) {

        }
        return "";
    }


    public void checkVesion() {
        try {
            URL url = new URL("12345");
            HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
            urlConnection.setRequestMethod("GET");
            urlConnection.setConnectTimeout(5000);
            urlConnection.setReadTimeout(5000);
            if (urlConnection.getResponseCode() == 200) {
                InputStream inputStream = urlConnection.getInputStream();
                StreamUtils.readFromStream(inputStream);
            }

        } catch (Exception e) {


        }
    }
}