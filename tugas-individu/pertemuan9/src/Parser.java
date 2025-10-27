import java.util.Scanner;

public class Parser {
    private CommandWords commandWords;
    private Scanner reader;

    public Parser() {
        commandWords = new CommandWords();
        reader = new Scanner(System.in);
    }

    /**
     * Membaca baris input dari pengguna dan mengembalikannya sebagai Command.
     * @return Objek Command.
     */
    public Command getCommand() {
        String inputLine;
        String word1 = null;
        String word2 = null;

        System.out.print("> ");
        inputLine = reader.nextLine().toLowerCase();

    
        Scanner tokenizer = new Scanner(inputLine);
        if (tokenizer.hasNext()) {
            word1 = tokenizer.next(); 
            if (tokenizer.hasNext()) {
                word2 = tokenizer.next();
            }
        }
        tokenizer.close();

        CommandWord commandWord = commandWords.getCommandWord(word1);
        return new Command(commandWord, word2);
    }

    /**
     * Menampilkan semua perintah yang valid ke konsol.
     */
    public void showCommands() {
        commandWords.showAll();
    }
}
