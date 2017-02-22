class MinMaksSil<T extends Comparable<T>> {
    // en klasse som lagrer største og minste verdi
    // den har fått
    public T maks;
    public T min;

    public void sil(T t) {
        if(maks == null) {
            // hvis silen er tom setter vi både største
            // og minste verdi til den nye verdien
            maks = t;
            min = t;
            return;
        }
        if(t.compareTo(maks) > 0) {
            // hvis den nye verdien er større enn den
            // største endrer vi maks til å bli den nye
            maks = t;
            return;
        }
        if(t.compareTo(min) < 0) {
            // hvis den nye verdien er mindre enn den minste
            // endrer vi min til å bli den nye
            min = t;
            return;
        }
        // hvis den nye verdien hverken er større enn
        // den største eller mindre enn den minste,
        // endrer vi ingenting
    }

    public void skriv() {
        System.out.println("Maks");
        System.out.println(maks);
        System.out.println("Min");
        System.out.println(min);
    }
}
