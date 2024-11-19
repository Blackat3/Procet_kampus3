 class BukuSewa {
    private String judul;
    private String penulis;
    private int hargaSewaPerHari;

    public BukuSewa(String judul, String penulis, int hargaSewaPerHari) {
        this.judul = judul;
        this.penulis = penulis;
        this.hargaSewaPerHari = hargaSewaPerHari;
    }

    public int getHargaSewaPerHari() {
        return hargaSewaPerHari;
    }
}
