class Whiskey extends Alkoholdrikke {
    public Whiskey(double alkoholProsent,
                         String navn) {
        super(alkoholProsent, navn);
    }

    @Override
    public String toString() {
        return "Whiskey";
    }
}
