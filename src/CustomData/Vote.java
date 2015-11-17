/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CustomData;

import java.util.EmptyStackException;
import java.util.Random;
import java.util.Stack;
/**
 *
 * @author James
 */
public class Vote implements Comparable<Integer>
{
    private Stack<Integer> vote;
    private final int voterID; 
    public Vote ()
    {
        voterID = (new Random(System.currentTimeMillis())).nextInt();
    }
    public Vote (int ID, Stack vote)
    {
        voterID = ID;
        this.vote = vote;        
    }
    public Vote setVote (Stack<Integer> vote)
    {
        this.vote = (Stack<Integer>) vote.clone();
        return this;
    }
    public int peekNextPreference()
    {
        return this.vote.peek();
    }
    public int incrementVote ()
    {
        try 
        {
            this.vote.pop();
            return 0;
        }
        catch (EmptyStackException ese)
        {
            return -1;
        }
    }

    @Override
    public int compareTo(Integer name)
    {
        return Integer.compare(this.peekNextPreference(), name);
    }
}
