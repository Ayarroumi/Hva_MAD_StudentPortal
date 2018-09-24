package com.example.anass.studentportal;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class AddPortalActivity extends AppCompatActivity {

    EditText urlField;
    EditText titleField;
    Button  addPortalButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_portal);

        urlField            = (EditText) findViewById(R.id.urlField);
        titleField          = (EditText) findViewById(R.id.titleField);
        addPortalButton     = (Button)   findViewById(R.id.addPortalButton);

        urlField.setText("https://");
        addPortalButton.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                Intent data = new Intent(AddPortalActivity.this, MainActivity.class);
                Bundle bundle = new Bundle();
                bundle.putSerializable("portalObject",  new PortalObject(urlField.getText().toString(),titleField.getText().toString()));
                data.putExtras(bundle);

                setResult(Activity.RESULT_OK, data);
                finish();
            }
        });

    }
}
