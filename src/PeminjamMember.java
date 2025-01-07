class PeminjamMember extends Peminjam {
    private static final int DISKON_PERSEN = 5;

    public PeminjamMember(String nama) {
        super(nama);
    }

    public int getDiskonPersen() {
        return DISKON_PERSEN;
    }
}