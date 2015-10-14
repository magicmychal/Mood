package eu.qm.mood;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;
import android.view.inputmethod.InputMethodManager;


public class MainActivity extends AppCompatActivity {
    Button goRandom;
    EditText enteredText;

    private WebView wv1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        goRandom=(Button)findViewById(R.id.button);
        enteredText=(EditText)findViewById(R.id.wpiszFraze);

        wv1=(WebView)findViewById(R.id.htmlResult);
        wv1.setWebViewClient(new Przegladarka());

        goRandom.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                String preUrl = enteredText.getText().toString();
                String urlWOspaces = preUrl.replaceAll(" ", "+");
                String postUrl = "http://api.giphy.com/v1/gifs/random?fmt=html&api_key=dc6zaTOxFJmzC&tag="+urlWOspaces;
               //nie działa InputMethodManager chowaKlawe = (ImputMethodManager) getSystemService(Context.Imput_Method_Sercive);
               // nie dzieła! chowaKlawe.hideSoftInputFromWindow(enteredText.getWindowToken(), 0);

                wv1.getSettings().setLoadsImagesAutomatically(true);
                wv1.getSettings().setJavaScriptEnabled(true);
                wv1.setScrollBarStyle(View.SCROLLBARS_INSIDE_OVERLAY);
                wv1.loadUrl(postUrl);
            }
        });

    }
    private class Przegladarka extends WebViewClient {
       // @Override
        public boolean shouldOverrideUrlloading(WebView view, String url){
            view.loadUrl(url);
            return true;
        }
    }

}

