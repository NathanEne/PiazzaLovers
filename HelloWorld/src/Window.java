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

public class Window extends Application {

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

        //gc.strokeOval(0,0,200,200);

        //int[][] manta = new int[1000][2];

        //og flipping art
        /*
           Timer clock = new Timer();
           TimerTask task = new TimerTask() { // Task that can be executed by a timer
               @Override
                public void run() { //Action to be performed
                    for (int y = 0; y < manta.length; y++){
                        for(int x = 0; x < manta[y].length; x++){
                            manta[y][x] = rng(0,(int)canvas.getHeight());
                        }
                    }

                    for (int y = 0; y < manta.length-1; y++){
                        gc.setStroke(javafx.scene.paint.Color.rgb(rng(0,255), rng(0,255), rng(0,255)));
                        gc.strokeLine(manta[y][1], manta[y][0], manta[y+1][1], manta[y+1][0]);
                    }
                }
            };
            */
        /*
        for (int y = 0; y < manta.length; y++){
            for(int x = 0; x < manta[y].length; x++){
                manta[y][x] = rng(0,(int)canvas.getHeight());
            }
        }

        Timer clock = new Timer();
        TimerTask task = new TimerTask() { // Task that can be executed by a timer
            // @Override
            public void run() { //Action to be performed
                if(count < manta.length-1){
                    gc.setStroke(javafx.scene.paint.Color.rgb(rng(0,255), rng(0,255), rng(0,255)));
                    gc.strokeLine(manta[count][1], manta[count][0], manta[count+1][1], manta[count+1][0]);
                    count++;
                }
            }
        };
        clock.schedule(task, 0, 100); // timerTask, delay, period

        */

        Timer clock = new Timer();
        TimerTask task = new TimerTask() { // Task that can be executed by a timer
            // @Override
            public void run() { //Action to be performed
                    gc.setStroke(javafx.scene.paint.Color.rgb(rng(0,255), rng(0,255), rng(0,255)));
                    gc.strokeLine(prevX, prevY, prevX = rng(0,(int)canvas.getHeight()), prevY =rng(0,(int)canvas.getHeight()));
                    count++;
                    if(count%500 == 0){
                        gc.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());
                    }

            }
        };
        clock.schedule(task, 0, 1);

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
