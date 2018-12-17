import java.util.Scanner;

public class FracCalc {

    /**
     * Prompts user for input, passes that input to produceAnswer, then outputs the result.
     * @param args - unused
     */
	
	public static String f1;
	public static String op;
	public static String f2;
	public static int w1;
	public static int w2;
	public static int n1;
	public static int n2;
	public static int d1;
	public static int d2;
	
    public static void main(String[] args) 
    {
        // TODO: Read the input from the user and call produceAnswer with an equation
        // Checkpoint 1: Create a Scanner, read one line of input, pass that input to produceAnswer, print the result.
    	 /**Scanner console= new Scanner(System.in);
    	 System.out.println("Enter a value");
    	 String x= console.next();
    	 produceAnswer(x);*/
        // Checkpoint 2: Accept user input multiple times.
    	System.out.println("Welcome to the Fraction calculator!");
        Scanner console = new Scanner(System.in);
         System.out.print("Enter an expression (or \"quit\"): ");
        //get the first fraction, or quit
         f1 = console.next();
	    //test fraction1 to see if the user types "quit"
	    if(f1.equalsIgnoreCase("quit")){
	       System.out.println("Goodbye!");
	    }
	    while(!f1.equalsIgnoreCase("quit")){
	       op = console.next();
	       f2 = console.next();
	       processFractions(f1, op, f2);
	       System.out.print("Enter an expression (or \"quit\"): ");
	       f1 = console.next();
	       if(f1.equalsIgnoreCase("quit")){
	       System.out.println("Goodbye!");
	       }
	    }//end while loop
	     //while loop continues the calc until the user types "quit"
	      }//end of main
    
    /**
     * produceAnswer - This function takes a String 'input' and produces the result.
     * @param input - A fraction string that needs to be evaluated.  For your program, this will be the user input.
     *      Example: input ==> "1/2 + 3/4"
     * @return the result of the fraction after it has been calculated.
     *      Example: return ==> "1_1/4"
     */
    
        // TODO: Implement this function to produce the solution to the input
        // Checkpoint 1: Return the second operand.  Example "4/5 * 1_2/4" returns "1_2/4".
    	
        // Checkpoint 2: Return the second operand as a string representing each part.
        //               Example "4/5 * 1_2/4" returns "whole:1 numerator:2 denominator:4".
    	
        // Checkpoint 3: Evaluate the formula and return the result as a fraction.
        //               Example "4/5 * 1_2/4" returns "6/5".
        //               Note: Answer does not need to be reduced, but it must be correct.
        // Final project: All answers must be reduced.
        //               Example "4/5 * 1_2/4" returns "1_1/5".
    public static void processFractions(String f1, String op, String f2){
    	  //get int variables from fractions

    	  //testing fraction 1 to get int values
    	    if(f1.contains("_")){ //testing for mixed number
    	     w1=Integer.parseInt(f1.substring(0,f1.indexOf("_")));
    	     n1=Integer.parseInt(f1.substring(f1.indexOf("_")+1,f1.indexOf("/")));
    	     d1=Integer.parseInt(f1.substring(f1.indexOf("/")+1));
    	     n1=(w1*d1)+n1; //making mixed number improper
    	  } else if(f1.contains("/")) { //testing for fraction
    	     n1=Integer.parseInt(f1.substring(0,f1.indexOf("/")));
    	     d1=Integer.parseInt(f1.substring(f1.indexOf("/")+1));
    	  } else {//testing for whole number
    	     w1=Integer.parseInt(f1.substring(0));
    	     n1=w1;
    	     d1=1;
    	  }//end if, else if, else method

    	  //testing fraction 2 to get int values 
    	  if(f2.contains("_")){ //mixed fraction
    	     w2=Integer.parseInt(f2.substring(0,f2.indexOf("_")));
    	     n2=Integer.parseInt(f2.substring(f2.indexOf("_")+1,f2.indexOf("/")));
    	     d2=Integer.parseInt(f2.substring(f2.indexOf("/")+1));
    	     n2=w2*d2+n2;  
    	  } else if(f2.contains("/")) { //fraction 
    	     n2=Integer.parseInt(f2.substring(0,f2.indexOf("/")));
    	     d2=Integer.parseInt(f2.substring(f2.indexOf("/")+1));
    	  } else { //whole number 
    	     w2=Integer.parseInt(f2.substring(0));
    	     n2=w2;
    	     d2=1;
    	  }//end if, else if, else method


    	  dotheMath(n1, n2, d1, d2, op);

    	   }//end processFraction method    

