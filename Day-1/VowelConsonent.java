import java.util.Scanner;
public class VowelConsonent{
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        String str=sc.nextLine();
        char ch;
        int vowelscount=0;
        int consonantcount=0;
        for(int i=0;i<str.length();i++){
            ch=str.charAt(i);
            if(ch=='a'||ch=='e'||ch=='i'||ch=='o'||ch=='u'){
                vowelscount++;
            }
            else{
                consonantcount++;
            }
            }

        
        System.out.println("vowels count"+vowelscount);
        System.out.println("Consonants count"+consonantcount);

    }
}