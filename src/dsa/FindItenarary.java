package dsa;

import java.util.*;

public class FindItenarary {
    public static void findItinerary(Map<String, String> tickets) {

        String source = null;

        // find source
        for(String city: tickets.keySet()){
            if(!tickets.containsValue(city)){
                source = city;
            }
        }

        if(source == null){
            System.out.println("Invalid Input");
            return;
        }

        // start from source
        String currentCity = source;

        while(currentCity!=null){

            // find the next city in Itinerary
            String nextCity = tickets.get(currentCity);

            if(nextCity != null){
                System.out.println(currentCity+"->"+nextCity);
                currentCity = nextCity;
            } else {
                break;
            }
        }
    }

    public static void main(String[] args) {
        Map<String, String> tickets = new HashMap<String, String>();
        Scanner sc = new Scanner(System.in);
        int n  = sc.nextInt();
        for(int i = 0 ; i < n ; i++){
            tickets.put(sc.next(),sc.next());
        }
        findItinerary(tickets);
    }
}
