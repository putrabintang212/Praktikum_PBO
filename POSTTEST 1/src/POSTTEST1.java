import java.util.*;

class Unit {
    int id;
    String nama;
    double harga;
    boolean tersedia;

    public Unit(int id, String nama, double harga, boolean tersedia) {
        this.id = id;
        this.nama = nama;
        this.harga = harga;
        this.tersedia = tersedia;
    }
}

public class POSTTEST1 {
    static Scanner scanner = new Scanner(System.in);
    static List<Unit> daftarUnit = new ArrayList<>();
    static int unitId = 1;

    public static void main(String[] args) {
        while (true) {
            System.out.print("\033[2J");
            System.out.println("=============Admin==============");
            System.out.println("\nPenyewaan Alat Berat |CV.Bintang Jaya|");
            System.out.println("1. Kelola Unit");
            System.out.println("2. Keluar");
            System.out.print("Pilih menu: ");
            int pilihan = scanner.nextInt();
            scanner.nextLine();

            switch (pilihan) {
                case 1: MUnit(); break;
                case 2: System.exit(0);
                default: System.out.println("Pilihan tidak valid!");
            }
        }
    }

    static void MUnit() {
        while (true) {
            System.out.println("\nPengelolaan Unit Sewa");
            System.out.println("1. Tambah Unit");
            System.out.println("2. Lihat Unit");
            System.out.println("3. Perbarui Unit");
            System.out.println("4. Hapus Unit");
            System.out.println("5. Kembali");
            System.out.print("Pilih: ");
            int pilihan = scanner.nextInt();
            scanner.nextLine();

            if (pilihan == 1) {
                System.out.print("Nama Unit: ");
                String nama = scanner.nextLine();
                System.out.print("Harga /Day: ");
                double harga = scanner.nextDouble();
                daftarUnit.add(new Unit(unitId++, nama, harga, true));
            } else if (pilihan == 2) {
                for (Unit unit : daftarUnit)
                    System.out.println(unit.id + ". " + unit.nama + " - Rp " + unit.harga + " /Day - " + (unit.tersedia ? "Ready" : "Rented"));
            
            } else if (pilihan == 3) {
                System.out.print("Masukkan ID unit yang akan diperbarui: ");
                int id = scanner.nextInt();
                scanner.nextLine();
                for (Unit unit : daftarUnit) {
                    if (unit.id == id) {
                        System.out.print("Nama baru: ");
                        unit.nama = scanner.nextLine();
                        System.out.print("Harga /Day: ");
                        unit.harga = scanner.nextDouble();
                        System.out.println("Data unit berhasil diperbarui!");
                        break;
                    }
                }
            } else if (pilihan == 4) {
                System.out.print("Masukkan ID unit: ");
                int id = scanner.nextInt();
                daftarUnit.removeIf(unit -> unit.id == id);
            } else break;
        }
    }
}
