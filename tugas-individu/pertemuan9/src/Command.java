public class Command {
    private CommandWord commandWord;
    private String secondWord;

    /**
     * Membuat objek Command.
     * @param commandWord Kata perintah (enum CommandWord).
     * @param secondWord Kata kedua (misal: "north" untuk perintah "go").
     */
    public Command(CommandWord commandWord, String secondWord) {
        this.commandWord = commandWord;
        this.secondWord = secondWord;
    }

    /**
     * @return Kata perintah (CommandWord).
     */
    public CommandWord getCommandWord() {
        return commandWord;
    }

    /**
     * @return Kata kedua, atau null jika tidak ada.
     */
    public String getSecondWord() {
        return secondWord;
    }

    /**
     * @return true jika perintah tidak diketahui.
     */
    public boolean isUnknown() {
        return (commandWord == CommandWord.UNKNOWN);
    }

    /**
     * @return true jika ada kata kedua.
     */
    public boolean hasSecondWord() {
        return (secondWord != null);
    }
}
