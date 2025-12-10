import java.util.Scanner;

public class CaseMethod {
    static Scanner input = new Scanner(System.in);
    static int daftar = 0, n = 100;
    static String[][] data = new String[n][5];

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
    static void menu1(){
        if (daftar >= n) {
            System.out.println("Pendaftar sudah penuh.");
            return;
        }

        System.out.print("Nama Mahasiswa\t\t\t\t: ");
        data[daftar][0] = input.nextLine();
        System.out.print("NIM\t\t\t\t\t: ");
        data[daftar][1] = input.nextLine();
        System.out.print("IPK terakhir\t\t\t\t: ");
        data[daftar][2] = input.nextLine();

        String jenis;
        while (true) {
            System.out.print("Jenis Beasiswa (Reguler/Unggulan/Riset)\t: ");
            jenis = input.nextLine();
            if (jenis.equalsIgnoreCase("Reguler") || jenis.equalsIgnoreCase("Unggulan") || jenis.equalsIgnoreCase("Riset")){
                break;
            }
            System.out.println("Jenis Beasiswa tidak valid.");
            return;
        }
        data[daftar][3] = jenis;

        System.out.print("Penghasilan Orang Tua (maks 2000000)\t: ");
        int gaji = input.nextInt();
        input.nextLine();

        if (gaji > 2000000) {
            System.out.println("Pendaftaran dibatalkan karena penghasilan melebihi batas maksimal.");
            return;
        }
        data[daftar][4] = Integer.toString(gaji);
        
        daftar++;
        System.out.println("Pendaftar berhasil disimpan. Total pendaftar: " + daftar);
    }

    static void menu2() {
        if ( daftar == 0) {
            System.out.println("Belum ada pendaftar.");
            return;
        }    
        System.out.println("==============================================================================");
        System.out.printf("%-5s %-20s %-15s %-10s %-12s %-15s\n","No", "Nama", "NIM", "IPK", "Beasiswa", "Penghasilan");
        System.out.println("==============================================================================");

        for (int i = 0; i < daftar; i++) {
            System.out.printf("%-5d %-20s %-15s %-10s %-12s %-15s\n",
                (i + 1),
                data[i][0],  
                data[i][1],  
                data[i][2],   
                data[i][3],  
                data[i][4]);  
        }
    }  
}

