/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CustomData;

import java.util.ArrayList;

/**
 *
 * @author James
 */
public class Candidate implements Comparable<Candidate>
{

    private ArrayList<Vote> votes;
    private final int name;

    public Candidate (int name)
    {
        this.name = name;
        votes = new ArrayList<>();
    }

    public int addVote (Vote v)
    {
        if (v.isEmpty())
        {
            return -1;
        }
        int result = v.compareTo(name);
        if (result == 0)
        {
            votes.add(v);
        }
        return result;
    }

    public int countVotes ()
    {
        return votes.size();
    }

    public ArrayList<Vote> getVotes ()
    {
        return votes;
    }

    @Override
    public String toString ()
    {

        return "[" + name + ", " + votes.toString() + "]";
    }

    @Override
    public int compareTo (Candidate o)
    {
        int myCount = this.countVotes();
        int theirCount = o.countVotes();

        return Integer.compare(myCount, theirCount);
    }
}
