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
    static void menu3(){
        System.out.print("Masukkan jenis beasiswa yang dicari : ");
        String cari = input.nextLine();
        boolean nemu = false;
        
        System.out.println("\n===== Hasil pencarian =====");
        for (int i = 0; i < daftar; i++) {
            if (data[i][3].equalsIgnoreCase(cari)) {
                System.out.printf(
                    "%-15s %-12s %-6s %-18s %-15s\n",
                    "Nama", "NIM", "IPK", "Beasiswa", "Penghasilan");
                
                System.out.printf("%-15s %-12s %-6s %-18s %-15s",
                    data[i][0],
                    data[i][1],
                    data[i][2],
                    data[i][3],
                    data[i][4]);
                nemu = true;
            }
        }
        if (!nemu) {
            System.out.println("Tidak ada pendaftar dengan jenis beasiswa tersebut.");
        }
        System.out.println("");
    }

    static void menu4(){
        double reg = 0, ung = 0, ris = 0;
        int jmlReg = 0, jmlUng = 0, jmlRis = 0;
        for (int i = 0; i < daftar; i++) {
            String jenis = data[i][3];
            double ipk = Double.parseDouble(data[i][2]);
            if (jenis.equalsIgnoreCase("Reguler")) {
                reg += ipk;
                jmlReg++;
            } else if (jenis.equalsIgnoreCase("Unggulan")) {
                ung += ipk;
                jmlUng++;
            } else if (jenis.equalsIgnoreCase("Riset")) {
                ris += ipk;
                jmlRis++;
            }
        }
        System.out.println("\n=== Rata-rata IPK Berdasarkan Jenis Beasiswa ===");
        System.out.println("Reguler\t\t: " + (jmlReg == 0 ? "tidak ada data" : String.format("%.2f", reg / jmlReg)));
        System.out.println("Unggulan\t: " + (jmlUng == 0 ? "tidak ada data" : String.format("%.2f", ung / jmlUng)));
        System.out.println("Riset\t\t: " + (jmlRis == 0 ? "tidak ada data" : String.format("%.2f", ris / jmlRis)));
    } 
    public static void main(String[] args) {
      int pilih;

        do {
            menu();
            pilih = input.nextInt();

            switch (pilih) {
                case 1:
                    menu1();
                    break;
                case 2:
                    menu2();
                    break;
                case 3:
                    menu3();
                    break;
                case 4:
                    menu4();
                    break;
                case 5:
                    System.out.println("Program selesai.");
                    break;
                default:
                    System.out.println("Menu tidak tersedia.");
            }
        } while (pilih != 5);
    }
}

