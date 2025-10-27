import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Room {
    private String description;
    private Map<String, Room> exits;

    /**
     * Membuat ruangan baru.
     * @param description Deskripsi singkat ruangan.
     */
    public Room(String description) {
        this.description = description;
        exits = new HashMap<>();
    }

    /**
     * Menetapkan pintu keluar dari ruangan ini.
     * @param direction Arah pintu keluar (misal: "north", "east").
     * @param neighbor Ruangan tujuan.
     */
    public void setExit(String direction, Room neighbor) {
        exits.put(direction, neighbor);
    }

    /**
     * @return Deskripsi ruangan.
     */
    public String getDescription() {
        return description;
    }

    /**
     * Mendapatkan ruangan tujuan jika pemain pergi ke arah tertentu.
     * @param direction Arah yang dituju.
     * @return Objek Room di arah tersebut, atau null jika tidak ada pintu.
     */
    public Room getExit(String direction) {
        return exits.get(direction);
    }

    /**
     * @return String yang menjelaskan semua pintu keluar, misal: "Exits: north west".
     */
    public String getExitString() {
        String returnString = "Pintu keluar:";
        Set<String> keys = exits.keySet();
        for (String exit : keys) {
            returnString += " " + exit;
        }
        return returnString;
    }
}
