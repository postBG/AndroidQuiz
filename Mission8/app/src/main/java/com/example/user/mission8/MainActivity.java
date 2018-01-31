package com.example.user.mission8;

import android.graphics.drawable.Drawable;
import android.graphics.drawable.VectorDrawable;
import android.os.Build;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.AppCompatEditText;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.LinearLayout;


public class MainActivity extends AppCompatActivity {

    private boolean isSearchBarVisible = false;

    private Animation slideDownAnimation;
    private Animation slideUpAnimation;

    private AppCompatEditText uriInput;
    private Button searchButton;
    private LinearLayout searchBar;
    private WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        searchButton = (Button) findViewById(R.id.search_button);
        searchBar = (LinearLayout) findViewById(R.id.search_bar);
        uriInput = (AppCompatEditText) findViewById(R.id.url_input);

        webView = (WebView) findViewById(R.id.web_view);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.setWebViewClient(new WebViewClient());
        webView.loadUrl("http://m.naver.com/");


        slideDownAnimation = AnimationUtils.loadAnimation(this, R.anim.slide_down);
        slideDownAnimation.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {
            }

            @Override
            public void onAnimationEnd(Animation animation) {
                searchBar.setVisibility(View.VISIBLE);
                isSearchBarVisible = true;
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });

        slideUpAnimation = AnimationUtils.loadAnimation(this, R.anim.slide_up);
        slideUpAnimation.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                searchBar.setVisibility(View.GONE);
                isSearchBarVisible = false;
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
    }

    public void onClickSearchButton(View view) {
        if (isSearchBarVisible) {
            searchBar.startAnimation(slideUpAnimation);
            searchButton.setCompoundDrawablesWithIntrinsicBounds(R.drawable.ic_keyboard_arrow_down_black_24px, 0, 0, 0);
        } else {
            searchBar.startAnimation(slideDownAnimation);
            searchButton.setCompoundDrawablesWithIntrinsicBounds(R.drawable.ic_keyboard_arrow_up_black_24px, 0, 0, 0);
        }
    }

    public void onClickSearch(View view) {
        String uri = uriInput.getText().toString();
        uriInput.setText("");

        webView.loadUrl(uri);

        searchBar.startAnimation(slideUpAnimation);
        searchButton.setCompoundDrawablesWithIntrinsicBounds(R.drawable.ic_keyboard_arrow_down_black_24px, 0, 0, 0);
    }
}
