public class Rules4win {
    public static int rez[];
    public static int who=4;
    public static void calculate (int ms,int choice, int random_move ) {
        int prom;
        rez = new int[3];
            int steps = (ms-1)/2;
            for (int k=1; k<=steps; k++) {
                if (random_move==choice){
                    who=0;
                }
                else if ((random_move+k)>(ms-1)) {
                    prom=random_move+k-ms;
                    if (prom+k==choice) {
                        who=1;
                    }
                    else {
                        who=2;
                    }
                }
                else if ((random_move+k)<(ms-1)) {
                    if (random_move+k==choice) {
                        who=2;
                    }
                    else {
                        who=1;
                    }
                }
                else if ((random_move+k)==(ms-1)) {
                    if (random_move-k==choice) {
                        who=1;
                    }
                    else {
                        who=2;
                    }                  
                }
                break;
            }
        rez[2]=who;  
        }       // кто победил  
}
