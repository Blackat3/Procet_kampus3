class Buku {
    private String id;
    private String judul;
    private String penulis;
    private int hargaSewaPerHari;

    public Buku(String id, String judul, String penulis, int hargaSewaPerHari) {
        this.id = id;
        this.judul = judul;
        this.penulis = penulis;
        this.hargaSewaPerHari = hargaSewaPerHari;
    }

    public String getId() {
        return id;
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
