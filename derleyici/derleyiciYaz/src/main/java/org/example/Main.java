package org.example;
import  java.util.Scanner;
public class Main {
    public void commentFindLine(String ifade) {
        // Verilen ifadede yorum satırı olup olmadığını kontrol eder
        boolean yorumSatiri = false;
        char[] dizi = ifade.toCharArray(); //ifadeyi char dizisi haline getiriyoruz

        // İfadeyi karakter dizisine dönüştürür ve yorum satırı olup olmadığını kontrol eder
        for (int i = 0; i < dizi.length - 1; i++) {

            if (dizi[i] == '/' && dizi[i + 1] == '/') {//kullanıcan alınan ifade içinde java dilinde yorum satırı için kullanılan sembolleri içerme durumunu kontrol ediyoruz
                yorumSatiri = true;
                break;
            } else if (dizi[i] == '/' && dizi[i + 1] == '*') {//kullanıcan alınan ifade içinde java dilinde yorum satırı için kullanılan sembolleri içerme durumunu kontrol ediyoruz
                // İfadeyi yorum bloğu olarak kontrol eder
                for (int j = i + 2; j < dizi.length - 1; j++) {
                    if (dizi[j] == '*' && dizi[j + 1] == '/') {//kullanıcan alınan ifade içinde java dilinde yorum satırı için kullanılan sembolleri içerme durumunu kontrol ediyoruz
                        yorumSatiri = true;
                        break;
                    }
                }
                break;
            }
        }

        // Sonuçları ekrana yazdırır
        if (yorumSatiri) {
            System.out.println("Bu bir yorum satırıdır.");
        } else {
            System.out.println("Bu bir yorum satırı değildir.");
        }

    }
    public void mathematicalExpression(String ifade) {

        int deger = 0;

        // matematiksel ifadeleri işle
        if (ifade.indexOf("-") != -1) { //kullanıcıdan alınan ifade de yapılmak istenen işlemin matematiksel sembolüne bakıyoruz.
            String[] matematikselIfade = ifade.split("-");//matamatiksel sembole göre ifadeyi bölüp diziye atıyoruz
            for (int i = 0; i < matematikselIfade.length; i++) {
                if (deger == 0) {// eğer değer 0'sa kullanıcın girdiği ilk sayı alınmamış demektir.
                    deger = Integer.parseInt(matematikselIfade[i]);//dizide bulunan ilk değer işlem yapacağımız ilk sayı parseInt-> bu metod ile kullanıcının string değerini int'e çeviriyoruz.

                } else {
                    deger -= Integer.parseInt(matematikselIfade[i]);//bu da kullanıcının işlem yapmak istediği 2. değer
                }
            }
        }
        if (ifade.indexOf("/") != -1) {//kullanıcıdan alınan ifade de yapılmak istenen işlemin matematiksel sembolüne bakıyoruz.
            String[] matematikselIfade = ifade.split("/");//matamatiksel sembole göre ifadeyi bölüp diziye atıyoruz
            for (int i = 0; i < matematikselIfade.length; i++) {
                if (deger == 0) {// eğer değer 0'sa kullanıcın girdiği ilk sayı alınmamış demektir.
                    deger = Integer.parseInt(matematikselIfade[i]);//dizide bulunan ilk değer işlem yapacağımız ilk sayı parseInt-> bu metod ile kullanıcının string değerini int'e çeviriyoruz.
                } else {
                    deger /= Integer.parseInt(matematikselIfade[i]);//bu da kullanıcının işlem yapmak istediği 2. değer
                }
            }
        }
        if (ifade.indexOf("%") != -1) {
            String[] matematikselIfade = ifade.split("%"); //kullanıcıdan alınan ifade de yapılmak istenen işlemin matematiksel sembolüne bakıyoruz.
            for (int i = 0; i < matematikselIfade.length; i++) {//matamatiksel sembole göre ifadeyi bölüp diziye atıyoruz
                if (deger == 0) {// eğer değer 0'sa kullanıcın girdiği ilk sayı alınmamış demektir.
                    deger = Integer.parseInt(matematikselIfade[i]);//dizide bulunan ilk değer işlem yapacağımız ilk sayı parseInt-> bu metod ile kullanıcının string değerini int'e çeviriyoruz.
                } else {
                    deger %= Integer.parseInt(matematikselIfade[i]);//bu da kullanıcının işlem yapmak istediği 2. değer
                }
            }
        }
        if (ifade.indexOf("+") != -1) { //kullanıcıdan alınan ifade de yapılmak istenen işlemin matematiksel sembolüne bakıyoruz.

            String[] matematikselIfade = ifade.split("\\+");//matamatiksel sembole göre ifadeyi bölüp diziye atıyoruz
            for (int i = 0; i < matematikselIfade.length; i++) {
                if (deger == 0) {// eğer değer 0'sa kullanıcın girdiği ilk sayı alınmamış demektir.
                    deger = Integer.parseInt(matematikselIfade[i]);//dizide bulunan ilk değer işlem yapacağımız ilk sayı parseInt-> bu metod ile kullanıcının string değerini int'e çeviriyoruz.
                } else {
                    deger += Integer.parseInt(matematikselIfade[i]);//bu da kullanıcının işlem yapmak istediği 2. değer
                }
            }
        }

        if (ifade.indexOf("*") != -1) {//kullanıcıdan alınan ifade de yapılmak istenen işlemin matematiksel sembolüne bakıyoruz.

            String[] matematikselIfade = ifade.split("\\*");//matamatiksel sembole göre ifadeyi bölüp diziye atıyoruz
            for (int i = 0; i < matematikselIfade.length; i++) {
                if (deger == 0) {// eğer değer 0'sa kullanıcın girdiği ilk sayı alınmamış demektir.
                    deger = Integer.parseInt(matematikselIfade[i]);//dizide bulunan ilk değer işlem yapacağımız ilk sayı parseInt-> bu metod ile kullanıcının string değerini int'e çeviriyoruz.
                } else {
                    deger *= Integer.parseInt(matematikselIfade[i]);//bu da kullanıcının işlem yapmak istediği 2. değer
                }
            }
        }

        System.out.println("Sonuc:" + deger);

    }
    public  void expressionDefinition(String ifade) {

                        char[] ifadeChar = ifade.toCharArray();
                        boolean karakterKumesi = false;
                        boolean sayisalKume = false;

                        for (int i = 0; i < ifadeChar.length; i++) {
                            if (Character.isLetter(ifadeChar[i])) { //Character.isLetter()->bu metod ile belirtilen karakterin bir harf olup olmadığını kontrol eder.
                                if (Character.isLowerCase(ifadeChar[i]) || Character.isUpperCase(ifadeChar[i])) { //gene aynı metot sayesinda o harf'in büyük harf veya küçük harf olması durumunu kontrol ediyoruz
                                    karakterKumesi = true;
                                }
                            } else if (Character.isDigit(ifadeChar[i])) {//Character.isDigit()-> gene aynı metot ile sayısal bir değer oluğ olmadığını kontrol ediyoruz.
                                sayisalKume = true;
                            }
                        }

                        //boolean değerlerin true gelme durumuna göre ekrana ilgili mesajları yazdırıyoruz.
                         if (karakterKumesi) {
                            System.out.println("Bu bir karakter kümesidir.");
                        } else if (sayisalKume) {
                            System.out.println("Bu bir sayısal değer kümesidir.");
                        } else {
                            System.out.println("Boş ifade.");
                        }
            }
    public  void  writeToScreen(String ifade){
        //Ekrana yazdırma işlemi
               if(ifade.startsWith("System")){//kullanıcan alınan ifade içinde startsWith() metudunu kullanarak java diline ait olan ekrana yazma kodu'un başlangıç kelimelerini aynı mı diye kontrol ediyoruz.
                   if(ifade.contains("out.println")==true || ifade.contains("out.print")==true){//burda contains() metodunu kullanarak  gene java dinin ekrana yazdırma kodu için kullanılan iki farklı kod parçasının kullanıcının ifadesinde olup olmadığına bakıyoruz.
                       int baslangicIndex=ifade.indexOf("(");//parantez hangi index değerinde başladığını buluyoruz
                       int bitisIndex=ifade.indexOf(")");//parantez hangi index değerinde bitiş buluyoruz

                       String yazilmasiIstenenIfade=ifade.substring(baslangicIndex+2,bitisIndex-1); //substring() metodunu kullanarak kullanıcının yazdırmak istediği ifadeyi elde ediyoruz.
                       System.out.println(yazilmasiIstenenIfade);//ekrana basıyoruz
                   }
               }
            }
    public  void valueVariable(String ifade) {
                // Bu kısmın çalışabilmesi için şu şekilde yazılmalı->   int a = 5 ;


                String[] ifadeBol = ifade.split(" ");

                String[] veriTipleri = {"int", "String", "boolean", "double", "float"};
                for (int j = 0; j < ifadeBol.length; j++) {
                    for (int i = 0; i < veriTipleri.length; i++) {
                        if (ifade.startsWith(veriTipleri[i])) { // ifade bir veri tipi tanımlanarak mı başlanıyor onu kontrol ediyor.
                            if (ifade.endsWith(";")) { // ifade ;'e mi bitiyor ona bakıyor eğer ; eklenmezse java dilinde bu durum kod da hata yaratır.
                                if (veriTipleri[i] == "int") { //int veri tipi işlemi
                                    int deger = Integer.parseInt(ifadeBol[ifadeBol.length-2]);//kullanıcan  ifade String olarak alındı ve kullanıcının ifade de değişkene atadığı değeri eşleşen veri tipine çeviriyoruz.
                                    System.out.println(ifadeBol[1] + ":" + deger);//degeri ekrana basıyoruz
                                    break;
                                }
                                if (veriTipleri[i] == "String") {//String veri tipi işlemi
                                    String deger = ifadeBol[ifadeBol.length-2];//kullanıcan  ifade String olarak alındı ve kullanıcının ifade de değişkene atadığı değeri eşleşen veri tipine çeviriyoruz.
                                    System.out.println(ifadeBol[1] + ":" + deger);//degeri ekrana basıyoruz
                                    break;
                                }
                                if (veriTipleri[i] == "boolean") {//boolean veri tipi işlemi
                                    boolean deger = Boolean.parseBoolean(ifadeBol[ifadeBol.length-2]);//kullanıcan  ifade String olarak alındı ve kullanıcının ifade de değişkene atadığı değeri eşleşen veri tipine çeviriyoruz.
                                    System.out.println(ifadeBol[1] + ":" + deger);//degeri ekrana basıyoruz
                                    break;
                                }
                                if (veriTipleri[i] == "double") {//double veri tipi işlemi
                                    double deger = Double.parseDouble(ifadeBol[ifadeBol.length-2]);//kullanıcan  ifade String olarak alındı ve kullanıcının ifade de değişkene atadığı değeri eşleşen veri tipine çeviriyoruz.
                                    System.out.println(ifadeBol[1] + ":" + deger);//degeri ekrana basıyoruz
                                    break;
                                }
                                if (veriTipleri[i] == "float") {//float veri tipi işlemi
                                    float deger = Float.parseFloat(ifadeBol[ifadeBol.length-2]);//kullanıcan  ifade String olarak alındı ve kullanıcının ifade de değişkene atadığı değeri eşleşen veri tipine çeviriyoruz.
                                    System.out.println(ifadeBol[1] + ":" + deger);//degeri ekrana basıyoruz
                                    break;
                                }

                            }
                        }
                    }
                }
            }
   //Alt satırdaki if()else() koşulu içindir.
   public void conditionProcess(String ifade){
        if(ifade.startsWith("if")){
                if(ifade.indexOf("(")!=-1){
                        if (ifade.indexOf(")")!=-1) {
                            if (ifade.indexOf("{")!=-1) {
                                if (ifade.indexOf("}")!=-1) {
                                    if(ifade.contains("else{")==true){
                                        if (ifade.endsWith("}")) {System.out.println("bu bir koşul ifadesidir");}
                                    }
                                    else{System.out.println("bu bir koşul ifadesidir");}
                                }
                                else {System.out.println("Hatalı Syntax");}
                            }
                            else {System.out.println("Hatalı Syntax");}
                        }
                        else {System.out.println("Hatalı Syntax");}
                }
                else {System.out.println("Hatalı Syntax");}
        }
        else {System.out.println("Hatalı Syntax");
        }
    }

