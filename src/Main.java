import java.util.List;

public class Main {
    public static void main(String [] args){
//        Fisier f1 = new Fisier();

        String numeFisierIntrare = "src/inregistrari.txt";
      //  f1.citescFisier(numeFisier);
        List<Persoana> listaPersoane = Fisier.citescFisier(numeFisierIntrare);
        String fisierIesire = "src/out.txt";
        System.out.println(listaPersoane.size());
        //ActIdentitate a1 = new ActIdentitate("1930830152485","dd", "443245");

       // Persoana p1 = new Persoana();
        //p1.setBuletin(a1);
       // p1.setNume("Dragos Samoila");
        //p1.getCnp();
       //System.out.println(p1.getCnp());
//        listaPersoane.forEach(persoana ->persoana.setNume(Fisier.schimbaNume(persoana.getNume())));

//        listaPersoane.forEach(persoana -> System.out.println(persoana.getDetaliiPersona()));
        for(int i = 0; i<listaPersoane.size(); i++){
            listaPersoane.get(i).setNume(Fisier.schimbaNume(listaPersoane.get(i).getNume()));
        }
        Fisier.scriuInFisier(listaPersoane,fisierIesire);

        String a1 = "11";
        String prefix = "20";
        int an = Integer.parseInt(a1);
        System.out.println(prefix+a1);


    }
}
