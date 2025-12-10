import java.util.Scanner;

public class CaseMethod {
    static Scanner input = new Scanner(System.in);

    static void menu(){
        System.out.println(
                "\n=== Sistem Pendaftaran Beasiswa ===\n" +
                "1. Tambah Data Pendaftar Beasiswa\n" +
                "2. Tampilkan Semua Pendaftar\n" +
                "3. Cari Pendaftar berdasarkan Jenis Beasiswa\n" +
                "4. Hitung Rata-rata IPK per Jenis Beasiswa\n" +
                "5. Keluar"
            );
            System.out.print("Pilih menu (1-5): ");
    }

    
}

