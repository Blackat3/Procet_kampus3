import java.util.Scanner;


public class Layani {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Buku buku1 = new Buku("Pemrograman Java", "Andi", 2000);
        Buku buku2 = new Buku("Algoritma dan Struktur Data", "Budi", 3000);

        System.out.println("Pilih jenis peminjam:");
        System.out.println("1. Non-Member");
        System.out.println("2. Member");
        System.out.print("Pilihan: ");
        int pilihan = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        System.out.print("Masukkan nama peminjam: ");
        String nama = scanner.nextLine();

        Peminjam peminjam;
        if (pilihan == 2) {
            peminjam = new PeminjamMember(nama);
        } else {
            peminjam = new Peminjam(nama);
        }

        System.out.println("Pilih buku:");
        System.out.println("1. " + buku1.getJudul() + " oleh " + buku1.getPenulis() + " (" + buku1.getHargaSewaPerHari() + "/hari)");
        System.out.println("2. " + buku2.getJudul() + " oleh " + buku2.getPenulis() + " (" + buku2.getHargaSewaPerHari() + "/hari)");
        System.out.print("Pilihan: ");
        int pilihanBuku = scanner.nextInt();

        Buku bukuDipilih = (pilihanBuku == 1) ? buku1 : buku2;

        System.out.print("Masukkan jumlah hari peminjaman: ");
        int jumlahHari = scanner.nextInt();

        Peminjaman peminjaman = new Peminjaman(bukuDipilih, jumlahHari);

        System.out.println("\n=== Rincian Peminjaman ===");
        System.out.println("Nama Peminjam: " + peminjam.getNama());
        System.out.println("Judul Buku: " + bukuDipilih.getJudul());
        System.out.println("Harga Total: Rp " + peminjaman.hitungHargaTotal());

        if (peminjam instanceof PeminjamMember) {
            System.out.println("Harga Setelah Diskon: Rp " + peminjaman.hitungHargaSetelahDiskon(peminjam));
        }

        scanner.close();
    }
}

