/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejerciciosenlinea.lab2.juancamiloguerreroalarcon.santiagopulgarinvasquez;

/**
 *
 * @author JuanCamiloGuerreroAlarcon && SantiagoPulgarinVasquez
 */
public class EjerciciosEnLineaLab2 {   
/* 
Array2
*/

 public int countEvens(int[] nums) {
        int count = 0; //Constante
        for (int i : nums){ //Constante + T(n+1)*Constante
            if (i % 2 == 0) //Constante*n
                count ++; //Constante
        }
        return count; //Constante
    }

 public boolean has22(int[] nums) {

        for (int i = 0; i < nums.length - 2; i++){ //Constante + T(n+1)*Constante
            if(nums[i] == 2 && nums[i + 1] == 2) //Constante*n 
                return true; //Constante
        }
        return false; //Constante
    }
 
 public int bigDiff(int[] nums) {
    int maximo = nums[0]; //Constante
    int minimo = nums[0]; //Constante
   
    for (int i = 0; i < nums.length; i++) { //Constante + T(n+1)*Constante
        if (nums[i] > maximo){ //Constante*n 
            maximo = nums[i]; //Constante
        }
        if (nums[i] <= minimo){ //Constante*n
            minimo = nums[i]; //Constante
        }
    }
    return maximo - minimo; //Constante
}
 
public int sum13(int[] nums) {
    int cont = 0; //Constante
    for (int i = 0; i < nums.length; i++) { //Constante + T(n+1)*Constante
        if (nums[i] != 13){  // Constante*n
            cont += nums[i]; //Constante
        }
        else if (i <= nums.length - 1){ //Constante*n
            i++; //Constante
        }
    }
    return cont; //Constante
}

public boolean lucky13(int[] nums) {
    for (int i = 0; i < nums.length; i++){ //Constante + T(n+1)*Constante
        if (nums[i] == 1 || nums[i] == 3){ //Constante*n
            return false; //Constante
        }
    }
    return true; //Constante
}

 /*
 Array3
 */

public int maxSpan(int[] nums) {
    int count = 0; //Constante
    int temp = 0; //Constante
    for(int i = 0; i < nums.length; i++ ){ //Constante + T(n+1)*Constante
        for(int j = i; j < nums.length; j++) //(Constante + T(n+1)*Constante)*n
            if(nums[i] ==nums[j]){  //(Constante + T(n+1)*Constante)*n 
                temp = (j-i)+1;  //Constante
                if (temp > count){ //Constante
                    count = temp; //Constante
                    temp =0; //Constante
                }
                temp = 0;  //Constante
            }
    }
    return count; //Constante
}

public int[] fix34(int[] nums) {
    int temp = 0; //Constante
    for(int i = 0; i < nums.length;i++){ //Constante + T(n+1)*Constante
        if( nums[i] == 4 && nums[i-1] != 3){ // Constante*n
            for(int j=0; j < nums.length-1;j++){ // (Constante + T(n+1)*Constante)*n
                if(nums[j]== 3 && nums[j + 1] != 4){ // (Constante + T(n+1)*Constante)*n
                    temp = nums[j+1]; // Constante
                    nums[j + 1] = nums[i]; //Constante
                    nums[i] = temp; //Constante
                }
            }
        }
    }
    return nums; // Constante
}
/*
 * Title : fix45
    Autor : Anonymous
    date  : 2013
    version : 1.0
    Availability : https://gregorulm.com
 * */

public int[] fix45(int[] nums) {
    for (int i = 0; i < nums.length; i++) //Constante + T(n+1)*Constante
        if (nums[i] == 5 && i == 0 // Constante*n
                || nums[i] == 5 && nums[i - 1] != 4) {
            int pos5 = i; //Constante*n
            for (int j = 0; j < nums.length; j++) //(Constante + T(n+1)*Constante)*n
                if (nums[j] == 4 && nums[j + 1] != 5) { //(Constante + T(n+1)*Constante)*n
                    int temp = nums[j + 1]; //Constante
                    nums[j + 1] = 5;  //Constante
                    nums[pos5] = temp; //Constante
                    break; //Constante
                }
        }
    return nums; //Constante
}

public boolean canBalance(int[] nums) {
    for (int i = 0; i < nums.length; i++) {  //Constante + T(n+1)*Constante
        int cont = 0; // Constante*n
        for (int j = 0; j < i; j++){ //(Constante + T(n+1)*Constante)*n 
            cont += nums[j]; //Constante*n
        }
        for (int j = i; j < nums.length; j++){ // (Constante + T(n+1)*Constante)*n
            cont -= nums[j]; //Constante*n
        }
        if (cont == 0){  //Constante
            return true; //Constante
        }
    }
    return false; //Constante
}

public int[] squareUp(int n) {
    int[] square = new int[n * n]; //Constante
    int cont = 0; //Constante
  
    for (int i = 1; i<= n; i++) { //Constante + T(n+1)*Constante
        for (int k = 1; k<= n - i; k++){  //(Constante + T(n+1)*Constante)*n
            square[cont++] = 0; //Constante*n
        }
        for (int j = i; j<0; j--){ //(Constante + T(n+1)*Constante)*n
            square[cont++] = j; //Constante*n
        }
    }
    return square; //Constante
}

}


