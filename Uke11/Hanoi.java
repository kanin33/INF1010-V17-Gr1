class Hanoi {
    static int antSteg = 0;
    public static void main(String[] args) {
        hanoi(4, "A", "B", "C");
        System.out.println(antSteg);
    }
    // flytter n ringer fra A til C via B
    static void hanoi(int n, String A, String B, String C) {
        if(n != 1) {
            antSteg++;
            // steg 1
            hanoi(n-1, A, C, B);
            // steg 2
            System.out.printf("Flytter fra %s til %s\n", A, C);
            // steg 3
            hanoi(n-1, B, A, C);
        }
        else {
            antSteg++;
            System.out.printf("Flytter fra %s til %s\n", A, C);
        }
    }
}
