class BrusMain {
    public static void main(String[] args) {
        BrusAutomat automat = new BrusAutomat(20);

        int antBrusKjopere = 10;
        for(int i = 0; i < antBrusKjopere; i++) {
            new Thread(new BrusKjoper(300, automat)).start();
        }
        new Thread(new BrusPaafyller(1000, automat)).start();
    }
}
