public class ActIdentitate {
    private String cnp;
    private String serie;
    private String numar;

    public ActIdentitate(String cnp, String serie, String numar) {
        this.cnp = cnp;
        this.serie = serie;
        this.numar = numar;
    }

    public String getCnp() {
        return cnp;
    }
    public String getNumar() {
        return numar;
    }
    public String getSerie() {
        return serie;
    }
    public void setNumar(String numar) {
        this.numar = numar;
    }

    public void setSerie(String serie) {
        this.serie = serie;
    }
}
