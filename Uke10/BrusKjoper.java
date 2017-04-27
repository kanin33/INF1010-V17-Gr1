class BrusKjoper implements Runnable {
    private int antKjop;
    private BrusAutomat automat;

    public BrusKjoper(int antKjop, BrusAutomat automat) {
        this.antKjop = antKjop;
        this.automat = automat;
    }

    public void run() {
        for(int i = 0; i < antKjop; i++) {
            automat.kjopBrus();
            System.out.println("Har kjopt brus" + i + "ganger");
        }
    }
}
