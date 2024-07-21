import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Comparator;

public class AviaSoulsTest {

    @Test
    public void testSortWhenFewTicketsMatch() {
        AviaSouls manager = new AviaSouls();
        Ticket ticket1 = new Ticket("LON", "PAR", 5000, 10,12); //
        Ticket ticket2 = new Ticket("MAD", "LA", 15000, 11,14);
        Ticket ticket3 = new Ticket("LON", "PAR", 5600, 10,16); //
        Ticket ticket4 = new Ticket("LON", "PAR", 4900, 7,7); //
        Ticket ticket5 = new Ticket("MAD", "PAR", 6000, 4,9);
        Ticket ticket6 = new Ticket("LON", "PAR", 5200, 6,10); //
        Ticket ticket7 = new Ticket("LON", "LA", 14000, 15,18);
        Ticket ticket8 = new Ticket("LON", "PAR", 5700, 7,8); //
        Ticket ticket9 = new Ticket("MAD", "PAR", 4800, 7,8);
        Ticket ticket10 = new Ticket("LON", "MAD", 4800, 7,8);
        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
        manager.add(ticket7);
        manager.add(ticket8);
        manager.add(ticket9);
        manager.add(ticket10);
        Ticket[] actual = manager.search("LON", "PAR");
        Ticket[] expected = {ticket4, ticket1, ticket6, ticket3, ticket8};
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void testSortWhenZeroTicketsMatch() {
        AviaSouls manager = new AviaSouls();
        Ticket ticket1 = new Ticket("LON", "PAR", 5000, 10,12);
        Ticket ticket2 = new Ticket("MAD", "LA", 15000, 11,14);
        Ticket ticket3 = new Ticket("LON", "PAR", 5600, 10,16);
        Ticket ticket4 = new Ticket("LON", "PAR", 4900, 7,7);
        Ticket ticket5 = new Ticket("MAD", "PAR", 6000, 4,9);
        Ticket ticket6 = new Ticket("LON", "PAR", 5200, 6,10);
        Ticket ticket7 = new Ticket("LON", "LA", 14000, 15,18);
        Ticket ticket8 = new Ticket("LON", "PAR", 5700, 7,8);
        Ticket ticket9 = new Ticket("MAD", "PAR", 4800, 7,8);
        Ticket ticket10 = new Ticket("LON", "MAD", 4800, 7,8);
        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
        manager.add(ticket7);
        manager.add(ticket8);
        manager.add(ticket9);
        manager.add(ticket10);
        Ticket[] actual = manager.search("PAR", "LON");
        Ticket[] expected = {};
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void testSortWhenOneTicketMatch() {
        AviaSouls manager = new AviaSouls();
        Ticket ticket1 = new Ticket("LON", "PAR", 5000, 10,12);
        Ticket ticket2 = new Ticket("MAD", "LA", 15000, 11,14);
        Ticket ticket3 = new Ticket("LON", "PAR", 5600, 10,16);
        Ticket ticket4 = new Ticket("LON", "PAR", 4900, 7,7);
        Ticket ticket5 = new Ticket("MAD", "PAR", 6000, 4,9);
        Ticket ticket6 = new Ticket("LON", "PAR", 5200, 6,10);
        Ticket ticket7 = new Ticket("LON", "LA", 14000, 15,18);
        Ticket ticket8 = new Ticket("LON", "PAR", 5700, 7,8);
        Ticket ticket9 = new Ticket("MAD", "PAR", 4800, 7,8);
        Ticket ticket10 = new Ticket("LON", "MAD", 4800, 7,8);
        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
        manager.add(ticket7);
        manager.add(ticket8);
        manager.add(ticket9);
        manager.add(ticket10);
        Ticket[] actual = manager.search("MAD", "LA");
        Ticket[] expected = {ticket2};
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void testSortWithComparatorWhenFewTicketsMatch() {
        AviaSouls manager = new AviaSouls();
        Ticket ticket1 = new Ticket("LON", "PAR", 5000, 10,12); //2
        Ticket ticket2 = new Ticket("MAD", "LA", 15000, 11,14); //
        Ticket ticket3 = new Ticket("LON", "PAR", 5600, 10,16); //6
        Ticket ticket4 = new Ticket("LON", "PAR", 4900, 7,17); //10
        Ticket ticket5 = new Ticket("MAD", "PAR", 6000, 4,9); //
        Ticket ticket6 = new Ticket("LON", "PAR", 5200, 6,10); //4
        Ticket ticket7 = new Ticket("LON", "LA", 14000, 15,18); //
        Ticket ticket8 = new Ticket("LON", "PAR", 5700, 7,8); //1
        Ticket ticket9 = new Ticket("MAD", "PAR", 4800, 7,8); //
        Ticket ticket10 = new Ticket("LON", "MAD", 4800, 7,8); //
        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
        manager.add(ticket7);
        manager.add(ticket8);
        manager.add(ticket9);
        manager.add(ticket10);
        Comparator<Ticket> comparator = new TicketTimeComparator();
        Ticket[] actual = manager.searchAndSortBy("LON", "PAR", comparator);
        Ticket[] expected = {ticket8, ticket1, ticket6, ticket3, ticket4};
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void testSortWithComparatorWhenZeroTicketsMatch() {
        AviaSouls manager = new AviaSouls();
        Ticket ticket1 = new Ticket("LON", "PAR", 5000, 10,12); //2
        Ticket ticket2 = new Ticket("MAD", "LA", 15000, 11,14); //
        Ticket ticket3 = new Ticket("LON", "PAR", 5600, 10,16); //6
        Ticket ticket4 = new Ticket("LON", "PAR", 4900, 7,17); //10
        Ticket ticket5 = new Ticket("MAD", "PAR", 6000, 4,9); //
        Ticket ticket6 = new Ticket("LON", "PAR", 5200, 6,10); //4
        Ticket ticket7 = new Ticket("LON", "LA", 14000, 15,18); //
        Ticket ticket8 = new Ticket("LON", "PAR", 5700, 7,8); //1
        Ticket ticket9 = new Ticket("MAD", "PAR", 4800, 7,8); //
        Ticket ticket10 = new Ticket("LON", "MAD", 4800, 7,8); //
        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
        manager.add(ticket7);
        manager.add(ticket8);
        manager.add(ticket9);
        manager.add(ticket10);
        Comparator<Ticket> comparator = new TicketTimeComparator();
        Ticket[] actual = manager.searchAndSortBy("PAR", "MAD", comparator);
        Ticket[] expected = {};
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void testSortWithComparatorWhenOneTicketMatch() {
        AviaSouls manager = new AviaSouls();
        Ticket ticket1 = new Ticket("LON", "PAR", 5000, 10,12); //2
        Ticket ticket2 = new Ticket("MAD", "LA", 15000, 11,14); //
        Ticket ticket3 = new Ticket("LON", "PAR", 5600, 10,16); //6
        Ticket ticket4 = new Ticket("LON", "PAR", 4900, 7,17); //10
        Ticket ticket5 = new Ticket("MAD", "PAR", 6000, 4,9); //
        Ticket ticket6 = new Ticket("LON", "PAR", 5200, 6,10); //4
        Ticket ticket7 = new Ticket("LON", "LA", 14000, 15,18); //
        Ticket ticket8 = new Ticket("LON", "PAR", 5700, 7,8); //1
        Ticket ticket9 = new Ticket("MAD", "PAR", 4800, 7,8); //
        Ticket ticket10 = new Ticket("LON", "MAD", 4800, 7,8); //
        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);
        manager.add(ticket6);
        manager.add(ticket7);
        manager.add(ticket8);
        manager.add(ticket9);
        manager.add(ticket10);
        Comparator<Ticket> comparator = new TicketTimeComparator();
        Ticket[] actual = manager.searchAndSortBy("LON", "MAD", comparator);
        Ticket[] expected = {ticket10};
        Assertions.assertArrayEquals(expected, actual);
    }

}
