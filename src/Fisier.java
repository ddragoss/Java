import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Locale;
import java.util.Random;

public class Fisier {
  private String fisierIesire;
  private String fisierIntrare;

    public String getFisierIesire() {
        return fisierIesire;
    }

    public String getFisierIntrare() {
        return fisierIntrare;
    }

    public void setFisierIesire(String fisierIesire) {
        this.fisierIesire = fisierIesire;
    }

    public void setFisierIntrare(String fisierIntrare) {
        this.fisierIntrare = fisierIntrare;
    }

    public   void citescFisier(String fisierIntrare, Persoana persoana){

        try (BufferedReader br = new BufferedReader(new FileReader(fisierIntrare))) {
            // pot trata direct in blocul try doar resursele care implementeaza inteftata close
            String linie = null;
            while ((linie = br.readLine()) != null) {
                //System.out.println(linie);

                String[] date =  linie.split("\\|");

                if(date.length==3){
                    String nr_crt = date[0];
                    String nume =date[1];
                    String cnp = date[2];

                    //System.out.println(nume);

                   String numeNou = schimbaNume(nume);
                   String cnpAnNou = schimbaCNP(cnp);
                   System.out.println(cnp.length());
                   //System.out.println("CNP vechi: "+ cnp +"CNP nou: "+cnpAnNou);

                 //  System.out.println(numeNou);
                //    System.out.println(cnp);
//                    scriuInFisier(nr_crt,numeNou,cnp);

                }else{
                    System.out.println("Format incorect linie!!"+linie);
                }

            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    private void scriuInFisier(String nrCrt, String nume, String cnp){
        try(PrintStream out = new PrintStream(fisierIntrare)){
            out.println(nrCrt+"|"+nume+"|"+cnp);

        }catch (IOException e){
            System.out.println(e.getMessage());
        }
    }

    private String schimbaNume(String nume){
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


