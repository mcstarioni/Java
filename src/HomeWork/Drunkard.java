package HomeWork;

import Collections.List.CollectionMain;
import Collections.List.Queue;

import java.util.Random;

/**
 * Created by mcstarioni on 02.11.2016.
 */
public class Drunkard
{
    public static void play(Queue<Integer> player1, Queue<Integer> player2)
    {
        Integer card1;
        Integer card2;
        while(!player1.isEmpty() && !player2.isEmpty())
        {
            try
            {
                Thread.sleep(2000);
            } catch (InterruptedException e)
            {
                e.printStackTrace();
            }
            CollectionMain.listPrintTest(player1);
            CollectionMain.listPrintTest(player2);
            card1 = player1.popFirst();
            card2 = player2.popFirst();

            System.out.print("P1 = " + card1.toString() + " P2 = "+card2.toString());
            if(((card2 == 9 && card1 == 0)||(card1 > card2)) && !(card1 == 9 && card2 == 0))
            {
                System.out.println("-> goes to player 1");
                player1.push(card1);
                player1.push(card2);
            }
            else
            {
                System.out.println("-> goes to player 2");
                player2.push(card1);
                player2.push(card2);
            }
            System.out.println("==========");
        }
        if (player1.isEmpty())
        {
            System.out.println("Player 2 has won!");
        }
        else
        {
            System.out.println("Player 1 has won!");
        }

    }
    public static void giveCards(Queue<Integer> player1,Queue<Integer> player2, Queue<Integer> cards)
    {
        Random rand = new Random();
        for (int i = 0; i < 10; i++)
        {
            Integer card = cards.elementAt(rand.nextInt(cards.size()));
            System.out.println(card.toString());
            if(i%2 == 0)
            {
                player1.add(card);
            }
            else
            {
                player2.add(card);
            }
            cards.removeObj(card);
        }
    }
    public static void main(String[] args)
    {
        Queue<Integer> cards = new Queue<>();
        for (Integer i = 0; i < 10; i++)
        {
            cards.add(i);
        }
        Queue<Integer> player1 = new Queue<>();
        Queue<Integer> player2 = new Queue<>();
        giveCards(player1, player2, cards);
        play(player1, player2);
    }

}
