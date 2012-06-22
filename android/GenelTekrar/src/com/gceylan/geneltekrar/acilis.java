package com.gceylan.geneltekrar;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class acilis extends Activity implements OnClickListener {
	
	TextView cikti;
	EditText giris;
	Button gonder, yeniEkran;
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        cikti = (TextView) findViewById(R.id.ekran);
        giris = (EditText) findViewById(R.id.giris);

        gonder = (Button) findViewById(R.id.gonder);
        yeniEkran = (Button) findViewById(R.id.yeniEkran);
        gonder.setOnClickListener(this);
        yeniEkran.setOnClickListener(this);
        
    }

	public void onClick(View v) {
		if (v == gonder) {
			cikti.setText(giris.getText());
			giris.setText("");
		}
		else if (v == yeniEkran) {
			startActivity(new Intent("com.gceylan.geneltekrar.IKINCIEKRAN"));
		}
	}
}