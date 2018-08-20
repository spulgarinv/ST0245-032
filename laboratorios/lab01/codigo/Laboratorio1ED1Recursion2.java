/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package laboratorio1.ed1.recursion2;

/**
 *
 * @author spulgarinv && jcguerrera
 */
public class Laboratorio1ED1Recursion2 {
     
    public static void main(String[] args) {
       /*Scanner sc = new Scanner(System.in);
        System.out.println(" Ingrese el limite de la secuencia fibonacci");
        int limite = sc.nextInt();
            for (int  i = 0;  i <= limite;  i++) {
                System.out.print(fibonacci(i) + ", " );  */
        }

    /*
    Ejercicio fibonacci codingbat recursion 1
    */
    
    public static int fibonacci(int n){
        
        if (n==0 || n == 1)
            return n;
          
        return fibonacci(n-1) + fibonacci(n-2);
       
    }

    /*
    Ejercicio sumDigits codingbat recursion 1
    */
    public int sumDigits(int n) { 
       return  n < 10 ? n : sumDigits(n % 10) + sumDigits(n / 10);
    }

    
    /*
    Ejercicio count7 codingbat recursion 1
    */
    public int count7(int n) {
        if(n == 0)                     
            return 0;                  
        if (n % 10 == 7)               
            return 1 + count7(n/10);    
  
        return count7(n/10);          
  
    }

    /*
    Ejercicio factorial codingbat recursion 1
    */
    public int factorial(int n) {
         if (n <=2)
            return n;
        return n * factorial(n-1);  
    }

    /*
    Ejercicio CountX codingbat recursion 1
    */
    public int countX(String str) {
         if(str.length() == 0)
             return 0;
        if (str.charAt(0)== 'x')
             return 1 + countX(str.substring(1, str.length()));
  
        return countX(str.substring(1, str.length()));
    }

    /*
    Ejercicio CountHi codingbat recursion 1
    */
    
    public int bunnyEars(int bunnies) {
         if (bunnies == 0)return 0;
  
        return 2 + bunnyEars(bunnies -1);
    }
  
    /** public int countHi(String str) {
         if (str.length() < 2) return 0;
         if (str.charAt(0) == 'h' && str.charAt(1) == 'i') 
             return 1 + countHi(str.substring(2));
        return countHi(str.substring(1));
    }  
    **/

    
    /*
    Ejercicio groupSum5 codingbat recursion 2
    */
    
    public boolean groupSum5(int start, int[] nums, int target) {
        if (start >= nums.length) {                                                    
            return target == 0;                                                           
        }
        if (nums[start] % 5 == 0) {                                                    
            if (start < nums.length - 1 && nums[start + 1] == 1  ) {                    
                return groupSum5(start + 2, nums, target - nums[start]);           
            } else {
                return groupSum5(start + 1, nums, target - nums[start]);         
            }
        }
        return groupSum5(start + 1, nums, target - nums[start]) ||   groupSum5(start + 1, nums, target);                
    }

    /*
    Ejercicio groupSum6 codingbat recursion 2
    */
    
   public boolean groupSum6(int start, int[] nums, int target) {
        if (start >= nums.length) {                     
            return target == 0;                             
        }
        if (nums[start] == 6) {                           
            return groupSum6(start + 1, nums, target - nums[start]);    
        }
        return groupSum6(start + 1, nums, target - nums[start]) || groupSum6(start + 1, nums, target);  
    }

   
   /*
   Ejercicio groupNoAdj codingbat recursion 2
   */
   
   public boolean groupNoAdj(int start, int[] nums, int target) {
        if (start >= nums.length) {                   
            return target == 0;                           
        }
        if (groupNoAdj(start + 1, nums, target)) {                 
            return true;                                                                
        }
        if (groupNoAdj(start + 2, nums, target - nums[start])) {     
            return true;                            
        }
        return false;                               
    }

   
   /*
   Ejercicio split53 codingbat recursion 2
   */
   
   
   public boolean split53(int[] nums) {
  return helper1(0, nums, 0, 0);
}

public boolean helper1 (int start, int [] nums, int suma1, int suma2) {
  if (start >= nums.length) {                           
    return suma1 == suma2;                         
  }
  if (nums[start] % 5 == 0) {                         
    return helper1(start + 1, nums, suma1 + nums[start], suma2);  
  }
  if (nums[start] % 3 == 0) {                         
    return helper1(start + 1, nums, suma1, suma2 + nums[start]);           
  }
  return helper1(start + 1, nums, suma1 + nums[start], suma2) || helper(start + 1, nums, suma1, suma2 + nums[start]);   
}


/*
Ejercicio splitOdd10 codingbat recursion 2
*/


public boolean splitOdd10(int[] nums) {
  return helper2(0, nums, 0, 0);
}

public boolean helper2 (int start, int [] nums, int suma1, int suma2) {
  if (start >= nums.length) {                          
    return suma1 % 10 == 0 && suma2 % 2 == 1 || suma1 % 2 == 1 && suma2 % 10 == 0;  
   
  }
  return helper2(start + 1, nums, suma1 + nums[start], suma2) || helper2(start + 1, nums, suma1, suma2 + nums[start]);  
}


    
}
