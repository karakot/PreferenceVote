/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CustomData;

import java.util.ArrayList;
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
    private static Candidate[] ballot;

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
    
    private Vote[] generateRandomVoteList (int numberOfVotes)
    {
        Vote voteList[] = new Vote[numberOfVotes];
        for (int i = 0; i < voteList.length; i++)
        {
            voteList[i] = generateRandomVote();
        }
        return voteList;
    }

    private void reallocateVotes (ArrayList<Vote> votes)
    {
        for (Vote vote : votes) // for every vote in the votes to be reallocated
        {
            int result = -1;
            while (result != 0)
            {
                vote.incrementVote(); // the votes should not be incremented before this point
                if (vote.isEmpty())
                {
                    break;
                }
                for (Candidate candidate : ballot)
                {
                    result = candidate.addVote(vote); //check if the new vote can be entered in the current list of candidates enter if possible
                    if (result == 0) // if a candidate is found then stop searching for candidates
                    {
                        break;
                    }
                }
            } 
        }
        Arrays.sort(ballot);
    }

    private int calculateWinner ()
    {
        int result = -1;
        if (ballot == null)
        {
            return result;
        }
        while (ballot.length != 2)
        {
            Candidate loser = ballot[0];
            ballot = Arrays.copyOfRange(ballot, 1, ballot.length);
            reallocateVotes(loser.getVotes());
        }
        return result;
       
    }

    @Override
    public void run ()
    {
        ballot = new Candidate[NUMBER_OF_CANDIDATES];
        for (int i = 0; i < ballot.length; i++)
        {
            ballot[i] = new Candidate(i);
        }
        Vote votes[] = generateRandomVoteList(100);
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
        System.out.println("");
        calculateWinner();
        System.out.println("");
        for (Candidate candidate : ballot)
        {
            System.out.println(candidate.toString());
        }
        
        
    }
}
