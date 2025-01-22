class PeminjamMember extends Peminjam {
    private float diskonPersen;

    public PeminjamMember(String nama, float diskonPersen) {
        super(nama);
        this.diskonPersen = diskonPersen;
    }

    public float getDiskonPersen() {
        return diskonPersen;
    }
}