/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package preferencevote;

import java.util.ArrayList;

/**
 *
 * @author James
 */
public class Candidate implements Comparable<Candidate>
{
    private ArrayList<Vote> votes;
    private final String name;
    public Candidate (String name)
    {
        this.name = name;
    }
    public int addVote (Vote v)
    {
        int result = v.compareTo(name);
        if (result ==  0)
        {
            votes.add(v);
        }
        return result;
    }
    public int countVotes ()
    {
        return votes.size();
    }
    public ArrayList<Vote> reassignVotes ()
    {
        for (Vote vote : votes)
        {
            vote.incrementVote();
        }
        return votes;
    }

    @Override
    public int compareTo(Candidate o)
    {
        int myCount = this.countVotes();
        int theirCount = o.countVotes();
        
        return Integer.compare(myCount, theirCount);
    }
}
