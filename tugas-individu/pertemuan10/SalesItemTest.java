import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class SalesItemTest
{
    public SalesItemTest()
    {
    }
    @BeforeEach
    public void setUp()
    {
    }
    @AfterEach
    public void tearDown()
    {
    }
    @Test
    public void demo()
    {
        SalesItem item1 = new SalesItem("Laptop Asus ROG", 25000000);
        assertEquals(true, item1.addComment("Budi", "Laptop gaming terbaik! Lancar jaya untuk main game berat", 5));
        assertEquals(true, item1.addComment("Siti", "Layarnya jernih, performanya oke, tapi agak berat", 4));
        assertEquals(true, item1.addComment("Ahmad", "Bagus sih tapi harganya mahal", 3));
        item1.showInfo();
        assertEquals(false, item1.addComment("Andi", "Produk jelek", 0));
        assertEquals(false, item1.addComment("Budi", "Tambahan review", 5));
        
        SalesItem item2 = new SalesItem("Samsung Galaxy S24", 12000000);
        assertEquals(true, item2.addComment("Rina", "Kameranya luar biasa! Hasil foto jernih banget", 5));
        assertEquals(true, item2.addComment("Doni", "Baterai awet seharian, sangat puas", 5));
        assertEquals(true, item2.addComment("Lina", "Harga terjangkau untuk spek sekelas ini", 4));
        assertEquals(true, item2.addComment("Eko", "Desainnya elegan tapi cepat panas saat gaming", 3));
        item2.showInfo();
        
        SalesItem item3 = new SalesItem("Sony WH-1000XM5", 5500000);
        assertEquals(true, item3.addComment("Putri", "Noise cancelling terbaik! Suara jernih", 5));
        assertEquals(true, item3.addComment("Rudi", "Nyaman dipakai berjam-jam, bass mantap", 4));
        assertEquals(false, item3.addComment("Rudi", "Lupa kasih rating bintang 5", 5));
        assertEquals(false, item3.addComment("Dewi", "Bagus tapi mahal", 6));
        item3.showInfo();
    }
    
    @Test
    public void testAddCommentWithValidRating()
    {
        SalesItem item = new SalesItem("Mouse Gaming", 500000);
        assertTrue(item.addComment("User1", "Bagus", 1));
        assertTrue(item.addComment("User2", "Lumayan", 3));
        assertTrue(item.addComment("User3", "Sangat bagus", 5));
        assertEquals(3, item.getNumberOfComments());
    }
    
    @Test
    public void testAddCommentWithInvalidRating()
    {
        SalesItem item = new SalesItem("Keyboard Mechanical", 1200000);
        assertFalse(item.addComment("User1", "Rating terlalu rendah", 0));
        assertFalse(item.addComment("User2", "Rating terlalu tinggi", 6));
        assertFalse(item.addComment("User3", "Rating negatif", -1));
        assertEquals(0, item.getNumberOfComments());
    }
    
    @Test
    public void testFindMostHelpfulComment()
    {
        SalesItem item = new SalesItem("Monitor 4K", 8000000);
        item.addComment("Alice", "Resolusi tajam", 5);
        item.addComment("Bob", "Warna akurat untuk editing", 4);
        item.addComment("Charlie", "Harga sebanding kualitas", 5);
        
        Comment mostHelpful = item.findMostHelpfulComment();
        assertNotNull(mostHelpful);
        
        mostHelpful.upvote();
        mostHelpful.upvote();
        mostHelpful.upvote();
        
        Comment result = item.findMostHelpfulComment();
        assertEquals("Alice", result.getAuthor());
        assertEquals(3, result.getVoteBalance());
    }
}