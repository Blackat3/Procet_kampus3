class Buku {
    private String judul;
    private String penulis;
    private int hargaSewaPerHari;

    public Buku(String judul, String penulis, int hargaSewaPerHari) {
        this.judul = judul;
        this.penulis = penulis;
        this.hargaSewaPerHari = hargaSewaPerHari;
    }

    public int getHargaSewaPerHari() {
        return hargaSewaPerHari;
    }

    public String getJudul() {
        return judul;
    }

    public String getPenulis() {
        return penulis;
    }
}