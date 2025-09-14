public class TicketMachine {

    private int price;    // Harga dari satu tiket
    private int balance;  // Jumlah uang yang sudah dimasukkan oleh pelanggan saat ini
    private int total;    // Total uang yang terkumpul di mesin ini

    public TicketMachine(int ticketCost) {
        price = ticketCost; // Simpan harga tiket yang diberikan
        balance = 0;        // Awalnya, belum ada uang yang dimasukkan
        total = 0;          // Awalnya, total pemasukan adalah nol
    }
    public int getPrice() {
        return price;
    }
  
    public int getBalance() {
        return balance;
    }

    public void insertMoney(int amount) {
        if (amount > 0) {
            balance = balance + amount; // Tambahkan uang ke saldo saat ini
        } else {
            System.out.println("Harap masukkan jumlah uang yang valid (lebih dari 0).");
        }
    }

    public void printTicket() {
        if (balance >= price) {
            System.out.println("##################");
            System.out.println("# TIKET KERETA API");
            System.out.println("# Harga: " + price);
            System.out.println("##################");
            System.out.println("Silakan ambil tiket Anda.");
            System.out.println();

            total = total + price;
            balance = balance - price; 
        } else {
            int amountLeft = price - balance;
            System.out.println("Uang Anda tidak cukup. Anda kekurangan " + amountLeft + " lagi.");
        }
    }
}
