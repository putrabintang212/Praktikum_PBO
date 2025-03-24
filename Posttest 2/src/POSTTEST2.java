import java.util.*;

class Unit {
    private int id;
    private String nama;
    private double harga;
    private boolean tersedia;

    public Unit(int id, String nama, double harga, boolean tersedia) {
        this.id = id;
        this.nama = nama;
        this.harga = harga;
        this.tersedia = tersedia;
    }

    public int getId() {
        return id;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public double getHarga() {
        return harga;
    }

    public void setHarga(double harga) {
        this.harga = harga;
    }

    public boolean isTersedia() {
        return tersedia;
    }

    public void setTersedia(boolean tersedia) {
        this.tersedia = tersedia;
    }
}

public class POSTTEST2 {
    private static Scanner scanner = new Scanner(System.in);
    private static List<Unit> daftarUnit = new ArrayList<>();
    private static int unitId = 1;

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
                case 1:
                    MUnit();
                    break;
                case 2:
                    System.exit(0);
                default:
                    System.out.println("Pilihan tidak valid!");
            }
        }
    }

    private static void MUnit() {
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
                    System.out.println(unit.getId() + ". " + unit.getNama() + " - Rp " + unit.getHarga() + " /Day - " + (unit.isTersedia() ? "Ready" : "Rented"));
            } else if (pilihan == 3) {
                System.out.print("Masukkan ID unit yang akan diperbarui: ");
                int id = scanner.nextInt();
                scanner.nextLine();
                for (Unit unit : daftarUnit) {
                    if (unit.getId() == id) {
                        System.out.print("Nama baru: ");
                        unit.setNama(scanner.nextLine());
                        System.out.print("Harga /Day: ");
                        unit.setHarga(scanner.nextDouble());
                        System.out.println("Data unit berhasil diperbarui!");
                        break;
                    }
                }
            } else if (pilihan == 4) {
                System.out.print("Masukkan ID unit: ");
                int id = scanner.nextInt();
                daftarUnit.removeIf(unit -> unit.getId() == id);
            } else break;
        }
    }
}
