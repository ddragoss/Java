
public class Main {
    public static void main(String [] args){
        Fisier f1 = new Fisier();
        f1.setFisierIntrare("src/inregistrari.txt");
        f1.setFisierIesire("src/out.txt");
        String numeFisier = f1.getFisierIntrare();
        f1.citescFisier(numeFisier);
    }
}
