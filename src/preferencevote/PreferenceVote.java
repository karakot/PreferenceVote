/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package preferencevote;

import java.util.Arrays;
import java.util.Collections;
import CustomData.Driver;

/**
 *
 * @author James
 */
public class PreferenceVote
{

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)
    {
        // TODO code application logic here
//        Integer[] a  = {1,2,3,4,5};
//        System.out.println(Arrays.toString(a));
//        Collections.shuffle(Arrays.asList(a));
//        System.out.println(Arrays.toString(a));
        Driver driver = Driver.getInstance(9);
        driver.run();
        
    }
    
}
