import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class App extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        // O FXMLLoader vai ler o arquivo visual que você criou na pasta resources
        Parent root = FXMLLoader.load(getClass().getResource("/Atendente.fxml"));

        // Configura o título da janela (Stage)
        primaryStage.setTitle("Reciclaplan - Módulo Atendente");

        // Cria a cena (Scene) com o nosso visual dentro e define o tamanho inicial
        primaryStage.setScene(new Scene(root, 400, 350));

        // Mostra a janela na ecrã!
        primaryStage.show();
    }

    public static void main(String[] args) {
        // O método launch avisa o JavaFX para preparar os motores e chamar o método start() acima
        launch(args);
    }
}
