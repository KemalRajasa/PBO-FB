public enum CommandWord {
    GO("go"), 
    QUIT("quit"), 
    HELP("help"), 
    UNKNOWN("?");
  
    private String commandString;

    /**
     * Constructor
     * @param commandString String untuk perintah.
     */
    CommandWord(String commandString) {
        this.commandString = commandString;
    }

    /**
     * @return String representasi dari perintah.
     */
    @Override
    public String toString() {
        return commandString;
    }
}