    	//dotheMath detmerines the operator 
    	 public static void dotheMath(int n1, int n2, int d1, int d2, String op) {
    	   if(op.equals("+")){
    	       System.out.println(add(n1, n2, d1, d2));     
    	    } else if(op.equals("-")) { 
    	       n2=-1*n2;
    	       System.out.println(add(n1, n2, d1, d2)); 
    	    } else if(op.equals("*")) {
    	       System.out.println(multiply(n1, n2, d1, d2));
    	    } else { 
    	       int x = n2;
    	       int y = d2;
    	       d2=x;
    	       n2=y;
    	       System.out.println(multiply(n1, n2, d1, d2));
    	    } //end the if, else if, else statement

    	 }//end dotheMath method


    	 public static String add(int n1, int n2, int d1, int d2) {
    		    int newn = (n1*d2) + (n2*d1);
    		    int newd = d1*d2;

    		    int divisor = reduce(newn, newd);
    		    newn/=divisor;
    		    newd/=divisor;
    		    int integerComponent=0;

    		    while(newn >= newd) {
    		        integerComponent++;
    		        newn-=newd;
    		    }
    		    String answer ="";
    		    if(integerComponent>0) {
    		        answer += integerComponent +"_";
    		    }
    		    if(newn!=0) {
    		        answer += newn+"/"+newd;
    		    }
    		    return answer;
    	 }//end add method


    	 public static String multiply(int n1, int n2, int d1, int d2) {
    		    int newn = n1*n2;
    		    int newd = d1*d2;

    		    int divisor = reduce(newn, newd);
    		    newn/=divisor;
    		    newd/=divisor;

    		    int integerComponent=0;

    		    while(newn >= newd) {
    		        integerComponent++;
    		        newn-=newd;
    		    }
    		    String answer ="";
    		    if(integerComponent>0) {
    		        answer += integerComponent +"_";
    		    }
    		    if(newn!=0) {
    		        answer += newn+"/"+newd;
    		    }
    		    return answer;
    	 }//end multiply method  


    	 public static int lcd(int n1,int d1, int n2, int d2){
    	   int dividend=(d1*n2)+(n1*d2); 
    	   int divisor = d1*d2;
    	   int rem = dividend % divisor;
    	   while (rem != 0){
    	     dividend = divisor;
    	     divisor = rem;
    	     rem = dividend % divisor;
    	  }  

    	 return divisor;
    	   } //end lcd   


    	public static int reduce (int newn, int newd) { //
    	int newn_abs = Math.abs (newn);
    	int newd_abs = Math.abs (newd); //

    	 int min_num = Math.min (newn_abs, newd_abs);

    	int divisor = 1;

    	for (int i = 1; i <= min_num; i++) {
    	 if (newn%i == 0 && newd%i == 0){

    	 divisor = 1;
    	 }//end if 
    	   }//end for
    	   return divisor;

    	}//end reduce 
 

    // TODO: Fill in the space below with helper methods
    
    /**
     * greatestCommonDivisor - Find the largest integer that evenly divides two integers.
     *      Use this helper method in the Final Checkpoint to reduce fractions.
     *      Note: There is a different (recursive) implementation in BJP Chapter 12.
     * @param a - First integer.
     * @param b - Second integer.
     * @return The GCD.
     */
    public static int greatestCommonDivisor(int a, int b)
    {
        a = Math.abs(a);
        b = Math.abs(b);
        int max = Math.max(a, b);
        int min = Math.min(a, b);
        while (min != 0) {
            int tmp = min;
            min = max % min;
            max = tmp;
        }
        return max;
    }
    
    /**
     * leastCommonMultiple - Find the smallest integer that can be evenly divided by two integers.
     *      Use this helper method in Checkpoint 3 to evaluate expressions.
     * @param a - First integer.
     * @param b - Second integer.
     * @return The LCM.
     */
    public static int leastCommonMultiple(int a, int b)
    {
        int gcd = greatestCommonDivisor(a, b);
        return (a*b)/gcd;
    }
}
