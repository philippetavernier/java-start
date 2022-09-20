import java.util.*;
class TestCalendar {
    public static String replaceCommas(String a){
        StringBuilder result = new StringBuilder();
        Scanner scan = new Scanner(a);
        scan.useDelimiter(",");
        while(scan.hasNext()){
            result.append(scan.next());
            result.append("\n");
        }
        return result.toString();
    }

    static public void main(String args[]) {
        Calendar rightNow = Calendar.getInstance();
        // Création d'une instance date initialisée par défaut à la date  System.out.println(rightNow);
        String stringRightNow= rightNow.toString();
        String newRightNow=replaceCommas(stringRightNow);
        System.out.println(newRightNow);
        // le contenu de rightNow pour les curieux!
        // le contenu de rightNow pour les curieux!
        String emails = "AA,BB,CC";
        String emailsNew = replaceCommas(emails);

        System.out.println(emailsNew);

        // tester les get()
        int j = rightNow.get (Calendar.DAY_OF_MONTH);
        int m = rightNow.get (Calendar.MONTH);
        int y = rightNow.get (Calendar.YEAR);
        int n = rightNow.get (Calendar.DAY_OF_WEEK);
        System.out.println("On est le:"+j+ "/" +(m+1)+"/"+y+ "c'est le " +n+ "jour de la semaine");
        
        String jour ="";
        switch(rightNow.get(Calendar.DAY_OF_WEEK)){
        case 1: jour = "Dimanche"; break;
        case 2: jour = "Lundi"; break;
        // ... à compléter ...
        case 7: jour = "Samedi"; break;
        }
        System.out.printf("On est le: %s %d/%d/%d%n", jour, j, m+1, y);
        rightNow.set(Calendar.MONTH, Calendar.MAY);
        j = rightNow.get (Calendar.DAY_OF_MONTH);
        m = rightNow.get (Calendar.MONTH);
        y = rightNow.get (Calendar.YEAR);
        n = rightNow.get (Calendar.DAY_OF_WEEK);  
        System.out.println("On est le:"+j+ "/" +(m+1)+"/"+y+ "c'est le " +n+ "jour de la semaine");
    }
}