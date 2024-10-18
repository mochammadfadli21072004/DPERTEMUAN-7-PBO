import java.util.HashMap;
import java.util.Scanner;

public class TokoSerbaAda {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        HashMap<String, Barang> barang = new HashMap<>();

        System.out.print("Masukkan jumlah item barang: ");
        int jumlahItem = scanner.nextInt();

        for (int i = 1; i <= jumlahItem; i++) {
            System.out.println("Data ke " + i);
            System.out.print("Masukkan kode: ");
            String kode = scanner.next();

            if (!barang.containsKey(kode)) {
                System.out.print("Masukkan nama barang: ");
                String nama = scanner.next();
                System.out.print("Masukkan harga: ");
                int harga = scanner.nextInt();
                barang.put(kode, new Barang(nama, harga));
            } else {
                System.out.println("Barang sudah ada!");
            }

            System.out.print("Masukkan jumlah beli: ");
            int jumlahBeli = scanner.nextInt();
            Barang barangObj = barang.get(kode);
            barangObj.setJumlahBeli(jumlahBeli);
        }

        // Tampilkan hasil
        System.out.println("\nTOKO SERBA ADA");
        System.out.println("No\tKode Barang\tNama Barang\tHarga\tJumlah Beli\tJumlah Bayar");
        int no = 1;
        int totalBayar = 0;
        for (String kode : barang.keySet()) {
            Barang barangObj = barang.get(kode);
            int jumlahBayarItem = barangObj.getHarga() * barangObj.getJumlahBeli();
            System.out.printf("%d\t%s\t\t%s\t\t%d\t%d\t\t%d\n", no, kode, barangObj.getNama(), barangObj.getHarga(), barangObj.getJumlahBeli(), jumlahBayarItem);
            totalBayar += jumlahBayarItem;
            no++;
        }

        System.out.printf("Total Bayar\t\t\t\t\t\t%d\n", totalBayar);
    }

    static class Barang {
        private String nama;
        private int harga;
        private int jumlahBeli;

        public Barang(String nama, int harga) {
            this.nama = nama;
            this.harga = harga;
        }

        public String getNama() {
            return nama;
        }

        public int getHarga() {
            return harga;
        }

        public int getJumlahBeli() {
            return jumlahBeli;
        }

        public void setJumlahBeli(int jumlahBeli) {
            this.jumlahBeli = jumlahBeli;
        }
    }
}