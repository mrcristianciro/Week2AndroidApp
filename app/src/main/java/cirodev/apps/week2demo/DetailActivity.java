package cirodev.apps.week2demo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputEditText;

import cirodev.apps.week2demo.model.Contact;
import cirodev.apps.week2demo.utils.Constant;

public class DetailActivity extends AppCompatActivity {

    Contact contact;
    TextView tvName, tvDate, tvPhone, tvMail, tvDescription;
    Button btnBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            contact = (Contact)getIntent().getSerializableExtra(Constant.KEY_BUNDLE);
        }
        findViews();
        fillViews();
        setListeners();
    }

    private void setListeners() {
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                nextActivity();
            }
        });
    }

    private void nextActivity() {
        Intent intent = new Intent(this, MainActivity.class);
        intent.putExtra(Constant.KEY_BUNDLE, contact);
        startActivity(intent);
    }

    private void fillViews() {
        if (contact != null){
            tvName.setText(contact.getName());
            tvDate.setText(contact.getDate());
            tvPhone.setText(contact.getPhone());
            tvMail.setText(contact.getMail());
            tvDescription.setText(contact.getDescription());
        }
    }

    private void findViews(){
        tvName = findViewById(R.id.tvName);
        tvDate = findViewById(R.id.tvDate);
        tvPhone = findViewById(R.id.tvPhone);
        tvMail = findViewById(R.id.tvMail);
        tvDescription = findViewById(R.id.tvDescription);
        btnBack = findViewById(R.id.btnBack);
    }

}