package HelloWorld.src;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.scene.canvas.Canvas;

public class Window extends Application {

    public static void main(String[] args) throws Exception {
        launch(args);

    }

    @Override
    public void start(Stage primaryStage) {
        StackPane root = new StackPane();

        primaryStage.setResizable(false);
        Screen screen = Screen.getPrimary();
        Rectangle2D bounds = screen.getVisualBounds();
        primaryStage.setX(bounds.getMinX());
        primaryStage.setY(bounds.getMinY());
        primaryStage.setWidth(bounds.getWidth());
        primaryStage.setHeight(bounds.getHeight());

        Scene scene = new Scene(root, bounds.getWidth(), bounds.getMinY());
        primaryStage.setScene(scene);
        primaryStage.setTitle("It' Snow Problem");

        Canvas canvas = new Canvas(1000, 1000);
        GraphicsContext gc = canvas.getGraphicsContext2D();
        root.getChildren().add(canvas);

        gc.strokeOval(0,0,200,200);

        int[][] manta = new int[1000][2];

        for (int y = 0; y < manta.length; y++){
            for(int x = 0; x < manta[y].length; x++){
                manta[y][x] = rng(0,1000);
            }
        }

        for (int y = 0; y < manta.length-1; y++){
            System.out.println(manta[y][0] + " " + manta[y][1]);
            gc.strokeLine(manta[y][1], manta[y][0], manta[y+1][1], manta[y+1][0]);
        }


        primaryStage.show();
    }

    public static int rng(int min, int max){ //Random Number Generator
        if(min > max){ //Argument Error Trap
            int temp = min;
            min = max;
            max = temp;
        }
        int number = (int)(Math.random()*(max - min + 1) + min);
        return number;
    }

            /*
        Button btn = new Button();
        btn.setText("Say 'Hello World'");
        btn.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                System.out.println("Hello World!");
            }
        });

        root.getChildren().add(btn);
        */
}
