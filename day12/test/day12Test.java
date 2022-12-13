import org.junit.jupiter.api.Test;

import java.io.File;

import static org.junit.jupiter.api.Assertions.*;

class day12Test {

    @Test
    public void TestApp() {
        PathFinding pathFinding = new PathFinding(new File("testFile.txt"));
        assertEquals(31, pathFinding.getLenght(0, 0, 2, 5));
    }

    @Test
    public void test(){
        int parent = 122;
        int child = 123;
        assertTrue(parent <= child+1);
    }
}