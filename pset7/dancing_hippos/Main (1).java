import java.util.*;
import java.awt.*;
public class Main
{
    public static Point[] djset;
    public static int safeCount;
    public static void main(String args[])
    {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int M = scanner.nextInt();
        int totalSize = N * M;

        djset = new Point[totalSize];

        for (int i = 0; i < totalSize; i++)
        {
            int currElevation = scanner.nextInt();
            djset[i] = new Point(-1, currElevation);
        }
        int levels = scanner.nextInt();
        for (int i = 0; i < levels; i++)
        {
            int currLevel = scanner.nextInt();
            safeCount = 0;
            for (int j = 0; j < totalSize; j++)
            {
                if (djset[j].y <= currLevel)
                {
                    continue;
                }
                else
                {
                    safeCount++;
                    if ((j + 1) % M == 0 || j + 1 == totalSize || djset[j + 1].y <= currLevel)
                    {
                        //
                    }
                    else
                    {
                        combine(j, j + 1);
                    }
                    
                    if (j % M == 0 || j == 0 || djset[j - 1].y <= currLevel)
                    {
                        //
                    }
                    else
                    {
                        combine(j, j - 1);
                    }

                    int currRow = j/M;
                    int currCol = j % M;
                    int indexOfUnder = (currRow + 1) * M + currCol;
                    int indexOfAbove = (currRow - 1) * M + currCol;
                    if (indexOfUnder >= totalSize || djset[indexOfUnder].y <= currLevel)
                    {
                        //
                    }
                    else
                    {
                        combine(j, indexOfUnder);
                    }

                    if (indexOfAbove < 0 || djset[indexOfAbove].y <= currLevel)
                    {
                        //
                    }
                    else
                    {
                        combine(j, indexOfAbove);
                    }
                }
            }
            if (i != levels - 1)
            {
                System.out.print(safeCount + " ");
                for (int j = 0; j < totalSize; j++)
                {
                    djset[j].x = -1;
                }
            }
            else
            {
                System.out.println(safeCount);
            }
        }
    }

    public static int findRoot(int index)
    {
        if (djset[index].x < 0)
        {
            return index;
        }
        else
        {
            return findRoot(djset[index].x);
        }
    }
    public static void combine(int indexOne, int indexTwo)
    {
        int rootOne = findRoot(indexOne);
        int rootTwo = findRoot(indexTwo);
        if (rootOne == rootTwo)
        {
            return;
        }

        int sizeOne = -1 * djset[rootOne].x;
        int sizeTwo = -1 * djset[rootTwo].x;
        int size = sizeOne + sizeTwo;

        if (sizeOne >= sizeTwo)
        {
            djset[rootOne].x = size * -1;
            djset[rootTwo].x = rootOne;
        }
        else if (sizeOne < sizeTwo)
        {
            djset[rootTwo].x = size * -1;
            djset[rootOne].x = rootTwo;
        }
        safeCount -= 1;
    }
}

