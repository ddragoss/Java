public class Persoana {
    private int id;
    private String nume;

    private ActIdentitate buletin;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public String getCnp() {
        return buletin.getCnp();
    }

    public void setBuletin(ActIdentitate buletin) {
        this.buletin = buletin;
    }

    public String getAn() {
        String prefixAn = null;
        String an = null;
        an = this.getCnp().substring(1, 3);

        int anInteger = Integer.parseInt(an);

        if (anInteger <= 99) {
            prefixAn = "19";
        } else {
            prefixAn = "20";
        }
        // String anComplet  = prefixAn+an;
        return prefixAn + an;

    }

    public String getLuna() {

        String luna = this.getCnp().substring(3, 5);
        return luna;
    }

    public String getZi() {
        String zi = this.getCnp().substring(6, 8);
        return zi;
    }
    //1930830

    public String getSexx() {
        int cifra = this.getCnp().charAt(0); // returneaza caraterul de la pozitia 0 si pt ca am pus int in fata il face integer si e in ASCII
        if (cifra == 48 || cifra == 57) return "Nespecificat!";
        if (cifra % 2 != 0) return "Masculin";
        return "Feminin";

    }

    public String getDetaliiPersona() {
        return "Persoana: " + "\n\n" +
                "Nume: " + getNume() + "\n" +
                "sex: " + getSexx() + "\n" +
                "data_nasterii: " + getZi() + "/" + getLuna() + "/" + getAn() + "\n\n" +

                "Act Identitate: " + "\n" +
                "cnp: " + getCnp() + "\n" +
                "serie: " + buletin.getSerie() + "\n" +
                "numar: " + buletin.getNumar();

    }

    public String getDetaliiPersonaa() {
        return String.format("Persona:\n\nNume: %s\nGen: %s\nData Nasterii: %s\n\nAct Identitate: \n\nCNP: %s\nSerie: %s\nNumar: %s\n",getNume(),getSexx(),(getZi() + "/" + getLuna() + "/" + getAn()),getCnp(),buletin.getSerie(),buletin.getNumar());
        // %s este placeholder
    }


    public String getLinieFisier() {
        return String.format("%s|%s|%s|%s|%s", id, nume,getCnp(),buletin.getSerie(), buletin.getNumar());
    }
}
