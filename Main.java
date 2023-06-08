package Prak4;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Nama: ");
        String nama = input.nextLine();
        System.out.print("No.Pelanggan: ");
        String noPelanggan = input.nextLine();
        System.out.print("Saldo: ");
        double saldo = input.nextDouble();
        TinySupermarket proses = new TinySupermarket(saldo, noPelanggan, nama);

        boolean autentikasiBerhasil = false;

        System.out.println("Verifikasi data");
        int batasKesalahanAutentikasi = 0;
        while (!autentikasiBerhasil && batasKesalahanAutentikasi < 2) {
            System.out.print("PIN: ");
            int pin = input.nextInt();
            autentikasiBerhasil = proses.checkAutentikasi(pin);

            if (!autentikasiBerhasil) {
                System.out.println("Gagal memasukkan pin yang benar sebanyak 3x. Akun Anda diblokir");
                System.exit(0);
            }
        }

        boolean diulang = true;
        while (diulang) {
            System.out.println();
            System.out.println("Halo " + proses.getNama() + ", Menu:");
            System.out.println("1. Beli barang");
            System.out.println("2. Top-up");
            System.out.println("3. Keluar");

            System.out.print("Pilihan menu: ");
            int pilihanMenu = input.nextInt();

            switch (pilihanMenu) {
                case 1:
                    System.out.print("Total Harga: ");
                    double totalHarga = input.nextDouble();
                    proses.pembelian(totalHarga);

                    if (proses.pembelian(totalHarga)) {
                        System.out.println("Saldo anda sekarang diatas!");
                        System.out.println("Transaksi berhasil!");
                    } else {
                        System.out.println("Transaksi gagal! Saldo kurang.");
                    }
                    break;
                case 2:
                    System.out.print("Jumlah top up: ");
                    double jumlahTopUp = input.nextDouble();
                    proses.topUp(jumlahTopUp);
                    System.out.println("Top up Berhasil!");
                    break;
                case 3:
                    diulang = false;
                    System.out.println("Terima kasih");
                    break;
                default:
                    System.out.println("Pilihan menu tidak valid");
            }
        }
    }
}