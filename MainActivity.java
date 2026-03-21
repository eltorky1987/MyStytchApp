package com.example.yourapp;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import com.stytch.sdk.StytchClient;
import com.stytch.sdk.ui.StytchUI;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        // هنا نقوم بفتح شاشة تسجيل الدخول
        StytchUI.INSTANCE.start(this);
    }
}
