class Beholder implements BeholderInterface<String> {
    // ikke-generisk beholder som implementerer
    // det generiske interfacet BeholderInterface
    private String s;

    public Beholder(String s) {
        this.s = s;
    }
}
