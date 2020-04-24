package com.example.implicitintentapp;

import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

public class ImplicitIntentActivity extends Activity {
	private static final int REQUEST_CODE = 1;
	Button bt1,bt2,bt3,bt4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_implicit_intent);
        bt1=(Button) findViewById(R.id.button1);
        bt1.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent i=new Intent(android.content.Intent.ACTION_VIEW,Uri.parse("http://www.amazon.com"));
				startActivity(i);
			}
		});
        bt2=(Button) findViewById(R.id.button2);
        bt2.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent callIntent=new Intent(Intent.ACTION_CALL);
				callIntent.setData(Uri.parse("tel:+917780925902"));
				startActivity(callIntent);
			}
		});
        bt3=(Button) findViewById(R.id.button3);
        bt3.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent i= new Intent(android.content.Intent.ACTION_VIEW,Uri.parse("geo:37.827500,-122.481670"));
				i.setPackage("com.google.android.apps.maps");
				startActivity(i);
			}
		});
        bt4=(Button) findViewById(R.id.button4);
        bt4.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent i=new Intent(android.content.Intent.ACTION_PICK);
				i.setType(ContactsContract.Contacts.CONTENT_TYPE);
				startActivityForResult(i,REQUEST_CODE);
			}
		});
        
    }


    @Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		// TODO Auto-generated method stub
		super.onActivityResult(requestCode, resultCode, data);
		if(requestCode==REQUEST_CODE)
		{
			if(resultCode == RESULT_OK)
			{
				Toast.makeText(this, data.getData().toString(), Toast.LENGTH_LONG).show();
				Intent i=new Intent(android.content.Intent.ACTION_VIEW,Uri.parse(data.getData().toString()));
				startActivity(i);			}
		}
	}


	@Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.implicit_intent, menu);
        return true;
    }
    
}
