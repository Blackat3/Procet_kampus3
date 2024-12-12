 class Peminjaman {
     BukuSewa buku;
     int jumlahHari;
     DiskonSewa diskon;

    public Peminjaman(BukuSewa buku, int jumlahHari, DiskonSewa diskon) {
        this.buku = buku;
        this.jumlahHari = jumlahHari;
        this.diskon = diskon;
    }

    public int hitungHargaTotal() {
        return buku.getHargaSewaPerHari() * jumlahHari;
    }

    public int hitungHargaSetelahDiskon() {
        int hargaTotal = hitungHargaTotal();
        if (diskon != null) {
            return hargaTotal - diskon.getNominalDiskon();
        }
        return hargaTotal;
    }
}
