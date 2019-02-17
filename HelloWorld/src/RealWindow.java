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

import java.util.Timer;
import java.util.TimerTask;

public class RealWindow extends Application {

    public static void main(String[] args) throws Exception {
        launch(args);

    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("It' Snow Problem");
        primaryStage.setResizable(false);
        Screen screen = Screen.getPrimary();
        Rectangle2D bounds = screen.getVisualBounds();
        primaryStage.setX(bounds.getMinX());
        primaryStage.setY(bounds.getMinY());
        primaryStage.setWidth(bounds.getWidth());
        primaryStage.setHeight(bounds.getHeight());

        StackPane root = new StackPane();
        Scene scene = new Scene(root, bounds.getWidth(), bounds.getMinY());
        primaryStage.setScene(scene);

        //Text inputText = new Text("Input Data: ");
        Canvas canvas = new Canvas(1000, 1000);
        GraphicsContext gc = canvas.getGraphicsContext2D();
        root.getChildren().add(canvas);

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

    public static int count = 0, prevX = 0, prevY = 0;

    public static int rng(int min, int max){ //Random Number Generator
        if(min > max){ //Argument Error Trap
            int temp = min;
            min = max;
            max = temp;
        }
        int number = (int)(Math.random()*(max - min + 1) + min);
        return number;
    }
}
