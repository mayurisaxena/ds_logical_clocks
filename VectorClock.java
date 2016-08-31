import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class VectorClock {
    public int[] v;
    int myId;
    int N;
    public VectorClock(int numProc, int id) {
        myId = id;
        N = numProc;
        v = new int[numProc];
        for (int i = 0; i < N; i++) v[i] = 0;
        v[myId] = 0;
    }
    public void tick() {
        v[myId]++;
    }
    public void sendAction() {
        //include the vector in the message
        v[myId]++;
    }
    public void receiveAction(int[] sentValue) {
        for (int i = 0; i < N; i++)
            v[i] = Util.max(v[i], sentValue[i]);
        v[myId]++;
    }
    public int getValue(int i) {
        return v[i];
    }
    public String toString(){
        return Util.writeArray(v);
    }
    
    
    public static void main (String args[])
    {
    	List vc= new ArrayList<VectorClock>(10);
    	System.out.println("Enter number of processes :");
    	
    	
    	Scanner in = new Scanner(System.in);
    	int i = in.nextInt();
    	
    	for (int j= 0; j<i;j++)
    	{
    		vc.add(j, new VectorClock(i,j)) ;
    		
    	}
    	
    	
    	System.out.println("Enter number of messages :");
    	Scanner in1 = new Scanner(System.in);
    	int i1 = in1.nextInt();
    	
    	for (int k=0; k<i1;k++)
    	{
    		System.out.println("Enter sending process id : ");
    		int s = in1.nextInt();
    		System.out.println("Enter receiving process id : ");
    		int r = in1.nextInt();
    		
    		System.out.println("if sending process and receiving process ids are same then its an individual event");
    		
    		
    		if(r==s)  ((VectorClock) vc.get(s)).tick();
    		//((VectorClock) vc.get(s)).tick();
    		else {
    		((VectorClock) vc.get(s)).sendAction();
    		
    		
    		
    		((VectorClock) vc.get(r)).receiveAction(((VectorClock) vc.get(s)).v); }
    		
    		System.out.println("Scenario after message :  " + k);
    		System.out.println("Message sent from :" + s + "  to : " + r);
    		
    		System.out.println("");
    		System.out.println("");
    		
    		for (int j= 0; j<i;j++)
        	{
    			System.out.print("Process: "+j + "  Value:  ");
    			for(int h=0; h<i;h++)
        		System.out.print(((VectorClock) vc.get(j)).v[h] + ",") ;
        		
    			System.out.println();
        	}
    		
    	   		
    		
    	}
    	
    	System.out.println("Simulation Ended !!!!!" );
    		
    	
    }
    
    
}
