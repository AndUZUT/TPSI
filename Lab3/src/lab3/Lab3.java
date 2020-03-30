/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab3;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

/**
 *
 * @author ua39472
 */
public class Lab3 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        System.out.println("Zadanie 1");
        
        Set<String> zbiorDni = new HashSet<>();
        zbiorDni.add("poniedziałek");
        zbiorDni.add("wtorek");
        zbiorDni.add("sroda");
        zbiorDni.add("czwartek");
        zbiorDni.add("piatek");
        zbiorDni.add("sobota");
        zbiorDni.add("niedziela");
        System.out.println("HashSet: ");
        
        for(String dzien : zbiorDni) {
        System.out.println(dzien);
        }
        
        Set<String> zbiorDni2 = new TreeSet<>();
        zbiorDni2.add("poniedziałek");
        zbiorDni2.add("wtorek");
        zbiorDni2.add("sroda");
        zbiorDni2.add("czwartek");
        zbiorDni2.add("piatek");
        zbiorDni2.add("sobota");
        zbiorDni2.add("niedziela");
        System.out.println("TreeSet: ");
        
        for(String dzien : zbiorDni2) {
        System.out.println(dzien);
        }
        
        System.out.println("Nie można przewidzieć w jakiej kolejności będzie HashSet wyświetlany, natomiast TreeSet jest wyświetlany alfabetycznie");
        
        System.out.println("Zadanie 2");
        
        Map<String, Teacher> Przedmioty = new HashMap<>();
        Przedmioty.put("PO", new Teacher("Jan", "Kowalski", "jkowal1@zut.edu.pl", "Programowanie Obiektowe"));
        Przedmioty.put("GI", new Teacher("Kamila", "Chmura", "kc2@zut.edu.pl", "Grafika internetowa"));
        Przedmioty.put("JA", new Teacher("Marcin", "Test", "mt3@zut.edu.pl", "Język Angielski"));
        
        Teacher po = Przedmioty.get("PO");
        System.out.println("Dane nauczyciela, który uczy Programowanie Obiektowe: " + po);
        
        Map<Integer, List<Student>> grupy = new HashMap<>();
        
        List<Student> grupa31 = new ArrayList<>();
        grupa31.add(new Student("Remigiusz", "Nowak", "rn92@zut.edu.pl", "31"));
        grupa31.add(new Student("Karol", "Koral", "kk523@zut.edu.pl", "31"));
        
        List<Student> grupa32 = new ArrayList<>();
        grupa32.add(new Student("Andrzej", "Test", "atest@zut.edu.pl", "32"));
        grupa32.add(new Student("Karolina", "Kowalska", "kk345@zut.edu.pl", "32"));
        
        List<Student> grupa33 = new ArrayList<>();
        grupa33.add(new Student("Natalia", "Mróz", "zimno823@zut.edu.pl", "33"));
        grupa33.add(new Student("Paulina", "Jankowska", "pk12872@zut.edu.pl", "33"));
        
        grupy.put(31, grupa31);
        grupy.put(32, grupa32);
        grupy.put(33, grupa33);
        
        List<Student> grupa = grupy.get(32);
        System.out.println("Lista studentów z grupy 32: " + grupa);
        
        System.out.println("Zadanie 3");
        
        List<Product> produkty = new ArrayList<>();
        
        Map<Integer, Product> Wyszukiwarka_po_ID = new HashMap<>();
        Map<String, List<Product>> Wyszukiwarka_po_kategorii = new HashMap<>();
        
        try(BufferedReader in = new BufferedReader(new FileReader("produkty.txt"))) {
            String s = in.readLine();
            
            while(s!=null) {
                String pola[] = s.split(";");
                Integer id = Integer.parseInt(pola[0]);
                Double cena = Double.parseDouble(pola[3]);
                produkty.add(new Product(id, pola[1], pola[2], cena));
                Wyszukiwarka_po_ID.put(id, new Product(id, pola[1], pola[2], cena));
                if(Wyszukiwarka_po_kategorii.containsKey(pola[2]))
                {
                    Wyszukiwarka_po_kategorii.get(pola[2]).add(new Product(id, pola[1], pola[2], cena));
                }
                else
                {
                    List<Product> kategoria = new ArrayList<>();
                    kategoria.add(new Product(id, pola[1], pola[2], cena));
                    Wyszukiwarka_po_kategorii.put(pola[2], kategoria);
                }
                s = in.readLine();
            }
        }
        catch (IOException ex) {
            ex.printStackTrace();
        }
        
        for(Product lista_produktow : produkty) {
        System.out.println(lista_produktow);
        }
        
        Product szukaj = Wyszukiwarka_po_ID.get(105);
        System.out.println("Produkt z ID równym 105: " + szukaj);
        
        List<Product> szukaj2 = Wyszukiwarka_po_kategorii.get("oprogramowanie");
        System.out.println("Produkty z kategorią oprogramowanie: " + szukaj2);
        
        
    }
    
}
