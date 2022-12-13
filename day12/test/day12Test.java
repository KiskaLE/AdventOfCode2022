import org.junit.jupiter.api.Test;

import java.io.File;

import static org.junit.jupiter.api.Assertions.*;

class day12Test {

    @Test
    public void TestApp() {
        PathFinding pathFinding = new PathFinding(new File("testFile.txt"), 0, 0, 2, 5);
        assertEquals(31, pathFinding.getLenght());
    }

}