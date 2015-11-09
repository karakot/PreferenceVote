/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package preferencevote;

import java.util.EmptyStackException;
import java.util.Random;
import java.util.Stack;
/**
 *
 * @author James
 */
public class Vote implements Comparable<String>
{
    private Stack<String> vote;
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
    public void setVote (Stack<String> vote)
    {
        this.vote = (Stack<String>) vote.clone();
    }
    public String peekNextPreference()
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
    public int compareTo(String name)
    {
        return peekNextPreference().compareTo(name);
    }
}
