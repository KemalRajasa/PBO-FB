import java.util.Map;
import java.util.HashMap;
import java.util.Set;
import java.util.HashSet;
import java.util.Arrays;
import java.util.Scanner;

public class SupportFRS {

    private Map<String, String> responses;

    private Map<String, Integer> keywordFrequency;
  
    public SupportFRS() {
        responses = new HashMap<>();
        keywordFrequency = new HashMap<>();

        // Mengisi peta dengan kata kunci dan respons terkait FRS
        responses.put("error", "Tolong berikan kode error yang lebih spesifik (misal: 302, 404, 500) agar saya bisa bantu.");
        responses.put("302", "Error 302 (Found) berarti halaman dialihkan. Coba bersihkan cache browser Anda atau gunakan link FRS terbaru dari portal akademik.");
        responses.put("404", "Error 404 (Not Found) artinya halaman tidak ditemukan. Pastikan URL atau link FRS yang Anda akses sudah benar.");
        responses.put("500", "Error 500 (Internal Server Error) adalah masalah di sisi server, bukan kesalahan Anda. Silakan coba lagi dalam beberapa saat atau hubungi pihak IT kampus.");
        responses.put("jadwal", "Jadwal pengisian FRS dapat dilihat pada pengumuman resmi di website akademik atau portal mahasiswa Anda.");
        responses.put("penuh", "Jika kelas sudah penuh, Anda bisa mencoba mencari kelas lain dengan mata kuliah yang sama atau menghubungi dosen wali untuk kemungkinan penambahan kapasitas.");
        responses.put("login", "Pastikan Anda menggunakan NIM dan password yang benar. Jika masih gagal, coba gunakan fitur 'Lupa Password' atau hubungi bagian administrasi akademik.");
        responses.put("matkul", "Daftar mata kuliah yang tersedia untuk semester ini bisa Anda lihat langsung di dalam sistem FRS saat Anda login.");
        responses.put("batal", "Untuk membatalkan mata kuliah yang sudah dipilih, masuk ke halaman FRS Anda dan cari tombol 'Batal' atau 'Hapus' di samping nama mata kuliah tersebut selama periode revisi FRS masih dibuka.");
        
        // Respons default jika tidak ada kata kunci yang cocok
        responses.put("default", "Maaf, saya tidak mengerti. Coba gunakan kata kunci seperti 'error', 'jadwal', 'penuh', 'login', atau sebutkan kode error spesifik.");
    }

    public String getResponse(String userInput) {
        
        String[] wordsArray = userInput.toLowerCase().split("\\W+"); // Memecah berdasarkan karakter non-kata
        Set<String> uniqueWords = new HashSet<>(Arrays.asList(wordsArray));

        
        for (String word : uniqueWords) {
            if (responses.containsKey(word)) {
                
                int currentCount = keywordFrequency.getOrDefault(word, 0) + 1;
                keywordFrequency.put(word, currentCount);
                System.out.println("[Info: Kata kunci '" + word + "' terdeteksi " + currentCount + " kali.]");

                
                return responses.get(word);
            }
        }

        return responses.get("default");
    }


    public static void main(String[] args) {
        SupportFRS chatbot = new SupportFRS();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Selamat datang di Layanan Chatbot FRS Mahasiswa.");
        System.out.println("Silakan ajukan pertanyaan Anda atau ketik 'exit' untuk keluar.");
        System.out.println("---------------------------------------------------------");

        while (true) {
            System.out.print("Anda: ");
            String userInput = scanner.nextLine();

            if (userInput.equalsIgnoreCase("exit")) {
                break;
            }

            String response = chatbot.getResponse(userInput);
            System.out.println("Bot: " + response);
            System.out.println();
        }

        System.out.println("Terima kasih telah menggunakan layanan kami.");
        scanner.close();
    }
}
