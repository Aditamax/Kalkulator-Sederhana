//Mendefinisikan package tempat kelas MainActivity berada
package com.example.kalkulatorsederhana;

//Mengimpor kelas-kelas yang diperlukan dari paket Android untuk digunakan
//dalam program, seperti Bundle, View, Button, EditText, TextView, dan AppCompatActivity.
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

//Mendeklarasikan kelas MainActivity, yang merupakan kelas utama yang mewarisi AppCompatActivity.
public class MainActivity extends AppCompatActivity {

    //Mendeklarasikan variabel untuk elemen-elemen antarmuka pengguna seperti EditText, Button, dan TextView.
    EditText editTextNumber, editTextNumber2;
    Button buttonTambah, buttonKurang, buttonKali, buttonBagi;
    TextView textViewHasil;

    //Metode yang dipanggil ketika aktivitas dibuat.
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //Menetapkan layout XML yang akan digunakan untuk tata letak aktivitas.
        setContentView(R.layout.activity_main);

        //Menginisialisasi variabel dengan referensi ke elemen-elemen yang sesuai dalam layout XML.
        editTextNumber  = findViewById(R.id.editTextNumber);
        editTextNumber2 = findViewById(R.id.editTextNumber2);
        buttonTambah = findViewById(R.id.button);
        buttonKurang = findViewById(R.id.button2);
        buttonKali = findViewById(R.id.button3);
        buttonBagi = findViewById(R.id.button4);
        textViewHasil = findViewById(R.id.hasil);

        //Menetapkan listener klik untuk masing-masing tombol operasi, yang akan
        //memanggil metode hitung() dengan operator yang sesuai.
        buttonTambah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                hitung('+');
            }
        });

        buttonKurang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                hitung('-');
            }
        });

        buttonKali.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                hitung('*');
            }
        });

        buttonBagi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                hitung('/');
            }
        });
    }

    //Metode yang melakukan perhitungan matematika sesuai dengan operator yang diberikan.
    //Mengubah teks dari EditText menjadi bilangan desimal.
    private void hitung(char operator) {
        double bil1 = Double.parseDouble(editTextNumber.getText().toString());
        double bil2 = Double.parseDouble(editTextNumber2.getText().toString());
        double hasil = 0;

        //Melakukan operasi matematika sesuai dengan operator yang diberikan.
        switch (operator) {
            case '+':
                hasil = bil1 + bil2;
                break;
            case '-':
                hasil = bil1 - bil2;
                break;
            case '*':
                hasil = bil1 * bil2;
                break;
            case '/':
                if (bil2 != 0) {
                    hasil = bil1 / bil2;
                } else {
                    //Menetapkan hasil perhitungan ke TextView
                    textViewHasil.setText("Tidak dapat melakukan pembagian dengan nol");
                    return;
                }
                break;
        }

        textViewHasil.setText("Hasil perhitungan: " + hasil);
    }
}
