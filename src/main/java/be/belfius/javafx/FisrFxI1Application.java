package be.belfius.javafx;

import be.belfius.javafx.controller.FisrFxI1ApplicationController;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import static be.belfius.javafx.util.BootFxConstants.*;

@SpringBootApplication
@Slf4j
public class FisrFxI1Application extends Application {
	private ConfigurableApplicationContext springContext;
	private Parent rootNode;
	private FXMLLoader fxmlLoader;

	public static void main(String[] args) {
//		SpringApplication.run(FisrFxI1Application.class, args);
		log.info("Starting from main");

		try {
			launch(args);
		}catch (Exception e){
			e.printStackTrace();
		}

	}
	@Override
	public void init() throws Exception {
		springContext = SpringApplication.run(FisrFxI1Application.class);
		fxmlLoader = new FXMLLoader();
		fxmlLoader.setControllerFactory(springContext::getBean);
		FisrFxI1ApplicationController controller = springContext.getBean(FisrFxI1ApplicationController.class);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {

		fxmlLoader.setLocation(getClass().getResource("/fxml/fisrv1.fxml"));
		rootNode = fxmlLoader.load();

		primaryStage.setTitle(PROJECT_TITLE);
		primaryStage.centerOnScreen();
		primaryStage.setOnCloseRequest(e -> {
			Platform.exit();
			System.exit(0);
		});
		Scene scene = new Scene(rootNode , WIDTH, HEIGHT);
		primaryStage.setScene(scene);
		primaryStage.show();
		log.info("primaryStage.show()");
	}
	@Override
	public void stop() {
		springContext.stop();
	}
}
