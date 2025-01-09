class PeminjamMember extends Peminjam {
    private int diskonPersen;

    public PeminjamMember(String nama, int diskonPersen) {
        super(nama);
        this.diskonPersen = diskonPersen;
    }

    public int getDiskonPersen() {
        return diskonPersen;
    }
}
