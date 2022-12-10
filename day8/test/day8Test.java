import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class day8Test {
    @Test
    public void isVisibleRightTest() {

        int[][] test = new int[][]{
                {3,0,3,7,3},
                {2,5,5,1,2},
                {6,5,3,3,2},
                {3,3,5,4,9},
                {3,5,3,9,0},
        };
        assertFalse(day8.isVisibleRight(5, 1, 1, test));
        assertFalse(day8.isVisibleRight(3, 0, 0, test));
        assertTrue(day8.isVisibleRight(9, 4, 3, test));
        assertFalse(day8.isVisibleRight(3, 1, 3, test));
    }

    @Test
    public void isVisibleLeftTest(){
        int[][] test = new int[][]{
                {3,0,3,7,3},
                {2,5,5,1,2},
                {6,5,3,3,2},
                {3,3,5,4,9},
                {3,5,3,9,0},
        };
        assertTrue(day8.isVisibleLeft(5, 1, 1, test));
        assertTrue(day8.isVisibleLeft(3, 0, 0, test));
        assertTrue(day8.isVisibleLeft(9, 4, 3, test));
        assertFalse(day8.isVisibleLeft(3, 1, 3, test));
    }
    @Test
    public void isVisibleDownTest(){
        int[][] test = new int[][]{
                {3,0,3,7,3},
                {2,5,5,1,2},
                {6,5,3,3,2},
                {3,3,5,4,9},
                {3,5,3,9,0},
        };
        assertFalse(day8.isVisibleDown(5, 2, 1, test));
        assertTrue(day8.isVisibleDown(3, 2, 4, test));
        assertFalse(day8.isVisibleDown(4, 3, 3, test));
    }
    @Test
    public void isVisibleUpTest(){
        int[][] test = new int[][]{
                {3,0,3,7,3},
                {2,5,5,1,2},
                {6,5,3,3,2},
                {3,3,5,4,9},
                {3,5,3,9,0},
        };
        assertTrue(day8.isVisibleUp(5, 2, 1, test));
        assertFalse(day8.isVisibleUp(3, 2, 4, test));
        assertFalse(day8.isVisibleUp(4, 3, 3, test));
    }
}