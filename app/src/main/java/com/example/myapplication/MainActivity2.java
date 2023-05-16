package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
    }


    public void dialCall(View v){
        String contact = "tel:+923456780578";

        Intent intent = new Intent(Intent.ACTION_DIAL);
        intent.setData(Uri.parse(contact));
        startActivity(intent);
    }

    public void sendDataToEmail(View v){
        EditText title=(EditText) findViewById(R.id.myEditText);
        EditText description=(EditText) findViewById(R.id.textArea);

        String titleContent=title.getText().toString();
        String descriptionContent=description.getText().toString();

        Intent intent=new Intent(Intent.ACTION_SEND);
        intent.putExtra(Intent.EXTRA_SUBJECT,titleContent);
        intent.putExtra(Intent.EXTRA_TEXT,descriptionContent);

        intent.setType("message/rfc822");
        intent.setPackage("com.google.android.gm");
        try {
            startActivity(intent);
        } catch(ActivityNotFoundException e){
            Toast.makeText(this, "Gmail is not installed on your device", Toast.LENGTH_SHORT).show();
        }


    }

    public void sendDataToWhatsapp(View v){


        Intent what = new Intent(Intent.ACTION_VIEW);
        EditText title=(EditText) findViewById(R.id.myEditText);
        EditText description=(EditText) findViewById(R.id.textArea);

        // getting the text and storing it in string
        String titleContent=title.getText().toString();
        String descriptionContent=description.getText().toString();
        Intent intent=new Intent(Intent.ACTION_SEND);
        String details=titleContent +"\n"+descriptionContent;

        String message = details;
        String number = "tel:+923004042213";
        what.setData(Uri.parse("whatsapp://send?phone=" + number + "&text=" + message));
        startActivity(what);
    }

    public void moveback(View v){
        Intent intent = new Intent(this,MainActivity.class);
        startActivity(intent);
    }


}