   //Alt satırdaki Kullanıcıdan değer alma işlemi içindir.
   public void takeValueFromUser(String ifade) {
      String[] veriTipleri = {"int", "String", "boolean", "double", "float"};
      String[] turler = {"nextInt()", "nextDouble()", "next()", "nextLine()", "nextFloat()"};
      String degerTipi ="";
      if (ifade.startsWith("Scanner")) {
          if (ifade.indexOf("=") != 1) {
              if (ifade.contains("new Scanner(System.in);") == true) {
                  for (int i = 0; i < veriTipleri.length; i++) {
                      if (ifade.indexOf(veriTipleri[i]) != -1) {
                          int baslangic = ifade.indexOf(veriTipleri[i]);
                          String deger = ifade.substring(baslangic, ifade.length());
                          int degerIndex = deger.indexOf(".");
                          degerTipi = deger.substring(degerIndex + 1, deger.length() - 1);
                          break;
                      }
                      else{
                          System.out.println("Hatalı Syntax");}
                  }
              }
              else{System.out.println("Hatalı Syntax");}
          }
          else {System.out.println("Hatalı Syntax");}

          if (degerTipi!=null) {
                              if (degerTipi.contains("nextInt()")) {
                                  System.out.println("Kullanıcıdan integer (tam sayı) değerini alır. (1,2,3,4,5...)");
                              } else if(degerTipi.contains("nextDouble()")) {
                                  System.out.println("Kullanıcıdan double (ondalıklı sayılar dahil) değerleri alır. (3.14, 2.7, 1.05, 10.9, 9...)");
                              }else if(degerTipi.contains("next()")) {
                                  System.out.println("Kullanıcıdan string (metin) değerini alır. (beyhan, aslı, java, dersleri...)");
                              }else if(degerTipi.contains("nextLine()"))  {
                                  System.out.println("Kullanıcıdan string (metin) değerini alır fakat o satırda ne var ne yoksa hepsini alır.");
                              }else if(degerTipi.contains("nextFloat()")) {
                                  System.out.println("Kullanıcıdan Float (ondalık) değerini alır.");}
                          }
          else{
              System.out.println("Hatalı Syntax");}
      }
      //Kullanının gireceği yapı
      //Scanner girdi = new Scanner(System.in); int sonuc = girdi.nextInt();


      }

