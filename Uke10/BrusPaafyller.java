class BrusPaafyller implements Runnable {
    private int antPaafyll;
    private BrusAutomat automat;

    public BrusPaafyller(int antPaafyll, BrusAutomat automat) {
        this.antPaafyll = antPaafyll;
        this.automat = automat;
    }

    public void run() {
        for(int i = 0; i < antPaafyll; i++) {
            automat.fyllPaa();
            System.out.println("Fylt paa brus" + i + "ganger");
        }
    }
}
