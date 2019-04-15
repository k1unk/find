import org.junit.Test;
import java.io.File;
import java.util.ArrayList;
import static org.junit.Assert.assertEquals;

public class TestFind {

    private Finder finder = new Finder();

    @Test
    public void findTest() {
        ArrayList<File> list1 = new ArrayList<>();
        list1.add(new File("src\\main\\file123\\fileN1"));
        assertEquals(list1, finder.find(new File("src\\main"), true, "fileN1"));
    }

    @Test
    public void findTest2() {
        ArrayList<File> list2 = new ArrayList<>();
        list2.add(new File("src\\test\\java\\testFile1"));
        assertEquals(list2, finder.find(new File("src\\test\\java"), true, "testFile1"));
    }

    @Test
    public void findTest3() {
        ArrayList<File> list3 = new ArrayList<>();
        list3.add(new File("src\\test\\java\\testFile1"));
        list3.add(new File("src\\test\\testFile1"));
        assertEquals(list3, finder.find(new File("src"), true, "testFile1"));
    }

    @Test
    public void findTest4() {
        ArrayList<File> list4 = new ArrayList<>();
        assertEquals(list4, finder.find(new File("src"), false, "testFile1"));
    }
}