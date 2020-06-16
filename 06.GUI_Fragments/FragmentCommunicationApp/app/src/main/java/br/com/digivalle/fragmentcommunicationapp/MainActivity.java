package br.com.digivalle.fragmentcommunicationapp;

import android.app.Activity;
import android.os.Bundle;

public class MainActivity extends Activity implements TextFragment.OnInvertListener {

    private ResultFragment resultFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        resultFragment = (ResultFragment) getFragmentManager().findFragmentById(R.id.result_fragment);
    }

    @Override
    public void onInvert(String text) {
        resultFragment.invert(text);
    }
}