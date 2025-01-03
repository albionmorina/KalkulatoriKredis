/*
 * Detyra (a)
 * Pagesa vjetore per "shumen fillestare te kredise" ->(double p)
 * Me norme vjetore interesi(double i)
 * Per nje kohezgjatje prej "y" vite (int y)
 */

/*
 * Detyra (b)
 * Te llogaritet shuma e borxhit te mbetur ne nje kredi pas "n" viteve duke perdorur formulen e re
 * funksioni "llogaritBorxhinMbetur" merr si hyrje (principalin, interesin, vitet, viti, pagesenvjetore)
 * principali -> Shuma fillestare e kredise (ne shembullin tone "100,000")
 * interesi -> interesi i kredise
 * vitet -> Perfaqeson kohezgjatjen totale te kredise ne vite (ne shembullin tone "10" vite)
 * viti -> Përfaqëson vitin specifik për të cilin po llogaritet borxhi i mbetur.
 * Pagesa vjetore caktohet nga Detyra (a)
 */

 import java.text.DecimalFormat;

 public class KalkulatoriKredise {
     
     // Zgjidhja e Detyres (a) Metoda per te logaritur pagesen vjetore
     public static double llogaritPagesenVjetore(double p, double i, int y) {
         double faktori = Math.pow(1 + i, y); // (1 + i)^y
         return (faktori * p * i) / (faktori - 1);
     }
 
     // Zgidhja e Detyres (b) Metoda per te llogaritur borxhin e mbetur duke perdorur formulen 'deptAfterNyears'
     public static double llogaritBorxhinMbetur(double p, double i, int y, int n, double pagesa) {
         double z = 1 + i; // z = 1 + i
         double faktoriN = Math.pow(z, n); // (1 + i)^n
         return (p * faktoriN) - (pagesa * (faktoriN - 1) / (z - 1));
     }
 
     public static void main(String[] args) {
         // Vlerat hyrese
         double shumaKredise = 100000; // Shuma totale e kredise (p.sh., 100,000 euro)
         double normaInteresit = 0.05; // Norma vjetore e interesit (p.sh., 5%)
         int vitet = 10; // Kohezgjatja e kredise ne vite
 
         // Llogarit kestin vjetor
         double pagesaVjetore = llogaritPagesenVjetore(shumaKredise, normaInteresit, vitet);
         DecimalFormat formatter = new DecimalFormat("0.00");
         System.out.println("Pagesa vjetore: " + formatter.format(pagesaVjetore) + " EUR");
          // System.out.printf("Pagesa vjetore: %.2f EUR%n", pagesaVjetore); // %.2f(dmth nr. shfaqet me dy shifra pas presjes dhjetore)
 
         // Shtyp borxhin e mbetur per vitet prej 0 deri ne 5
         System.out.println("Borxhi i mbetur per vitet 0 deri ne 5:");
         for (int viti = 0; viti <= 5; viti++) {
             double borxhiMbetur = llogaritBorxhinMbetur(shumaKredise, normaInteresit, vitet, viti, pagesaVjetore);
             System.out.println("Viti " + viti + ": " + formatter.format(borxhiMbetur) + " EUR");
            // System.out.printf("Viti %d: %.2f EUR%n", viti, borxhiMbetur);
         }
     }
 }
 
