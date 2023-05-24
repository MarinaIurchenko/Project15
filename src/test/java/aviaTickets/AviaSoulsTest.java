package aviaTickets;

import jdk.internal.jimage.ImageStrings;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.sql.Array;
import java.sql.Time;

public class AviaSoulsTest {

    Ticket ticket1 = new Ticket("Москва","Санкт-Петербург",3_500,13_00,14_00);
    Ticket ticket2 = new Ticket("Москва","Самара",4_000,17_00,20_00);
    Ticket ticket3 = new Ticket("Санкт-Петербур","Самара",6_000,15_00,19_00);
    Ticket ticket4 = new Ticket("Череповец","Санкт-Петербург",3_000,11_00,12_00);
    Ticket ticket5 = new Ticket("Самара","Череповец",5_000,6_00,11_00);

    @BeforeEach
    public void setup(){

        aviaSouls.add(ticket1);
        aviaSouls.add(ticket2);
        aviaSouls.add(ticket3);
        aviaSouls.add(ticket4);
        aviaSouls.add(ticket5);
    }
    @Test
    void compareToLess(){
        Assertions.assertEquals(-1,ticket4.compareTo(ticket2));
    }
    @Test
    void compareToMore(){
        Assertions.assertEquals(1,ticket5.compareTo(ticket3));
    }

    @Test
    public void searchSortComp1(){
        TicketTimeComparator timeComparator = new TicketTimeComparator();

        aviaSouls.add(ticket2);
        aviaSouls.add(ticket3);

        Ticket[] tickets = aviaSouls.findAll();
        Array.sort(tickets,timeComparator);

        Ticket[] expected = {ticket3,ticket2};
        Ticket[] actual = aviaSouls.findAll();

        Assertions.assertArrayEquals(expected,actual);


    }
}
