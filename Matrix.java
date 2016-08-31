import java.util.*;

public class Matrix {
       
    
	public static void main(String []args)
    {
		
		System.out.print("enter no. of processes in system");
    	Scanner in = new Scanner(System.in);
    	int n = in.nextInt();
    	
    	List obj= new ArrayList<MatrixClock>(); 
    	for (int j= 0; j<n;j++)
    	{
    		obj.add(new MatrixClock(n,j));
    		
    	}
    	
    	
    	/*for(int i=0;i<n;i++)
    	{
    		obj.set(i, new MatrixClock(n,i));
       	} */
    	
    	System.out.print("testing");
    	/*MatrixClock obj1 = new MatrixClock(4,0);
    	MatrixClock obj2 = new MatrixClock(4,1);
    	MatrixClock obj3 = new MatrixClock(4,2);
    	MatrixClock obj4 = new MatrixClock(4,3);
    	*/
    	
    	//obj.get(1).sendAction();
    	/*obj1.sendAction();
    	obj2.receiveAction(obj1.M, 0);
    	
    	for (int i = 0; i <4; i++)
    	{  for (int j = 0; j < 4; j++)
            	System.out.print(obj2.M[i][j]);
    	
    	System.out.println();}
    	
    	System.out.println();
    	
    	obj2.sendAction();
    	obj4.receiveAction(obj2.M, 1);
    	
    	for (int i = 0; i <4; i++)
    	{  for (int j = 0; j < 4; j++)
            	System.out.print(obj4.M[i][j]);
    	
    	System.out.println();}
    	
    	System.out.println();
    	
    	obj1.sendAction();
    	obj3.receiveAction(obj1.M, 0);
 
    	for (int i = 0; i <4; i++)
    	{  for (int j = 0; j < 4; j++)
            	System.out.print(obj3.M[i][j]);
    	
    	System.out.println();}
    	
    	System.out.println();
    	
    	obj3.sendAction();
    	obj1.receiveAction(obj3.M, 2);
    	
    	for (int i = 0; i <4; i++)
    	{  for (int j = 0; j < 4; j++)
            	System.out.print(obj1.M[i][j]);
    	
    	System.out.println();}
    	
    	System.out.println();
    	
    	obj3.sendAction();
    	obj4.receiveAction(obj3.M, 2);
    	
    	for (int i = 0; i <4; i++)
    	{  for (int j = 0; j < 4; j++)
            	System.out.print(obj4.M[i][j]);
    	
    	System.out.println();}
    	
    	*/
    	
    	
    	System.out.println("Enter number of messages :");
    	Scanner in1 = new Scanner(System.in);
    	int i1 = in1.nextInt();
    	
    	for (int k=0; k<i1;k++)
    	{
    		System.out.println("Enter sending process id : ");
    		int s = in1.nextInt();
    		
    		((MatrixClock) obj.get(s)).sendAction();
    		
    		System.out.println("Enter receiving process id : ");
    		int r = in1.nextInt();
    		
    		((MatrixClock) obj.get(r)).receiveAction(((MatrixClock) obj.get(s)).M , s);
    		
    		
    		for (int j = 0; j <n; j++)
        	{  for (int h = 0; h < n; h++)
                	System.out.print(((MatrixClock)obj.get(r)).M[j][h]);
        	
        	System.out.println();}
        	
    	}
    	
    }

   
}

