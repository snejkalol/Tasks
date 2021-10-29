import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Scanner;

class Main3 {
    public static void main(String args[]) throws NoSuchAlgorithmException, InvalidKeyException, UnsupportedEncodingException {
        ArrayList<String> move = new ArrayList<String>();
        ArrayList<String> check = new ArrayList<String>();
        for (String str : args) {
            if(check.contains(str)) {
                System.out.println("You have introduced duplicate items. Try to run the program again with unique parameters...");
                System.exit(0);
            } else {
                move.add(str);
                check.add(str);
            } 
        }
        if (move.size()<=1 || move.size()%2==0) {
            System.out.println("You have wrong count of items. Try to run the program again with unique parameters...");
            System.exit(0);
        }
        int ms=move.size();
        int counts = 0;
        String entry = "";
        System.out.print("Enter the rounds count (<=3, odd): ");
        Scanner scanner = new Scanner(System.in);
        String o="1";
        while (o=="1") {
            if(!scanner.hasNextInt() || scanner.nextInt()%2==0) {
                entry = scanner.next();
                System.out.print("That is not an integer or not an odd.  " + "Please try again: ");
            }
            else {
                System.out.print("Confirm your choice: ");
                counts = scanner.nextInt();
                o+=1;
            }
        }
        System.out.println("Available moves: ");
        for (int i=1; i<=move.size(); i++) {
            System.out.println(i+ " - " + move.get(i-1));
        }
        
                
        String[] headers = { "Comp move", "Man move", "Who won"};
        String[][] data = new String[counts][3]; //строка, столбец
        
        
        
        
        for (int i=0; i<counts; i++){
            String cmp, ppl, ww="";
            int choice;
     //       int bot=1;            
            int random_move = 0 + (int) (Math.random() * (move.size()-1)); // Генерация числа
            String s=Integer.toString(random_move);          
            HMAC.rhmacshow(HMAC.rhmac(s));
            System.out.print("Enter your choice: (press 777 to exit/911 for help...) ");
            choice = scanner.nextInt(); 
            if (choice == 777) {
                System.exit(0);
            }
            else if (choice == 911) {
                System.out.println();
                System.out.println("The computer makes the first move. After that, you make a choice," + 
                        " which figure to walk, using the numbers on the menu. Each element of the game "+
                        "wins 1/2 of the top of the elements, but loses 1/2 of all the elements of the bottom."+
                        " If, for example, your element is numbered 4 out of 5 possible, to determine the possibility"+
                        " of defeated elements, after the end of the list (number 5), you should continue counting"+
                        " from the beginning of the list (1 and 2). To start the game, please restart the program ...");
                System.out.println();
                System.exit(0);
            }
            else {
                choice -=1;
                System.out.println("Your choice: " + move.get(choice));
                System.out.println("Computer's move: " + move.get(random_move));
                Rules4win.calculate(ms, choice, random_move);
                cmp=move.get(random_move);
                ppl=move.get(choice);
                if (Rules4win.rez[2]==0) {
                    ww= "DRAW!";
                }     
                else if (Rules4win.rez[2]==1) {
                    ww= "Comp win!";
                }
                else if (Rules4win.rez[2]==2) {
                    ww= "You win!";
                }
                System.out.println(ww);
                data[i][0]=cmp;
                data[i][1]=ppl;
                data[i][2]=ww;
                Sha256.rkeyshow(Sha256.rkey());
               
                }
            }
            Tableshow.ts(headers, data);
    }
}
