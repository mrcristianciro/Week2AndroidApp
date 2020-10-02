package cirodev.apps.week2demo;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputLayout;

import cirodev.apps.week2demo.dialogs.DatePickerFragment;
import cirodev.apps.week2demo.model.Contact;
import cirodev.apps.week2demo.utils.Constant;

public class MainActivity extends AppCompatActivity {

    TextInputLayout etName, etDate, etPhone, etMail, etDescription;
    Button btnNext;
    Contact contact;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViews();
        setListeners();
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            contact = (Contact)getIntent().getSerializableExtra(Constant.KEY_BUNDLE);
            fillViews();
        }
    }

    private void fillViews() {
        if (contact != null){
            etName.getEditText().setText(contact.getName());
            etDate.getEditText().setText(contact.getDate());
            etPhone.getEditText().setText(contact.getPhone());
            etMail.getEditText().setText(contact.getMail());
            etDescription.getEditText().setText(contact.getDescription());
        }
    }

    private void setListeners() {
        etDate.getEditText().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showDatePickerDialog();
            }
        });
        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkInputs();
            }
        });
    }

    private void checkInputs() {
        if (
                etName.getEditText().getText().toString().isEmpty() ||
                etDate.getEditText().getText().toString().isEmpty() ||
                etPhone.getEditText().getText().toString().isEmpty() ||
                etMail.getEditText().getText().toString().isEmpty() ||
                etDescription.getEditText().getText().toString().isEmpty()
        ) {
            Toast.makeText(this, R.string.invalid_inputs, Toast.LENGTH_LONG).show();
            return;
        }

        contact = new Contact(
                etName.getEditText().getText().toString(),
                etDate.getEditText().getText().toString(),
                etPhone.getEditText().getText().toString(),
                etMail.getEditText().getText().toString(),
                etDescription.getEditText().getText().toString()
        );

        nextActivity(contact);
    }

    private void nextActivity(Contact contact) {
        Intent intent = new Intent(this, DetailActivity.class);
        intent.putExtra(Constant.KEY_BUNDLE, contact);
        startActivity(intent);
    }

    private void findViews(){
        etName = findViewById(R.id.etName);
        etDate = findViewById(R.id.etDate);
        etPhone = findViewById(R.id.etPhone);
        etMail = findViewById(R.id.etMail);
        etDescription = findViewById(R.id.etDescription);
        btnNext = findViewById(R.id.btnNext);
    }

    private void showDatePickerDialog() {
        DatePickerFragment newFragment = DatePickerFragment.newInstance(new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                final String selectedDate = day + " / " + (month+1) + " / " + year;
                etDate.getEditText().setText(selectedDate);
            }
        });
        newFragment.show(this.getSupportFragmentManager(), "datePicker");
    }

}