package mobile.komputer.unsyiah.ac.id.mahasiswa;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class RincianActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rincian);

        // Ambil data ID yang dikirim dan tampilkan
        Intent pesan = getIntent();
        // Ambil data ID yang dikirim dan tampilkan
        long id = pesan.getLongExtra("id", 0);
        TextView txtId = (TextView) findViewById(R.id.txtId);
        txtId.setText(Long.toString(id));
        // Ambil data NIM yang dikirim dan tampilkan
        String nim = pesan.getStringExtra("nim");
        EditText txtNim = (EditText) findViewById(R.id.txtNIM);
        txtNim.setText(nim);
        // Ambil data Nama yang dikirim dan tampilkan
        String nama = pesan.getStringExtra("nama");
        EditText txtNama = (EditText) findViewById(R.id.txtNama);
        txtNama.setText(nama);
    }

    /**
     * Tangani jika tombol btnUbah di-click. Tampilan akan diubah dimana semua EditText menjadi bisa
     * diedit, tombol Hapus hilang, tombol ubah hilang, dan tombol simpan muncul.
     */
    public void clickBtnUbah(View view) {
        // Hidupkan EditText untuk NIM sehingga bisa di-edit
        EditText txtNim = (EditText) findViewById(R.id.txtNIM);
        txtNim.setEnabled(true);
        // Hidupkan EditText untuk Nama sehingga bisa di-edit
        EditText txtNama = (EditText) findViewById(R.id.txtNama);
        txtNama.setEnabled(true);

        // Hilangkan tombol Hapus
        Button btnHapus = (Button) findViewById(R.id.btnHapus);
        btnHapus.setVisibility(View.GONE);
        // Hilangkan tombol Ubah
        Button btnUbah = (Button) findViewById(R.id.btnUbah);
        btnUbah.setVisibility(View.GONE);
        // Tampilkan tombol Simpan, untuk menyimpan perubahan
        Button btnSimpan = (Button) findViewById(R.id.btnSimpan);
        btnSimpan.setVisibility(View.VISIBLE);
    }

    /**
     * Tangani jika tombol btnHapus di-click
     */
    public void clickBtnHapus(View view) {
        // Tampilkan DialogBox menanyakan apa benar mau dihapus
        new AlertDialog.Builder(this)
                       // Judul dialog box
                       .setTitle("Hapus?")
                       // Pesan dalam dialog box
                       .setMessage("Yakin ingin menghapus mahasiswa ini?")
                       // Tombol untuk Ya akan dihapus
                       .setPositiveButton("Ya", // Tulisan pada tombol
                                          // Listener untuk tangani penekanan tombol ini
                                          new DialogInterface.OnClickListener() {
                                              public void onClick(DialogInterface dialog,
                                                                  int which) {
                                                  clickBtnYaHapus(dialog, which);
                                              }
                                          })
                       .setNegativeButton("Tidak", // Tulisan pada tombol
                                          // Listener untuk tangani penekanan tombol ini
                                          new DialogInterface.OnClickListener() {
                                              public void onClick(DialogInterface dialog,
                                                                  int which) {
                                                  // Tidak melakukan apapun
                                              }
                                          })
                       // Muncul Icon hati-hati pada dialog box
                       .setIcon(android.R.drawable.ic_dialog_alert)
                       // Tampilkan dialog box
                       .show();
    }

    /**
     * Tangani jika tombol btnSimpan di-click
     */
    public void clickBtnSimpan(View view) {
        // Disini proses penyimpanan perubahan

        // Kembali ke Activity MainActivity
        Intent pesan = new Intent(getApplicationContext(), MainActivity.class);
        startActivity(pesan);
        finish();
    }

    /**
     * Tangani jika tombol Ya pada dialog box konfirmasi hapus data di-click
     */
    public void clickBtnYaHapus(DialogInterface dialog,
                                int which) {
        // Isi proses hapus disini

        // Kembali ke Activity MainActivity
        Intent pesan = new Intent(getApplicationContext(),
                MainActivity.class);
        startActivity(pesan);
        finish();
    }
}
