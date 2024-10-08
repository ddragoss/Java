import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintStream;
import java.net.Inet4Address;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Random;

public class Fisier {
  private static String fisierIesire;
  private static String fisierIntrare;

  private Persoana persoana;
  private ActIdentitate buletin;





    public static List<Persoana> citescFisier(String fisierIntrare){
        List<Persoana> listaPersone = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(fisierIntrare))) {
            // pot trata direct in blocul try doar resursele care implementeaza inteftata close
            String linie = null;
            ActIdentitate a1 ;
            Persoana p1 ;
            while ((linie = br.readLine()) != null) {
                //System.out.println(linie);

                String[] date =  linie.split("\\|");

                if(date.length==5){
                    String nr_crt = date[0];
                    String nume =date[1];

                    String cnp = date[2];
                    String serie = date[3];
                    String numar = date[4];
                    a1 =  new ActIdentitate(cnp,serie,numar);
                    p1 = new Persoana();
                    p1.setBuletin(a1);
                    p1.setNume(nume);
                    p1.setId(Integer.parseInt(nr_crt));
                    listaPersone.add(p1);
                }else{
                    System.out.println("Format incorect linie!!"+linie);
                }
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return listaPersone;
    }

    public static void scriuInFisier(List<Persoana> listaPersoane, String fisierIesire){
        try(PrintStream out = new PrintStream(fisierIesire)){
          listaPersoane.forEach(p1 -> out.println(p1.getLinieFisier()));

        }catch (IOException e){
            System.out.println(e.getMessage());
        }
    }

    public static String schimbaNume(String nume){
        String[] arrNume = nume.split(" ");
        StringBuilder numeSchimbat = new StringBuilder();
        for(String eachNume : arrNume){
            if(eachNume.length()>0){
                numeSchimbat.append(eachNume.substring(0,1).toUpperCase())
                        .append(eachNume.substring(1).toLowerCase())
                        .append(" ");
            }
        }
        return numeSchimbat.toString().trim();
    }

    private String schimbaCNP(String cnp){
        Random r =  new Random();
        int anSchimbat = r.nextInt(100);
        StringBuilder cnpNou = new StringBuilder();
        if(cnp.length()==13){
     //       cnpNou.append(cnp.substring(1,2)==anSchimbat)
            cnpNou.replace(1,3, String.format("%12d", anSchimbat));
        }else{
            System.out.println("CNP-ul are lugimea incorecta!!");
        }
         return cnpNou.toString();

    }

    private String ajusteazaCNP(String cnp){
        int cifreLipsa = 13 - cnp.length();
        Random r =  new Random();
        int cifreRand = r.nextInt(100);
        //StringBuilder cnpAjustat =  new StringBuilder();
        String cnpNou;
        cnpNou = cnp + cifreRand;
        return cnpNou;


    }

    public static void main(String [] args){
        Fisier f1 =  new Fisier();
        System.out.println(f1.ajusteazaCNP("1233425342"));

    }


//    private boolean valideazaCNP(String cnp){
//        if (cnp!=null || cnp.length()!=13){
//            return false;
//        }else{
//
//
//        }
//
//
//        return true;
//    }
//
//    private String corecteazaCifraC(String cnp){
//
//        StringBuilder cnpCorect = new StringBuilder();
//
//        return cnpCorect;
//    }


}


