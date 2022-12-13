import org.junit.jupiter.api.Test;

import java.io.File;

import static org.junit.jupiter.api.Assertions.*;

class day12Test {

    @Test
    public void TestApp(){
        PathFinding pathFinding = new PathFinding();
        assertEquals(31, pathFinding.getLenght());
    }

}