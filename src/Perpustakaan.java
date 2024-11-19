import java.util.Scanner;

class ItemSewa {
    protected int harga;

    public ItemSewa(int harga) {
        this.harga = harga;
    }

    public int getHarga() {
        return harga;
    }
}

class DiskonSewa {
    private int nominalDiskon;

    public DiskonSewa(int nominalDiskon) {
        this.nominalDiskon = nominalDiskon;
    }

    public int getNominalDiskon() {
        return nominalDiskon;
    }
}





