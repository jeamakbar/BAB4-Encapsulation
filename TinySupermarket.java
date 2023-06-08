package Prak4;
import java.util.Scanner;

public class TinySupermarket {
    private double saldo;
    private String noPelanggan, nama;

    public TinySupermarket(double saldo, String noPelanggan, String nama) {
        this.saldo = saldo;
        this.noPelanggan = noPelanggan;
        this.nama = nama;
    }
    
    public double getSaldo() {
        return saldo;
    }

    public String getNoPelanggan() {
        return noPelanggan;
    }

    public String getNama() {
        return nama;
    }

    public boolean checkAutentikasi(int pin) {
        Scanner input = new Scanner(System.in);
        int percobaan = 0;
        while (pin != 123456 && percobaan < 2) {
            System.out.println("PIN salah! Coba lagi");
            percobaan++;
            pin = input.nextInt();
        }
        return (pin == 123456);
    }

    public boolean pembelian(double harga) {
        double cashback = 0;
        boolean berhasil = false;
        
        // Member Silver
        if (this.noPelanggan.substring(0, 2).equals("38")) {
            if (harga > 1000000) {
                cashback = harga * 0.05;
            }
        } 
        // Member Gold
        else if (this.noPelanggan.substring(0, 2).equals("56")) {
            if (harga > 1000000) {
                cashback = (harga * 0.07);
            } else {
                cashback = harga * 0.02;
            }
        } 
        // Member Platinum
        else if (this.noPelanggan.substring(0, 2).equals("74")) {
            if (harga > 1000000) {
                cashback = harga * 0.1;
            } else {
                cashback = harga * 0.05;
            }
        }
        
        double totalHarga = harga - cashback;
        if (totalHarga >= 10000 && this.saldo >= totalHarga) {
            this.saldo -= totalHarga;
            System.out.println(this.saldo);
            berhasil = true;
        }
        return berhasil;
    }

    public boolean topUp(double jumlahTopUp) {
        boolean berhasil = false;
        if (jumlahTopUp >= 0) {
            saldo += jumlahTopUp;
            System.out.println(this.saldo);
            berhasil = true;
        }
        return berhasil;
    }
}