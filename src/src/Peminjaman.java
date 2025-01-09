class Peminjaman {
    private Buku buku;
    private int jumlahHari;

    public Peminjaman(Buku buku, int jumlahHari) {
        this.buku = buku;
        this.jumlahHari = jumlahHari;
    }

    public int hitungHargaTotal() {
        return buku.getHargaSewaPerHari() * jumlahHari;
    }

    public int hitungHargaSetelahDiskon(Peminjam peminjam) {
        int hargaTotal = hitungHargaTotal();

        if (peminjam instanceof PeminjamMember) {
            PeminjamMember member = (PeminjamMember) peminjam;
            return (int) (hargaTotal * (1 - member.getDiskonPersen() / 100.0));
        }

        return hargaTotal;
    }

    public Buku getBuku() {
        return buku;
    }

    public int getJumlahHari() {
        return jumlahHari;
    }
}
