/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CustomData;

import java.util.Arrays;
import java.util.Collections;
import java.util.Stack;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author James
 */
public class Driver implements Runnable
{

    private static int NUMBER_OF_CANDIDATES;
    private static Driver instance = null;

    protected Driver (int numberOfCandidates)
    {
        Driver.NUMBER_OF_CANDIDATES = numberOfCandidates;
    }

    public static Driver getInstance (int numberOfCandidates)
    {
        if (instance == null)
        {
            instance = new Driver(numberOfCandidates);
        }
        return instance;
    }

    private Vote generateRandomVote ()
    {

        Stack<Integer> vote = new Stack<>();
        for (int i = 0; i < NUMBER_OF_CANDIDATES; i++)
        {
            vote.push(i);
        }
        Collections.shuffle(vote);
        return new Vote().setVote(vote);
    }

    @Override
    public void run ()
    {
        Candidate[] ballot = new Candidate[NUMBER_OF_CANDIDATES];
        for (int i = 0; i < ballot.length; i++)
        {
            ballot[i] = new Candidate(i);
        }
        Vote votes[] = new Vote[100];
        for (int i = 0; i < votes.length; i++)
        {
            votes[i] = generateRandomVote();
        }
        for (Vote vote : votes)
        {
            for (Candidate candidate : ballot)
            {
                candidate.addVote(vote);
            }
        }
        Arrays.sort(ballot);
        for (Candidate candidate : ballot)
        {
            System.out.println(candidate.toString());
        }
        
    }
}
