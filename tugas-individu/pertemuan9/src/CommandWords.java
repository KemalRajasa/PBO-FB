import java.util.HashMap;

public class CommandWords {
    private HashMap<String, CommandWord> validCommands;

    /**
     * Constructor - mengisi map dengan semua perintah yang valid.
     */
    public CommandWords() {
        validCommands = new HashMap<>();
        for (CommandWord command : CommandWord.values()) {
            if (command != CommandWord.UNKNOWN) {
                validCommands.put(command.toString(), command);
            }
        }
    }

    /**
     * Mengambil CommandWord berdasarkan String.
     * @param commandWord String input (misal: "go").
     * @return CommandWord yang sesuai, atau UNKNOWN jika tidak valid.
     */
    public CommandWord getCommandWord(String commandWord) {
        CommandWord command = validCommands.get(commandWord);
        if (command != null) {
            return command;
        } else {
            return CommandWord.UNKNOWN;
        }
    }

    /**
     * Menampilkan semua perintah yang valid ke konsol.
     */
    public void showAll() {
        for (String command : validCommands.keySet()) {
            System.out.print(command + "  ");
        }
        System.out.println();
    }
}
