import javafx.scene.control.Button;

class ImageBtn extends Button implements Comparable<ImageBtn> {
    private char bokstav;
    public boolean clicked;

    public ImageBtn(char c){
        super(" ");
        bokstav = c;
        clicked = false;
    }

    public char bokstav() {
        return bokstav;
    }

    public String toString() {
        return "" + bokstav;
    }

    public int compareTo(ImageBtn other) {
        if(bokstav == other.bokstav()) {
            return 0;
        } return -1;
    }
}
