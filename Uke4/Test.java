class Test {
    public static void main(String[] args) {
        /*
        String[] testStringer = {"Hei", "Hallo", "Hello"};
        System.out.println(testStringer[1].compareTo(testStringer[0]));
        */

        Person p1 = new Person("Tale", 25);
        Person p2 = new Person("Trym", 15);
        System.out.println(p1.compareTo(p1));
    }
}
