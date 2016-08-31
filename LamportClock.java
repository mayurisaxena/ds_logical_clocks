import java.util.*;
import java.io.*;


public class LamportClock {
    int c;
    public LamportClock() {
        c = 1;
    }
    public int getValue() {
        return c;
    }
    public void tick() { // on internal events
        c = c + 1;
    }
    public void sendAction() {
       // include c in message
        c = c + 1;      
    }
    public void receiveAction(int src, int sentValue) {
        c = Util.max(c, sentValue) + 1;
    }
    
    public static void main (String args[])
    {
    	List lc= new ArrayList<LamportClock>(10);
    	System.out.println("Enter number of processes :");
    	
    	for (int j= 0; j<20;j++)
    	{
    		lc.add(new LamportClock());
    		
    	}
    	
    	Scanner in = new Scanner(System.in);
    	int i = in.nextInt();
    	
    	for (int j= 0; j<i;j++)
    	{
    		lc.set(j, new LamportClock()) ;
    		
    	}
    	
    	
    	System.out.println("Enter number of messages :");
    	Scanner in1 = new Scanner(System.in);
    	int i1 = in1.nextInt();
    	
    	for (int k=0; k<i1;k++)
    	{
    		System.out.println("Enter sending process id : ");
    		int s = in1.nextInt();
    		
    		//((LamportClock) lc.get(s)).tick();
    		((LamportClock) lc.get(s)).sendAction();
    		System.out.println("Enter receiving process id : ");
    		int r = in1.nextInt();
    		
    		((LamportClock) lc.get(r)).receiveAction(s,((LamportClock) lc.get(s)).getValue());
    		
    		System.out.println("Scenario after message :  " + k);
    		System.out.println("Message sent from :" + s + "  to : " + r);
    		
    		System.out.println("");
    		System.out.println("");
    		
    		for (int j= 0; j<i;j++)
        	{
        		System.out.println("Process: "+j + "  Value:  " + ((LamportClock) lc.get(j)).getValue()) ;
        		
        	}
    	
    	}
    	
    	System.out.println("Simulation Ended !!!!!" );
 }
    
  
}
