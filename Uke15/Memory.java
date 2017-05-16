import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.layout.VBox;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.paint.Color;
import javafx.scene.layout.GridPane;
import javafx.event.EventHandler;
import javafx.event.ActionEvent;
import javafx.animation.*;
import javafx.util.Duration;
import java.util.Random;
import java.util.ArrayList;
import javafx.application.Platform;

public class Memory extends Application {
    public static final int SIZE = 4;
    public static final int ANTALL_PAR = (SIZE*SIZE)/2;
    int progress = 0;
    Scene introScene;
    Scene gameScene;
    Scene endScene;

    @Override
    public void start(Stage stage) {
        VBox introLayout = new VBox();
        introLayout.setAlignment(Pos.CENTER);
        introLayout.setSpacing(10);

        //introLayout.setBackground(new Background(new BackgroundFill(Color.BLUE, null, null)));

        introLayout.setStyle("-fx-background-color: lightblue;");

        Label gameTitle = new Label("Memory");
        gameTitle.setStyle("-fx-font-size: 18px;");

        Button startKnapp = new Button("Start spill");
        startKnapp.setOnAction(event -> stage.setScene(gameScene));
        introLayout.getChildren().addAll(gameTitle, startKnapp);

        introScene = new Scene(introLayout, 150, 100);

        GridPane gameGrid = new GridPane();
        gameGrid.setStyle("-fx-background-color: lightsalmon;");

        ImageBtn[] buttons = generateButtons();

        for(ImageBtn b : buttons) {
            b.setOnAction(new EventHandler<ActionEvent>() {
                @Override public void handle(ActionEvent e) {
                    b.setText("" + b.bokstav());
                    b.clicked = true;
                    System.out.println("Knapp: " + b.getText());

                    for(ImageBtn other : buttons) {
                        if(other != b && other.clicked) {
                            b.clicked = false;
                            other.clicked = false;
                            if(other.compareTo(b) != 0) {
                                PauseTransition pt = new PauseTransition(Duration.millis(500));
                                pt.setOnFinished(new EventHandler<ActionEvent>() {
                                    @Override public void handle(ActionEvent f) {
                                        b.setText(" ");
                                        other.setText(" ");
                                    }
                                });
                                pt.play();
                            } else {
                                b.setDisable(true);
                                other.setDisable(true);
                                progress++;
                                if(progress == ANTALL_PAR) {
                                    stage.setScene(endScene);
                                }
                            }
                        }
                    }
                }
            });
        }
        int a = 0;
        for(int i = 0; i < SIZE; i++) {
            for(int j = 0; j < SIZE; j++) {
                gameGrid.add(buttons[a++], i, j);
            }
        }

        gameScene = new Scene(gameGrid);

        VBox sluttLayout = new VBox();
        sluttLayout.setAlignment(Pos.CENTER);
        sluttLayout.setSpacing(10);

        //introLayout.setBackground(new Background(new BackgroundFill(Color.BLUE, null, null)));

        sluttLayout.setStyle("-fx-background-color: lightblue;");


        Button sluttKnapp = new Button("Avlutt spill");
        Button spillKnapp = new Button("Spill paa nytt");
        sluttKnapp.setOnAction(event -> Platform.exit());
        //spillKnapp.setOnAction(event -> stage.setScene(gameScene));
        sluttLayout.getChildren().addAll(sluttKnapp);//, spillKnapp);

        endScene = new Scene(sluttLayout, 150, 100);

        stage.setScene(introScene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }

    public static ImageBtn[] generateButtons() {
        ArrayList<Character> chars = new ArrayList<>();

        char c = 'a';
        int i = 0;
        while(i < ANTALL_PAR) {
            chars.add(c);
            chars.add(c);
            c++;
            i++;
        }

        ImageBtn[] buttons = new ImageBtn[chars.size()];

        Random rand = new Random();
        for(int j = 0; j < buttons.length; j++) {
            int random = rand.nextInt(chars.size());
            buttons[j] = new ImageBtn(chars.get(random));
            buttons[j].setPrefSize(40, 40);
            chars.remove(random);
        }

        return buttons;
   }
}
