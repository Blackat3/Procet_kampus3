 class BukuSewa {
     String judul;
     String penulis;
     int hargaSewaPerHari;

    public BukuSewa(String judul, String penulis, int hargaSewaPerHari) {
        this.judul = judul;
        this.penulis = penulis;
        this.hargaSewaPerHari = hargaSewaPerHari;
    }

    public int getHargaSewaPerHari() {
        return hargaSewaPerHari;
    }
}

 class Cerpen extends BukuSewa {
     public Cerpen(String judul, String penulis, int hargaSewaPerHari) {
         super(judul, penulis, hargaSewaPerHari);
     }

     @Override
     public String toString() {
         return "Cerpen: " + judul + " ditulis oleh " + penulis;
     }
 }

 class Komik extends BukuSewa {
     public Komik(String judul, String penulis, int hargaSewaPerHari) {
         super(judul, penulis, hargaSewaPerHari);
     }

     @Override
     public String toString() {
         return "Komik: " + judul + " ditulis oleh " + penulis;
     }
 }

 class Ensiklopedia extends BukuSewa {
     public Ensiklopedia(String judul, String penulis, int hargaSewaPerHari) {
         super(judul, penulis, hargaSewaPerHari);
     }

     @Override
     public String toString() {
         return "Ensiklopedia: " + judul + " ditulis oleh " + penulis;
     }
 }