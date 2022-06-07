package com.example.uts_10119016_adityailham.ui.gallery;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.uts_10119016_adityailham.MyDatabaseHelper;
import com.example.uts_10119016_adityailham.R;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

//NIM     : 10119016
//NAMA    : ADITYA ILHAM SUBAGJA
//KELAS   : IF-1

public class EditDiaryActivity extends AppCompatActivity {

    /* Deklarasi variable */
    private EditText judulEditText, isiEditText;
    private Date date;
    private SimpleDateFormat dateFormat, monthFormat, yearFormat;
    private Button submitButton;
    private MyDatabaseHelper helper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_add_diary); /*Memanggil tampilan form*/

        Bundle bundle = getIntent().getExtras();

        /*Deklrasi tanggal*/
        date = Calendar.getInstance().getTime();
        dateFormat = new SimpleDateFormat("dd", Locale.getDefault());
        monthFormat = new SimpleDateFormat("MMMM", Locale.getDefault());
        yearFormat = new SimpleDateFormat("yyyy", Locale.getDefault());

        /*Deklrasi button*/
        submitButton = findViewById(R.id.submitButton);
        judulEditText = findViewById(R.id.judul);
        isiEditText = findViewById(R.id.isi);

        judulEditText.setText(bundle.getString("Judul"));
        isiEditText.setText(bundle.getString("Isi"));

        /*Deklarasi SQLite sebagai variabel baru*/
        helper = new MyDatabaseHelper(this);

        /*Fungsi ketika button submit dipencet*/
        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String id = bundle.getString("Id");
                String judul = judulEditText.getText().toString();
                String isi = isiEditText.getText().toString();
                String formattedDate = dateFormat.format(date);
                String formattedMonth = monthFormat.format(date);
                String formattedYear = yearFormat.format(date);

                if (TextUtils.isEmpty(judul)) {
                    judulEditText.setError("Data tidak boleh kosong");
                    judulEditText.requestFocus();
                } else if (TextUtils.isEmpty(isi)) {
                    isiEditText.setError("Data tidak boleh kosong");
                    isiEditText.requestFocus();
                } else {
                    boolean isSuccess = helper.updateData(id, judul, isi, formattedDate, formattedMonth, formattedYear);

                    if (isSuccess) {
                        Toast.makeText(EditDiaryActivity.this, "Catatan berhasil diubah", Toast.LENGTH_SHORT).show();

                        startActivity(new Intent(EditDiaryActivity.this, GalleryFragment.class));
                        finish();
                    } else {
                        Toast.makeText(EditDiaryActivity.this, "Catatan gagal diubah", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }
}
