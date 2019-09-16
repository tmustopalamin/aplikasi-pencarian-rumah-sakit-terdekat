package com.example.admientoto.cobacoba;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;


public class HasilActivity extends AppCompatActivity {
    String list_rs[] = new String[] {"RS. BAYUKARTA","RS. CITRA SARI INTAN BAROKAH","RS. DELIMA ASIH","RS. DEWI SRI","RS. FIKRI MEDIKA","RS. ISLAM","RS. IZZA","RS. KARYA HUSADA","RS. LIRA MEDIKA","RS. MANDAYA","RS. PROKLAMASI","RS. PURI ASIH","RS. ROSELA","RS. SARASWATI","RS. PERSADA MEDIKA","RSUD. KARAWANG"};
    String KEY_NAME = "idRS";
    String kirim;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setTitle(R.string.halamanHasil);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hasil);

        final ListView list_view = findViewById(R.id.listview);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_expandable_list_item_1,list_rs);
        list_view.setAdapter(adapter);
        list_view.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                kirim = list_rs[position];
                if (kirim == "RS. BAYUKARTA"){
                    Intent intent = new Intent(HasilActivity.this, tampilRS.class);
                    intent.putExtra(KEY_NAME, kirim);
                    startActivity(intent);
                }

                if (kirim == "RS. CITRA SARI INTAN BAROKAH"){
                    Intent intent = new Intent(HasilActivity.this, tampilRS.class);
                    intent.putExtra(KEY_NAME, kirim);
                    startActivity(intent);
                }

                if (kirim == "RS. DELIMA ASIH"){
                    Intent intent = new Intent(HasilActivity.this, tampilRS.class);
                    intent.putExtra(KEY_NAME, kirim);
                    startActivity(intent);
                }

                if (kirim == "RS. DEWI SRI"){
                    Intent intent = new Intent(HasilActivity.this, tampilRS.class);
                    intent.putExtra(KEY_NAME, kirim);
                    startActivity(intent);
                }

                if (kirim == "RS. FIKRI MEDIKA"){
                    Intent intent = new Intent(HasilActivity.this, tampilRS.class);
                    intent.putExtra(KEY_NAME, kirim);
                    startActivity(intent);
                }

                if (kirim == "RS. ISLAM"){
                    Intent intent = new Intent(HasilActivity.this, tampilRS.class);
                    intent.putExtra(KEY_NAME, kirim);
                    startActivity(intent);
                }

                if (kirim == "RS. IZZA"){
                    Intent intent = new Intent(HasilActivity.this, tampilRS.class);
                    intent.putExtra(KEY_NAME, kirim);
                    startActivity(intent);
                }

                if (kirim == "RS. KARYA HUSADA"){
                    Intent intent = new Intent(HasilActivity.this, tampilRS.class);
                    intent.putExtra(KEY_NAME, kirim);
                    startActivity(intent);
                }

                if (kirim == "RS. LIRA MEDIKA"){
                    Intent intent = new Intent(HasilActivity.this, tampilRS.class);
                    intent.putExtra(KEY_NAME, kirim);
                    startActivity(intent);
                }

                if (kirim == "RS. MANDAYA"){
                    Intent intent = new Intent(HasilActivity.this, tampilRS.class);
                    intent.putExtra(KEY_NAME, kirim);
                    startActivity(intent);
                }
//
                if (kirim == "RS. PROKLAMASI"){
                    Intent intent = new Intent(HasilActivity.this, tampilRS.class);
                    intent.putExtra(KEY_NAME, kirim);
                    startActivity(intent);
                }
//
                if (kirim == "RS. PURI ASIH"){
                    Intent intent = new Intent(HasilActivity.this, tampilRS.class);
                    intent.putExtra(KEY_NAME, kirim);
                    startActivity(intent);
                }
//
                if (kirim == "RS. ROSELA"){
                    Intent intent = new Intent(HasilActivity.this, tampilRS.class);
                    intent.putExtra(KEY_NAME, kirim);
                    startActivity(intent);
                }
//
                if (kirim == "RS. SARASWATI"){
                    Intent intent = new Intent(HasilActivity.this, tampilRS.class);
                    intent.putExtra(KEY_NAME, kirim);
                    startActivity(intent);
                }
//
                if (kirim == "RS. PERSADA MEDIKA"){
                    Intent intent = new Intent(HasilActivity.this, tampilRS.class);
                    intent.putExtra(KEY_NAME, kirim);
                    startActivity(intent);
                }

                if (kirim == "RSUD. KARAWANG"){
                    Intent intent = new Intent(HasilActivity.this, tampilRS.class);
                    intent.putExtra(KEY_NAME, kirim);
                    startActivity(intent);
                }
            }
        });


    }




}
