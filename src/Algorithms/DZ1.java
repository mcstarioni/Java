package Algorithms;
import java.util.LinkedList;

/**
 * Created by mcstarioni on 26.02.2017.
 */
public class DZ1
{
    public static int[] originCapacity = {30,48,20,30};
    public static int[] destinationCapacity = {18,27,42,15,26};
    public static int[] routesCost = {6,5,9,7,5,7,3,1,1,7,1,2,9,8,1,4,9,7,1};
    public static int totalCapacity;
    static class Node
    {
        int number;
        int capacity;
        Node(int n,int c)
        {
            number = n;
            capacity = c;
        }
    }
    static class Route
    {
        Node origin;
        Node destination;
        int cost;
        int transit = 0;
        Route(Node origin,Node destination,int cost)
        {
            this.origin = origin;
            this.destination = destination;
            this.cost = cost;
        }

        @Override
        public String toString()
        {
            return "A"+origin.number + " -> B"+destination.number;
        }
        public int getTotalCost()
        {
            return cost*transit;
        }
    }
    public static LinkedList<Route> FindOptimalRoutes(Route[] routes)
    {
        int cargo = totalCapacity;

        return null;
    }
    public static void main(String[] args)
    {
        Node[] origins = new Node[originCapacity.length];
        Node[] destinations = new Node[destinationCapacity.length];
        Route[] routes = new Route[origins.length*destinations.length];
        try
        {
            InitializeRoutes(origins, destinations,routes);
        }catch (Exception e)
        {
            System.out.println(e.getMessage());
            return;
        }
        for (Route route : routes)
        {
            System.out.println(route);
        }
    }
    public static void InitializeRoutes(Node[] origins, Node[] destinations,Route[] routes) throws Exception
    {
        int orSumm = 0,desSumm = 0;
        for (int i : originCapacity)
            orSumm += i;
        for (int i : destinationCapacity)
            desSumm += i;
        if(orSumm != desSumm || routesCost.length != routes.length)
            throw new Exception("Ty durak ili kak?");
        totalCapacity = desSumm;
        for (int i = 0; i < origins.length; i++)
            origins[i] = new Node(i+1, originCapacity[i]);

        for (int i = 0; i < destinations.length; i++)
            destinations[i] = new Node(i+1, destinationCapacity[i]);
        int k = 0;
        for (int i = 0; i < origins.length ; i++)
        {
            for (int j = 0; j < destinations.length; j++)
            {
                routes[k] = new Route(origins[i],destinations[j],routesCost[k]);
                k++;
            }
        }
    }
}
