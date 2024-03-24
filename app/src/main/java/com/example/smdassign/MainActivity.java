package com.example.smdassign;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();
    }

    private void init() {
        TextView textView = findViewById(R.id.loginHereText);

        String text = "Already have an account? Login Here";
        SpannableString spannableString = new SpannableString(text);

        ClickableSpan clickableSpan = new ClickableSpan() {
            @Override
            public void onClick(View widget) {
                // Handle click action here
                String loginUrl = "https://your_login_url_here.com";
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(loginUrl));
                startActivity(intent);
            }
        };

        // Set the clickable span for the "Login Here" part
        spannableString.setSpan(clickableSpan, text.indexOf("Login Here"), text.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

        // Set the spannable text to the TextView
        textView.setText(spannableString);
        textView.setMovementMethod(LinkMovementMethod.getInstance()); // Make links clickable
    }
}