   //Alt satırdaki while() döngüsü metod'udur.
   public void whileLoop(String ifade){
       char[] ifadeChar = ifade.toCharArray();
        if(ifade.startsWith("while")){
            if(ifade.indexOf("(") !=-1){
                if(ifade.indexOf(")") !=-1){
                    int deger=ifade.indexOf(")");
                    for(int i=deger; i<ifadeChar.length;i++){
                        if(ifadeChar[i]=='{'){
                            if(ifade.endsWith("}")){
                                System.out.println("bu bir while döngüsüdür.");
                            }
                            else{System.out.println("Hatalı Syntax");}
                        }
                        else{System.out.println("Hatalı Syntax");}
                    }
                }
                else{System.out.println("Hatalı Syntax");}
            }
            else{System.out.println("Hatalı Syntax");}
        }
        else{System.out.println("Hatalı Syntax");}
   }

   public void forLoop(String ifade){
       char[] ifadeChar = ifade.toCharArray();
        if(ifade.startsWith("for")){
           int baslangic=ifade.indexOf("(");
           int bitis=ifade.indexOf(")");
           String forSyntax=ifade.substring(baslangic+1,bitis);
           if(forSyntax.startsWith("int")){
               if(forSyntax.endsWith("+")){
                   for(int i=0; i<ifadeChar.length;i++){
                       if(ifadeChar[bitis+1]=='{'){
                           if(ifade.endsWith("}")){
                               System.out.println("Bu bir for döngüsüdür.");
                               break;
                           }
                           else{System.out.println("Hatalı Syntax");}
                       }
                       else{System.out.println("Hatalı Syntax");}
                   }
               }
               else{System.out.println("Hatalı Syntax");}
           }
           else{System.out.println("Hatalı Syntax");}

        }
        else{System.out.println("Hatalı Syntax");}
   }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String ifade;
        ifade = input.nextLine();

        Main mainMethods=new Main();
        //Alt satırdaki motod yorum satırı içindir.
        // mainMethods.commentFindLine(ifade);

        //Alt satırdaki motod Matematiksel (+, -, *, /, %) işlemler içindir.
        // mainMethods.mathematicalExpression(ifade);

        //Alt satırdaki motod Sayısal ve karakter kümesi şeklinde değişken tanımlaması işlemi içindir.
        //mainMethods.expressionDefinition(ifade);

        //Alt satırdaki motod Ekrana bilgi yazdırma işlemi içindir.
        // mainMethods.writeToScreen(ifade);

        //Alt satırdaki motod Değişkenlere değer atama işlemi içindir.
        // mainMethods.valueVariable(ifade);

        //Alt satırdaki motod if()else() sorgusunun kontrolü yapılmaktadır.
        // mainMethods.conditionProcess(ifade);

        //Alt satırdaki motod Kullanıcdan değer alma işlemi içindir.
        //mainMethods.takeValueFromUser(ifade);

        //Alt satırdaki while() döngüsü metod'udur.
        // mainMethods.whileLoop(ifade);

        //Alt satırdaki for() döngüsü metod'udur.
        //mainMethods.forLoop(ifade);



    }
}