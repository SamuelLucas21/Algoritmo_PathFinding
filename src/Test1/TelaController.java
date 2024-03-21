package Test1;

import java.util.ArrayList;
import java.util.List;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Spinner;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;

public class TelaController {
    private int selected =0, limited =0;
    
    @FXML
    private RadioButton Amplitude;

    @FXML
    private RadioButton Aprofundamento_Iterativo;

    @FXML
    private RadioButton Busca_Bidirecional;

    @FXML
    private RadioButton Profundidade;

    @FXML
    private RadioButton Profundidade_Limitada;

    @FXML
    private Pane Tela_Screen;

    @FXML
    private Button button1;

    @FXML
    private Label labelCustos;

    @FXML
    private Spinner<Integer> SpinLimit;

    @FXML
    private TextArea textArea1;

    @FXML
    private TextField textFieldNos;

    @FXML
    private TextField textFiledNiveis;

    @FXML
    private Label LimitedLabel;

    @FXML
    void AuxLimit(MouseEvent event) {
        
    }

    @FXML
    void onClickedPressed(ActionEvent event) {
            //limited=this.SpinLimit.getValue().intValue();
			Lista l = new Lista();
		 	List<String> grafo = new ArrayList<>();
	
			String []no = l.Gerar_No("grafos.txt");
			
			grafo.addAll(l.Gerar_Grafo("grafos.txt"));
			
            if(selected==1){
            System.out.println("Busca Amplitude:");
			l.Busca("A", "F", no, grafo);
            textArea1.setText(l.getCaminho().toString());
            textFiledNiveis.setText(l.getNiveis().toString());
            labelCustos.setText(String.valueOf(l.getPeso()));
            
            System.out.println();
            }
            if(selected==5){
            System.out.println("Busca Profundidade:");
            l.BuscaProfundidade("A", "F", no, grafo);
            textArea1.setText(l.getCaminho().toString());
            textFiledNiveis.setText(l.getNiveis().toString());
            labelCustos.setText(String.valueOf(l.getPeso()));
            
            System.out.println();
            }
            if(selected==4){
            System.out.println("Busca Bi-Direcional:");
            l.buscaBidirecional("A", "F", no, grafo);
            textArea1.setText(l.getCaminho().toString());
            textFiledNiveis.setText(l.getNiveis().toString());
            labelCustos.setText(String.valueOf(l.getPeso()));
            
            }
            if(selected==2){
                System.out.println("Busca Profundidade-Limitada");
                l.BuscaProfundidadeLimitada("A", "F", no, grafo, this.limited);
                textArea1.setText(l.getCaminho().toString());
                textFiledNiveis.setText(l.getNiveis().toString());
                labelCustos.setText(String.valueOf(l.getPeso()));
            
            }
            if(selected==3){
                System.out.println("Busca Interativa");
                l.ProfundidadeInterativa("A", "F", no, grafo, limited);
                textArea1.setText(l.getCaminho().toString());
                textFiledNiveis.setText(l.getNiveis().toString());
                labelCustos.setText(String.valueOf(l.getPeso()));
            
            }
    }
    @FXML
    void FucAmplitude(ActionEvent event) {
        if(this.Amplitude.isSelected()==true){
            this.Aprofundamento_Iterativo.setSelected(false);
            this.Busca_Bidirecional.setSelected(false);
            this.Profundidade.setSelected(false);
            this.Profundidade_Limitada.setSelected(false);
            this.selected=1;
            this.SpinLimit.setVisible(false);
            this.LimitedLabel.setVisible(false);

        }
    }
    @FXML
    void FucProfundidade_Limit(ActionEvent event) {
        if(this.Profundidade_Limitada.isSelected()==true){
            this.Aprofundamento_Iterativo.setSelected(false);
            this.Busca_Bidirecional.setSelected(false);
            this.Profundidade.setSelected(false);
            this.Amplitude.setSelected(false);
            this.selected=2;
            this.SpinLimit.setVisible(true);
            this.LimitedLabel.setVisible(true);
        }
    }

    @FXML
    void FunAprofundamento_Ite(ActionEvent event) {
        if(this.Aprofundamento_Iterativo.isSelected()==true){
            this.Amplitude.setSelected(false);
            this.Busca_Bidirecional.setSelected(false);
            this.Profundidade.setSelected(false);
            this.Profundidade_Limitada.setSelected(false);
            this.selected=3;
            this.SpinLimit.setVisible(true);
            this.LimitedLabel.setVisible(true);
        }
    }

    @FXML
    void FuncBusca_Bidirecional(ActionEvent event) {
        if(this.Busca_Bidirecional.isSelected()==true){
            this.Aprofundamento_Iterativo.setSelected(false);
            this.Amplitude.setSelected(false);
            this.Profundidade.setSelected(false);
            this.Profundidade_Limitada.setSelected(false);
            this.selected=4;
            this.SpinLimit.setVisible(false);
            this.LimitedLabel.setVisible(false);
        }
    }

    @FXML
    void FuncProfundidade(ActionEvent event) {
        if(this.Profundidade.isSelected()==true){
            this.Aprofundamento_Iterativo.setSelected(false);
            this.Busca_Bidirecional.setSelected(false);
            this.Amplitude.setSelected(false);
            this.Profundidade_Limitada.setSelected(false);
            this.selected=5;
            this.SpinLimit.setVisible(false);
            this.LimitedLabel.setVisible(false);

        }
    }

}
