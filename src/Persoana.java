public class Persoana {
    private int id;
    private String nume;
    private String cnp;


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
        return cnp;
    }

    public void setCnp(String cnp) {
        this.cnp = cnp;
    }


    public String getAn(){
        String prefixAn = null;
        String an = null;
        an = this.cnp.substring(2,2);

        int anInteger = Integer.parseInt(an);
        if(anInteger<20){
            prefixAn = "19";
        }else{
            prefixAn = "20";
        }
        String anComplet  = prefixAn+an;
        return  anComplet;

    }

    public String getSex() throws IllegalAccessException {
        String sex = null;
        sex = this.cnp.substring(1,1);
        String tipSex = null;

        switch(sex){
            case "1" :
                tipSex = "Masculin";
                break;
            case "2":
                tipSex = "Feminin";
                break;
            default:
                throw new IllegalAccessException("Sexul dincnp este gresit!");

        }
        return tipSex;

    }


}
