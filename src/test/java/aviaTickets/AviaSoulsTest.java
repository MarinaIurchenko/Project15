package aviaTickets;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.util.Arrays;

public class AviaSoulsTest {
    AviaSouls aviaSouls = new AviaSouls();
    TicketTimeComparator timeComparator = new TicketTimeComparator();
    Ticket ticket1 = new Ticket("Самара","Череповец",3_000,15_00,17_00);
    Ticket ticket2 = new Ticket("Самара","Череповец",4_000,17_00,20_00);
    Ticket ticket3 = new Ticket("Самара","Череповец",5_000,7_00,9_00);
    Ticket ticket4 = new Ticket("Самара","Череповец",3_000,13_00,14_00);
    Ticket ticket5 = new Ticket("Самара","Череповец",5_000,6_00,8_00);
    Ticket ticket6 = new Ticket("Самара","Санкт-Петербург",4_500,8_30,12_30);



    @Test
    void testComperator1(){

        aviaSouls.add(ticket1);
        aviaSouls.add(ticket2);
        aviaSouls.add(ticket3);
        aviaSouls.add(ticket4);
        aviaSouls.add(ticket5);

        Assertions.assertEquals(1,timeComparator.compare(ticket2,ticket5));

    }
    @Test
    void testComperator2(){

        aviaSouls.add(ticket1);
        aviaSouls.add(ticket2);
        aviaSouls.add(ticket3);
        aviaSouls.add(ticket4);
        aviaSouls.add(ticket5);

        Assertions.assertEquals(0,timeComparator.compare(ticket3,ticket5));

    }
    @Test
    void testComperator3(){

        aviaSouls.add(ticket1);
        aviaSouls.add(ticket2);
        aviaSouls.add(ticket3);
        aviaSouls.add(ticket4);
        aviaSouls.add(ticket5);

        Assertions.assertEquals(-1,timeComparator.compare(ticket5,ticket2));

    }
    @Test
    public void testSearch(){
        aviaSouls.add(ticket1);
        aviaSouls.add(ticket2);
        aviaSouls.add(ticket3);
        aviaSouls.add(ticket4);
        aviaSouls.add(ticket5);
        aviaSouls.add(ticket6);

        Ticket[] expected = {ticket1, ticket4, ticket2, ticket3, ticket5};
        Ticket[] actual = aviaSouls.search("Самара", "Череповец");

        Assertions.assertArrayEquals(expected, actual);
    }
    @Test
    public void testSearchOneTicket(){
        aviaSouls.add(ticket1);
        aviaSouls.add(ticket2);
        aviaSouls.add(ticket3);
        aviaSouls.add(ticket4);
        aviaSouls.add(ticket5);
        aviaSouls.add(ticket6);

        Ticket[] expected = {ticket6};
        Ticket[] actual = aviaSouls.search("Самара", "Санкт-Петербург");

        Assertions.assertArrayEquals(expected, actual);
    }
    @Test
    public void testSearchNotTicket(){
        aviaSouls.add(ticket1);
        aviaSouls.add(ticket2);
        aviaSouls.add(ticket3);
        aviaSouls.add(ticket4);
        aviaSouls.add(ticket5);
        aviaSouls.add(ticket6);

        Ticket[] expected = {};
        Ticket[] actual = aviaSouls.search("Череповец", "Санкт-Петербург");

        Assertions.assertArrayEquals(expected, actual);
    }
    @Test
    public void testSearchFindAll(){
        aviaSouls.add(ticket2);
        aviaSouls.add(ticket4);

        Ticket[] tickets = aviaSouls.findAll();

        Arrays.sort(tickets,timeComparator);

        Ticket[] expected = {ticket4,ticket2};
        Ticket[] actual = aviaSouls.findAll();

        Assertions.assertArrayEquals(expected,actual);

    }
    @Test
    public void testComparatorFindAll(){
        aviaSouls.add(ticket3);
        aviaSouls.add(ticket5);

        Ticket[] tickets = aviaSouls.findAll();
        Arrays.sort(tickets);

        Ticket[] expected = {ticket3,ticket5};
        Ticket[] actual = aviaSouls.findAll();

        Assertions.assertArrayEquals(expected,actual);

    }

    @Test
    public void searchSortComp2(){


       aviaSouls.add(ticket1);
       aviaSouls.add(ticket2);


        Ticket[] expected = {ticket1,ticket2};
        Ticket[] actual = aviaSouls.searchAndSortBy("Самара","Череповец",timeComparator);

       Assertions.assertArrayEquals(expected,actual);
    }
    @Test
    void testComperToOne(){

        aviaSouls.add(ticket1);
        aviaSouls.add(ticket2);
        aviaSouls.add(ticket3);
        aviaSouls.add(ticket4);
        aviaSouls.add(ticket5);

        Assertions.assertEquals(-1, ticket2.compareTo(ticket3));
}
    @Test
    void testComperToTwo(){

        aviaSouls.add(ticket1);
        aviaSouls.add(ticket2);
        aviaSouls.add(ticket3);
        aviaSouls.add(ticket4);
        aviaSouls.add(ticket5);

        Assertions.assertEquals(1, ticket2.compareTo(ticket4));

    }
    @Test
    void testComperToThree(){
        aviaSouls.add(ticket1);
        aviaSouls.add(ticket2);
        aviaSouls.add(ticket3);
        aviaSouls.add(ticket4);
        aviaSouls.add(ticket5);

        Assertions.assertEquals(0, ticket1.compareTo(ticket4));
    }

}
