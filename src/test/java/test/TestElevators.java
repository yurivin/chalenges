package test;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/** Elevators task */
public class TestElevators {

    @Test
    public void test3() {
        int[] A = new int[5];
        int[] B = new int[5];
        int M = 3;
        int X = 5;
        int Y = 200;
        A[0] = 40;
        B[0] = 3;
        A[1] = 40;
        B[1] = 3;
        A[2] = 100;
        B[2] = 2;
        A[3] = 80;
        B[3] = 2;
        A[4] = 20;
        B[4] = 3;

        System.out.println(solution(A, B, M, X, Y));
    }

    // M - floors
    // X - elevators capacity in peoples
    // Y - limit of weight
    // N - people in a queue on a ground floor
    // A - person's weight array
    // B - target floor array
    public int solution(int[] A, int[] B, int M, int X, int Y) {
        long weightPerRound = 0;
        int currPerson = 0;
        int maxPeople = 0;
        List<Integer> groundFloor = new ArrayList<Integer>();
        boolean elevatorRunning = false;
        int stopsSum = 0;
        while (currPerson < A.length) {
            //Check edge case whe person is owerweighted for the elevator
            if(A[currPerson] > Y) break;
            if ((weightPerRound + A[currPerson]) <= Y && (maxPeople + 1) <= X) {
                weightPerRound += A[currPerson];
                maxPeople++;
                groundFloor.add(B[currPerson]);
                //If person is last one, start elevator
                if (currPerson == A.length - 1) elevatorRunning = true;
                currPerson++;
            } else {
                elevatorRunning = true;
            }
                // counting stops
            if (elevatorRunning) {
                Set<Integer> lstFloorsSet = new HashSet<Integer>(groundFloor);
                stopsSum += lstFloorsSet.size() + 1;
                //reset
                groundFloor.clear();
                maxPeople = 0;
                weightPerRound = 0;
                elevatorRunning = false;
            }
        }
        return stopsSum;
    }


    @Test
    public void testNOtEnoughWeight() {
        int[] A = new int[5];
        int[] B = new int[5];
        int M = 3;
        int X = 5;
        int Y = 3;
        A[0] = 40;
        B[0] = 3;
        A[1] = 40;
        B[1] = 3;
        A[2] = 100;
        B[2] = 2;
        A[3] = 80;
        B[3] = 2;
        A[4] = 20;
        B[4] = 3;

        System.out.println(solution(A, B, M, X, Y));
    }

    @Test
    public void test() {
        int[] A = new int[5];
        int[] B = new int[5];
        int M = 3;
        int X = 5;
        int Y = 200;
        A[0] = 40;
        B[0] = 3;
        A[1] = 40;
        B[1] = 3;
        A[2] = 100;
        B[2] = 2;
        A[3] = 80;
        B[3] = 2;
        A[4] = 20;
        B[4] = 3;

        System.out.println(solution(A, B, M, X, Y));
    }
}