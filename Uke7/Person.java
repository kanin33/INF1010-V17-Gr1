class Person implements Comparable<Person> {
    public String navn;
    public int alder;

    public Person(String navn, int alder) {
        this.navn = navn;
        this.alder = alder;
    }

    // CompareTo-metode som sammenlikner
    // to personer med hensyn på alder
    public int compareTo(Person p) {
        if(this.alder > p.alder) {
            return 1;
        } else if (this.alder < p.alder) {
            return -1;
        } else {
            return 0;
        }
    }

    // compareTo-metode som sammenlikner to personer
    // med hensyn på navn (String)
    // public int compareTo(Person p) {
    //     if(this.navn.compareTo(p.navn) > 0) {
    //         return 1;
    //     } else if(this.navn.compareTo(p.navn) < 0) {
    //         return -1;
    //     } else {
    //         return 0;
    //     }
    // }
}
