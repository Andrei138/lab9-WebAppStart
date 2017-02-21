package my.apps.web;

/**
 * Created by dell on 21-Feb-17.
 */
public class Article {
     private String Produs;
     private String Cantitate;


             public Article(String Produs, String Cantitate) {
                this.Produs = Produs;
                this.Cantitate = Cantitate;
             }

             public String getProdus() {
              return Produs;
           }

             public String getCantitate() {
                return Cantitate;
            }



             @Override
     public String toString() {
                return "Article{" +
                                "Produs='" + Produs + '\'' +
                                ", Cantitate='" + Cantitate + '\'' +
                                '}';
            }
}
