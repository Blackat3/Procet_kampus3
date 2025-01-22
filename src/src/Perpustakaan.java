import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;


public class Perpustakaan {
    private static ArrayList<Buku> daftarBuku = new ArrayList<>();
    private static ArrayList<Peminjaman> daftarPeminjaman = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean ulang = true;

        while (ulang) {
            try {
                System.out.println("=== Menu ===");
                System.out.println("1. Memasukkan data buku");
                System.out.println("2. Peminjaman");
                System.out.println("3. Tampilkan data buku");
                System.out.println("4. Tampilkan data peminjaman");
                System.out.println("5. Keluar");
                System.out.print("Pilihan: ");
                int pilihan = scanner.nextInt();
                scanner.nextLine();

                switch (pilihan) {
                    case 1:
                        System.out.print("Masukkan ID buku: ");
                        String id = scanner.nextLine();
                        System.out.print("Masukkan judul buku: ");
                        String judul = scanner.nextLine();
                        System.out.print("Masukkan penulis buku: ");
                        String penulis = scanner.nextLine();
                        System.out.print("Masukkan harga sewa per hari: ");
                        int hargaSewa = scanner.nextInt();

                        daftarBuku.add(new Buku(id, judul, penulis, hargaSewa));
                        System.out.println("Buku berhasil ditambahkan.\n");
                        break;

                    case 2:
                        if (daftarBuku.isEmpty()) {
                            System.out.println("Tidak ada buku yang tersedia untuk dipinjam.\n");
                            break;
                        }

                        System.out.println("Pilih jenis peminjam:");
                        System.out.println("1. Non-Member");
                        System.out.println("2. Member");
                        System.out.print("Pilihan: ");
                        int jenisPeminjam = scanner.nextInt();
                        scanner.nextLine();

                        if (jenisPeminjam < 1 || jenisPeminjam > 2) {
                            throw new IllegalArgumentException("Pilihan jenis peminjam tidak valid.");
                        }

                        System.out.print("Masukkan nama peminjam: ");
                        String nama = scanner.nextLine();

                        Buku bukuDipilih = null;
                        while (bukuDipilih == null) {
                            System.out.print("Masukkan nama buku yang ingin dipinjam: ");
                            String namaBuku = scanner.nextLine();

                            System.out.print("Masukkan ID buku: ");
                            String idBuku = scanner.nextLine();

                            for (Buku buku : daftarBuku) {
                                if (buku.getId().equalsIgnoreCase(idBuku) && buku.getJudul().equalsIgnoreCase(namaBuku)) {
                                    bukuDipilih = buku;
                                    break;
                                }
                            }

                            if (bukuDipilih == null) {
                                System.out.println("Nama atau ID buku tidak sesuai. Silakan masukkan ulang.");
                            }
                        }

                        System.out.print("Masukkan jumlah hari peminjaman: ");
                        int jumlahHari = scanner.nextInt();

                        if (jumlahHari <= 0) {
                            throw new IllegalArgumentException("Jumlah hari peminjaman harus lebih dari 0.");
                        }

                        Peminjam peminjam;
                        if (jenisPeminjam == 2) {
                            System.out.print("Masukkan diskon untuk member: ");
                            float diskonPersen = scanner.nextFloat();

                            if (diskonPersen < 0 || diskonPersen > 100) {
                                throw new IllegalArgumentException("Diskon harus antara 0 hingga 100.");
                            }

                            peminjam = new PeminjamMember(nama, diskonPersen);
                        } else {
                            peminjam = new Peminjam(nama);
                        }

                        Peminjaman peminjaman = new Peminjaman(bukuDipilih, jumlahHari, peminjam);
                        daftarPeminjaman.add(peminjaman);

                        System.out.println("\n=== Rincian Peminjaman ===");
                        System.out.println("Nama Peminjam: " + peminjam.getNama());
                        System.out.println("Judul Buku: " + bukuDipilih.getJudul());
                        System.out.println("Harga Total: Rp " + peminjaman.hitungHargaTotal());

                        if (peminjam instanceof PeminjamMember) {
                            System.out.println("Harga Setelah Diskon: Rp " + peminjaman.hitungHargaSetelahDiskon());
                        }

                        break;

                    case 3:
                        if (daftarBuku.isEmpty()) {
                            System.out.println("Tidak ada buku yang tersedia.\n");
                        } else {
                            System.out.println("\n=== Daftar Buku ===");
                            for (Buku buku : daftarBuku) {
                                System.out.printf("- ID: %s, Judul Buku: %s, penulis: %s, Harga: %d/hari\n", buku.getId(), buku.getJudul(), buku.getPenulis(), buku.getHargaSewaPerHari());
                            }
                            System.out.println();
                        }
                        break;

                    case 4:
                        if (daftarPeminjaman.isEmpty()) {
                            System.out.println("Tidak ada data peminjaman.\n");
                        } else {
                            System.out.println("\n=== Daftar Peminjaman ===");
                            int no = 1;
                            for (Peminjaman datapeminjaman : daftarPeminjaman) {
                                System.out.printf("%d. Nama Peminjam: %s\n", no++, datapeminjaman.getPeminjam().getNama());
                                System.out.printf("   ID Buku: %s\n", datapeminjaman.getBuku().getId());
                                System.out.printf("   Judul Buku: %s\n", datapeminjaman.getBuku().getJudul());
                                System.out.printf("   Harga Total: Rp %d\n", datapeminjaman.hitungHargaTotal());
                            }
                            System.out.println();
                        }
                        break;

                    case 5:
                        ulang = false;
                        break;

                    default:
                        System.out.println("Pilihan tidak valid.\n");
                }
            } catch (InputMismatchException e) {
                System.out.println("Input tidak valid. Harap masukkan angka.");
                scanner.nextLine();
            } catch (IllegalArgumentException e) {
                System.out.println("Error: " + e.getMessage());
            } catch (Exception e) {
                System.out.println("Terjadi kesalahan: " + e.getMessage());
            } finally {
                System.out.println();
            }
        }
        System.out.println("Terima kasih telah menggunakan layanan kami.");
        scanner.close();
    }
}