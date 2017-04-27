class TellerMain {
    public static void main(String[] args) {
        TelleMonitor monitor = new TelleMonitor();

        Thread traad1 = new Thread(new Teller(monitor));
        Thread traad2 = new Thread(new Teller(monitor));
        traad1.start();
        traad2.start();
    }
}
