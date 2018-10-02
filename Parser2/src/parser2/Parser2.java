package parser2;
import java.util.Scanner;
public class Parser2 {
    static int currentIndex = 0;
    static char currentChar;
    static String input;
    static int leftB = 0;
    static int rightB = 0;
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        int in = 1;
        System.out.println("Enter a string that follows the context free grammer:\n"
                + "Assume that token has taken care of number use 'n' for numbbers");
        input = reader.next();
        currentChar = input.charAt(currentIndex);          
        boolean status = set();
        if(status == true)
            System.out.println("Valid");
        else
            System.out.println("Invalid");        
    }
    static boolean set(){
        if(currentChar != '{')
            return false;
        if('}' != input.charAt(input.length()-1))
            return false;
        leftB++;
        list();
        System.out.println(leftB + " " + rightB);
        if(leftB != rightB)
            return false;
        if(currentIndex != input.length()-1)
            return false;
        return true;
    }    
    static boolean list(){
        if(inc() != true)return false;
        if(currentChar == '}'){
            rightB++;
            return true;
        }
        if(head() != true)
            return false;
        if(tail() != true)
            return false;
        return true;
    }   
    static boolean head(){       
        if(currentChar == '{')
            set();
        if(currentChar == 'n' || currentChar == '}')           
            return true;
        return false;
    }   
    static boolean tail(){
        while(leftB != rightB){
            if(inc() != true)return false;
            if(currentChar == '}'){
                rightB++;
            }
            if(currentChar == ','){
                if(inc() != true)return false;
                if(head() != true) return false;
                if(tail() != true) return false;
            }
            else{
                return false;
            }                       
        }
        return true;
    } 
    static boolean inc(){
       if(currentIndex != input.length()-1) {
            currentIndex++;
            currentChar = input.charAt(currentIndex);   
            return true;
        }
        return false;
    }
}
