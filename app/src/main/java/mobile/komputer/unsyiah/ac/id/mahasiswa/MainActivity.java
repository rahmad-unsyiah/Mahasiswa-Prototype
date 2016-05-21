package mobile.komputer.unsyiah.ac.id.mahasiswa;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Buat listener untuk click salah satu item di list
        AdapterView.OnItemClickListener itemClickListener =
                new AdapterView.OnItemClickListener() {
                    public void onItemClick(AdapterView<?> listView, // Dari list yang mana
                                            View view,               // Dari view mana dalam Item,
                                                                     // karena satu item bisa
                                                                     // terdiri dari banyak jenis
                                                                     // elemen lain, e.g. gambar,
                                                                     // text, dll.
                                            int nomorBerapa,         // Item nomor berapa yang
                                                                     // di-click, mulai dari 0
                                            long id) {               // ID dari elemen yang di-click
                        clickItemLstDaftarMahasiswa(listView, view, nomorBerapa, id);
                    }
                };
        // Tetapkan listerner jika click pada salah satu item di list
        ListView lstDaftarAnggota = (ListView) findViewById(R.id.lstDaftarMahasiswa);
        lstDaftarAnggota.setOnItemClickListener(itemClickListener);
    }

    /**
     * Tangani jika tombol btnTambah di-click
     */
    public void clickBtnTambah(View view) {
        // Kirim ke TambahActivity
        Intent pesan = new Intent(getApplicationContext(), TambahActivity.class);
        startActivity(pesan);
    }

    /**
     * Tangani salah satu item di list di-click
     */
    public void clickItemLstDaftarMahasiswa(AdapterView<?> listView,
                                            View v,
                                            int position,
                                            long id) {
        // Kirim ke RincianActivity
        Intent pesan = new Intent(getApplicationContext(), RincianActivity.class);
        pesan.putExtra("id", (long) position); // Kirim id mahasiswa
        pesan.putExtra("nim", "NIM 123");      // Kirim nim mahasiswa
        pesan.putExtra("nama", "NAMA 123");    // Kirim nama mahasiswa
        startActivity(pesan);
   }
}