/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CustomData;

import java.util.Arrays;
import java.util.Collections;
import java.util.Stack;

/**
 *
 * @author James
 */
public class Driver implements Runnable 
{
    private static int NUMBER_OF_CANDIDATES;
    private static Driver instance = null;
    protected Driver(int numberOfCandidates)
    {
        Driver.NUMBER_OF_CANDIDATES = numberOfCandidates;
    }
    public static Driver getInstance(int numberOfCandidates)
    {
        if (instance == null)
        {
            instance = new Driver(numberOfCandidates);
        }
        return instance;
    }
    private Vote generateRandomVote()
    {
        Integer candidate[] = new Integer[NUMBER_OF_CANDIDATES] ;
        for (int i = 0; i < NUMBER_OF_CANDIDATES; i++)
        {
           candidate[i] = i;
        }
        Collections.shuffle(Arrays.asList(candidate));
        return new Vote().setVote((Stack<Integer>) Arrays.asList(candidate));
    }

    @Override
    public void run()
    {
        
    }
    
}
