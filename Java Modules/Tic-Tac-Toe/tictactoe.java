import java.util.Scanner;
public class tictactoe {
    public static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        
        String str = "_________";
        printBoard(str);
        int count = 0;
        
        while (true)
        {
            if (isImpossible(str))
                System.out.println("Impossible");
            else
            {
                char won = wonBy(str);
                if (won == 'N')
                {
                    if (isOver(str)) {
                        System.out.println("Draw");
                        break;
                    }
                    else{
                        count++;
                        if (count % 2 == 1 )
                        {
                            str = makeMove(str, 'X');    
                        }
                        else
                        {
                            str = makeMove(str, 'O');
                        }
                        
                        
                        printBoard(str);
                        continue;
                    }
                        //System.out.println("Game not finished");
                }
                else
                {
                    System.out.println(won + " wins");
                    break;
                }
            }
        }   
    }
    
    static void printBoard(String str){
        System.out.println("---------");
        for (int i = 0; i < 3; i++)
        {
            System.out.print("| ");
            for (int j = 0; j < 3; j++)
                System.out.print(str.charAt(( i * 3) + j)+" ");
            System.out.println("|");
        }
        System.out.println("---------");
    }
    
    static boolean isImpossible(String str){
        char[] string = str.toCharArray();
        int x =0, o = 0;
        for (char i : string)
        {
            if (i == 'X')
                x++;
            if ( i == 'O')
                o++;
        }
        char won = 'n';
        char[][] board = new char[3][];
        board[0] = new char[] {string[0], string[1], string[2]};
        board[1] = new char[] {string[3], string[4], string[5]};
        board[2] = new char[] {string[6], string[7], string[8]};
        
        if ((board[0][0] == board[1][1]) && (board[1][1]==board[2][2]) && (board[0][0] != '_')) 
        {
            if ((won != 'n') && (won != board[0][0]))
                return true;
            else if (won == 'n')
                won = board[0][0];
        }
        else if ((board[0][2] == board[1][1]) && (board[1][1]==board[2][0]) && (board[0][2] != '_'))
        {
            if ((won != 'n') && (won != board[0][2]))
                return true;
                else if (won == 'n')
                won = board[0][2];
        }
            
        
        for (int i = 0; i < 3; i++){
            int j=0;
            if ((board[i][j]==board[i][j+1]) && (board[i][j+1]==board[i][j+2]) && (board[i][j] != '_'))
            {
                if ((won != 'n') && (won != board[i][j]))
                    return true;
                else if (won == 'n')
                    won = board[i][j];
            }
        }
        
        for (int j = 0; j < 3; j++){
            int i=0;
            if ((board[i][j]==board[i+1][j]) && (board[i+1][j]==board[i+2][j]) && (board[i][j] != '_'))
            {
                if ((won != 'n') && (won != board[i][j]))
                    return true;
                else if (won == 'n')
                    won = board[i][j];
            }

        }
    
        if (x == o || (x - o) == 1 || (o - x) == 1)
            return false;
        else
            return true;
    }
    
    static char wonBy(String str){
        char[] string = str.toCharArray();
        char[][] board = new char[3][];
        board[0] = new char[] {string[0], string[1], string[2]};
        board[1] = new char[] {string[3], string[4], string[5]};
        board[2] = new char[] {string[6], string[7], string[8]};
        
        if ((board[0][0] == board[1][1]) && (board[1][1]==board[2][2]) && (board[0][0] != '_'))
            return board[0][0];
        else if ((board[0][2] == board[1][1]) && (board[1][1]==board[2][0]) && (board[0][2] != '_'))
            return board[0][2];
        
        for (int i = 0; i < 3; i++){
            int j=0;
            if ((board[i][j]==board[i][j+1]) && (board[i][j+1]==board[i][j+2]) && (board[i][j] != '_'))
                return board[i][j];
        }
    
        for (int j = 0; j < 3; j++){
            int i=0;
            if ((board[i][j]==board[i+1][j]) && (board[i+1][j]==board[i+2][j]) && (board[i][j] != '_'))
                return board[i][j];
            }
        return 'N';
    }
    
    static boolean isOver(String str){
        if (str.contains("_"))
            return false;
        return true;
    }
    
    static String makeMove(String str, char symbol) {
        char[] string = str.toCharArray();
        int[][] moves = new int[3][];
        moves[0] = new int[] {6,3,0};
        moves[1] = new int[] {7,4,1};
        moves[2] = new int[] {8,5,2};
        
        int i,j;
        boolean incorrectMove = true;
        
        while (incorrectMove)
        {
            if (scanner.hasNextInt()){
                i = scanner.nextInt();
                if (scanner.hasNextInt()) {
                    j = scanner.nextInt();        
                }
                else
                {
                    scanner.next();
                    System.out.println("You should enter numbers!");
                    continue;
                }
            }
            else
            {
                scanner.next();
                System.out.println("You should enter numbers!");
                continue;
            }
            
            if ((i > 3) || (i < 1) || (j > 3) || (j < 1) ){
                System.out.println("Coordinates should be from 1 to 3!");
            }
            else
            {
                if (string[moves[i-1][j-1]] != '_')
                {
                    System.out.println("This cell is occupied! Choose another one!");
                }
                else
                {
                    string[moves[i-1][j-1]] = symbol;
                    incorrectMove = false;
                }
            }
        }
        
        System.out.println(new String(string));
        
        return new String(string);
    }
}
