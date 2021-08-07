package Kap2;

import javax.json.bind.annotation.JsonbPropertyOrder;

@JsonbPropertyOrder({"posnr", "menge", "artikel"})
public class Bestellposition {
    private int posnr;
    private int menge;
    private Artikel artikel;

    public Bestellposition() {
    }

    public Bestellposition(int posnr, int menge) {
        this.posnr = posnr;
        this.menge = menge;

    }

    public int getPosnr() {
        return posnr;
    }

    public void setPosnr(int posnr) {
        this.posnr = posnr;
    }

    public int getMenge() {
        return menge;
    }

    public void setMenge(int menge) {
        this.menge = menge;
    }

    public Artikel getArtikel() {
        return artikel;
    }

    public void setArtikel(Artikel artikel) {
        this.artikel = artikel;
    }

    @Override
    public String toString() {
        return "Bestellposition{" +
                "posnr=" + posnr +
                ", menge=" + menge +
                ", artikel=" + artikel +
                '}';
    }
}
