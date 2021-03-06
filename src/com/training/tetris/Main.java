package com.training.tetris;

import java.util.*;
import java.util.function.UnaryOperator;

public class Main {

    private static void populate(List<String> lst){
        lst.clear();
        lst.add("France");
        lst.add("Allemagne");
        lst.add("USA");
        lst.add("Chine");
    }

    private static void populateC(List<Country> lc){
        lc.clear();
        lc.add(new Country("France"));
        lc.add(new Country("Royaume-Uni de Grande-Bretagne"));
        lc.add(new Country("Zimbabwe"));
        lc.add(new Country("Allemagne"));
    }


    private static void afficher(List<String> lst){
        if (lst.size() > 0)
            for (String s : lst)
                System.out.println(s);
        else
            System.out.println("La liste est vide.");
    }

    private static void afficherC(List<Country> lc){
        for (Country c : lc){
            System.out.println(c.getName());
        }
    }

    public static void main(String[] args) {


        List<String> countries = new ArrayList<>();

        System.out.println("*** 1 : afficher ***");
        populate(countries);
        afficher(countries);

        System.out.println("*** 2 : clear ***");
        countries.clear();
        afficher(countries);

        System.out.println("*** 3 : remplacer ***");
        populate(countries);
        String pays = "Belgique";
        countries.set(1, pays);
        afficher(countries);

        System.out.println("*** 4 : replace all 1.3 ***");
        UnaryOperator<String> unaryOperator = new UnaryOperator<String>() {
            @Override
            public String apply(String s) {
                if (s.equals("Belgique"))
                    return "Suisse";
                else
                    return s;
            }
        };
        countries.replaceAll(unaryOperator);
        afficher(countries);

        System.out.println("*** 5 : replace all 1.2 ***");
        countries.replaceAll(new UnaryOperator<String>() {
            @Override
            public String apply(String s) {
                if (s.equals("Suisse"))
                    return "Pays-Bas";
                else
                    return s;
            }
        });
        afficher(countries);

        System.out.println("*** 6 : replace all 1.3 ***");
        countries.replaceAll(s -> {
            if (s.equals("Pays-Bas"))
                return "Danemark";
            else
                return s;
        });
        afficher(countries);

        System.out.println("*** 7 : Collections.sort");
        Collections.sort(countries);
        afficher(countries);

        System.out.println("*** 7 : Collections.reverseOrder");
        Collections.sort(countries, Collections.reverseOrder());
        afficher(countries);

        System.out.println("*** 7 : comparator");
        Comparator<String> comparator = new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.compareTo(o2);
            }
        };
        countries.sort(comparator);
        afficher(countries);

        System.out.println("*** 7 : comparator 2");
        Collections.sort(countries, Collections.reverseOrder());
        countries.sort((o1, o2) -> o1.compareTo(o2));
        afficher(countries);

        System.out.println("*** 8 : Classe County + 'in ligne' comparator");
        List<Country> lc = new ArrayList<Country>();
        populateC(lc);

        lc.sort(new Comparator<Country>() {
            @Override
            public int compare(Country o1, Country o2) {
                return o1.getName().compareTo(o2.getName()) ;
            }
        });
        afficherC(lc);

        System.out.println("*** 8 : Classe County + CountryComparator");
        lc.sort(new CountryComparator());
        afficherC(lc);

        System.out.println("*** 8 : Classe County + Country::compare");
        populateC(lc);
        lc.sort(Country::compare);
        afficherC(lc);

        System.out.println("*** 8 : Classe County + nested class comparator");
        populateC(lc);
        Collections.sort( lc, new InnerCountryComparator() );
        afficherC(lc);

        System.out.println("*** 8 : Classe County + approche fonctionelle");
        populateC(lc);
        Collections.sort(lc, Comparator.comparing(country -> country.getName()));
        afficherC(lc);

    }

    public static class InnerCountryComparator implements  Comparator<Country>{
        @Override
        public int compare(Country o1, Country o2) {
            return o1.getName().compareToIgnoreCase(o2.getName());
        }
    }
}
