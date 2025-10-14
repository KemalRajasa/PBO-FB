import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Chatbot {
    private Map<String, String> responses;
    private Scanner scanner;

    public Chatbot() {
        scanner = new Scanner(System.in);
        responses = new HashMap<>();

        responses.put("uang",
                "Maaf atas ketidaknyamanannya. Pastikan uang yang Anda masukkan tidak terlipat dan dalam kondisi baik. Jika uang tetap tidak diterima, silakan hubungi nomor layanan pelanggan di bodi mesin.");
        responses.put("ketelan",
                "Kami mohon maaf atas masalah ini. Silakan catat kode mesin dan hubungi nomor layanan pelanggan kami untuk proses pengembalian dana.");
        responses.put("nyangkut",
                "Coba goyangkan mesin sedikit dengan hati-hati. Jika produk masih tersangkut, mohon hubungi nomor layanan pelanggan kami untuk bantuan lebih lanjut.");
        responses.put("rusak",
                "Terima kasih atas laporannya. Tim teknisi kami akan segera dihubungi untuk melakukan pemeriksaan. Mohon maaf atas gangguannya.");
        responses.put("bayar",
                "Anda dapat membayar dengan memasukkan uang kertas atau koin pada slot yang tersedia. Mesin akan otomatis mendeteksi nominalnya.");
        responses.put("bantuan",
                "Halo! Silakan ketik kata kunci masalah Anda, contoh: 'uang tidak diterima', 'produk nyangkut', 'uang ketelan'.");
        responses.put("default",
                "Maaf, saya kurang mengerti. Coba gunakan kata kunci seperti 'uang', 'nyangkut', atau 'rusak'.");
    }

    public void startSession() {
        System.out.println("\n--- Sesi Bantuan Chatbot ---");
        System.out.println("Halo! Ada yang bisa saya bantu? (Ketik 'kembali' untuk keluar)");

        while (true) {
            System.out.print("Anda: ");
            String userInput = scanner.nextLine().toLowerCase();

            if (userInput.equals("kembali")) {
                System.out.println("Sesi bantuan selesai. Anda akan kembali ke menu utama.");
                break;
            }

            String response = getResponse(userInput);
            System.out.println("Bot: " + response);
        }
    }

    /**
     * Mencari respons yang paling sesuai berdasarkan input pengguna.
     * 
     * @param userInput Teks input dari pengguna.
     * @return String balasan dari chatbot.
     */
    private String getResponse(String userInput) {
        // Cari kata kunci yang paling relevan
        if (userInput.contains("uang") && userInput.contains("ketelan"))
            return responses.get("ketelan");
        if (userInput.contains("uang"))
            return responses.get("uang");
        if (userInput.contains("nyangkut") || userInput.contains("tersangkut"))
            return responses.get("nyangkut");

        // Cari kata kunci umum
        for (String keyword : responses.keySet()) {
            if (userInput.contains(keyword)) {
                return responses.get(keyword);
            }
        }

        return responses.get("default");
    }
}
