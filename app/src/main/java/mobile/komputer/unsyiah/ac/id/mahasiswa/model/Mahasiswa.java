package mobile.komputer.unsyiah.ac.id.mahasiswa.model;

public class Mahasiswa {
    public Mahasiswa() {
        this.nim = "";
        this.nama = "";
    }

    public Mahasiswa(String nim, String nama) {
        this.nim = nim;
        this.nama = nama;
    }

    private String nim;
    public void setNim(String nim) {
        this.nim = nim;
    }
    public String getNim() {
        return this.nim;
    }

    private String nama;
    public void setNama(String nama) {
        this.nama = nama;
    }
    public String getNama() {
        return this.nama;
    }
}
