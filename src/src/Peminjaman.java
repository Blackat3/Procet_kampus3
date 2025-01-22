class Peminjaman {
    private Buku buku;
    private int jumlahHari;
    private Peminjam peminjam;

    public Peminjaman(Buku buku, int jumlahHari, Peminjam peminjam) {
        this.buku = buku;
        this.jumlahHari = jumlahHari;
        this.peminjam = peminjam;
    }

    public int hitungHargaTotal() {
        return buku.getHargaSewaPerHari() * jumlahHari;
    }

    public int hitungHargaSetelahDiskon() {
        if (peminjam instanceof PeminjamMember) {
            PeminjamMember member = (PeminjamMember) peminjam;
            return (int) (hitungHargaTotal() * (1 - member.getDiskonPersen() / 100.0));
        }
        return hitungHargaTotal();
    }

    public Buku getBuku() {
        return buku;
    }

    public Peminjam getPeminjam() {
        return peminjam;
    }

    public int getJumlahHari() {
        return jumlahHari;
    }
}