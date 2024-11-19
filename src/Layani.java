import java.util.Scanner;

public class Layani {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Judul buku: ");
        String judul = scanner.nextLine();
        System.out.print("Penulis buku: ");
        String penulis = scanner.nextLine();
        System.out.print("Harga sewa buku per hari: ");
        int harga = scanner.nextInt();

        System.out.print("Jumlah hari peminjaman: ");
        int jmlHari = scanner.nextInt();

        System.out.print("Diskon (0 jika tidak ada): ");
        int nominalDiskon = scanner.nextInt();

        BukuSewa buku = new BukuSewa(judul, penulis, harga);
        DiskonSewa diskon = nominalDiskon > 0 ? new DiskonSewa(nominalDiskon) : null;
        Peminjaman peminjaman = new Peminjaman(buku, jmlHari, diskon);

        System.out.println("==== Informasi Peminjaman ====");
        System.out.println("Judul buku: " + judul);
        System.out.println("Penulis buku: " + penulis);
        System.out.println("Harga sewa buku per hari: " + harga);
        System.out.println("Jumlah hari peminjaman: " + jmlHari);
        System.out.println("Harga Total Tanpa Diskon: " + peminjaman.hitungHargaTotal());

        if (diskon != null) {
            System.out.println("Total Harga Setelah Diskon: " + peminjaman.hitungHargaSetelahDiskon());
        }
        System.out.println("========");
    }
}
