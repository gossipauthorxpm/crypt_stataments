package org.example;

import java.util.Random;

public class EPC {
    private final int P = 84787;
    private int Q = 3;
    private final int A;
    private int K;
    private double X;
    private double Y;
    private Hash hash;

    public EPC(Hash hash) {
        this.hash = hash;
        this.Q = this.getPrimeDividerP(this.P - 1, this.Q);
        this.A = this.getIntA(this.P - 1);
        this.K = this.getPrimeK();
        this.getPrimeX();
        this.getPrimeY();
        System.out.format("Q - %d P - %d, A - %d, K - %d, X - %.2f, Y - %.2f", this.Q, this.P, this.A, this.K, this.X, this.Y);
    }

    //    realization generate keys
    private String toString(Integer x) {
        return Integer.toString(x);
    }

    private String toString(Double x) {
        return Double.toString(x);
    }

    private void getPrimeY() {
        this.Y = Math.pow(this.A, this.X);
        this.Y = this.Y % this.P;
    }

    private void getPrimeX() {
        Random random = new Random();
        this.X = random.nextInt(2, this.Q);
    }

    private int getPrimeK() {
        Random random = new Random();
        return random.nextInt(1, this.Q - 1);
    }

    private int getPrimeDividerP(int seq, int start) {
        for (int i = start; i < seq; i++) {
            if (this.isPrimeNumber(i)) {
                if (i % this.P == 0) {
                    return i;
                }
            }
        }
        return this.Q;
    }

    private int getIntA(int seq) {
        for (int i = 2; i < seq; i++) {
            boolean result = (Math.pow(i, this.Q) - 1) % this.P == 0;
            if (result) {
                return i;
            }
        }
        return 0;
    }

    private boolean isPrimeNumber(int n) {
        boolean result = true;
        if (n > 1) {
            for (int i = 2; i < n; i++) {
                if (n % i == 0) {
                    result = false;
                    break;
                }
            }
        } else {
            result = false;
        }
        return result;
    }
    //    realization generate keys
}
