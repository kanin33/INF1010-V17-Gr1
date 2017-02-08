class Main {
    public static void main(String[] args) {
        Ol o = new Ol(4.5, "Aas", "Pilshumle");
        System.out.println(o);
        Alkoholdrikke a = o;
        System.out.println(a);

        Vin[] vinkjeller = new Vin[10];
        Hvitvin h2 = new Hvitvin(11, "vin1", "Drue2");
        Rodvin r = new Rodvin(13, "vin2", "Drue2");
        Vin v = new Vin(12, "Riesling", "Drue1");
        vinkjeller[0] = h2;
        vinkjeller[1] = r;
        vinkjeller[2] = v;
        if(vinkjeller[0] instanceof Hvitvin) {
            System.out.println("hei");
        }
        System.out.println(vinkjeller[0]);
        Vin v2 = h2;
        //Rodvin r2 = v2; // gaar ikke siden v2 er hvitvin
        //Vin v = h2;
        if(v instanceof Hvitvin) {
            Hvitvin h = (Hvitvin) v;
            h.printHvitvin();
        }
    }
}
