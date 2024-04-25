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
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;

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
    private Button Limpar;


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
    private Line Arresta1;

    @FXML
    private Line Arresta2;

    @FXML
    private Line Arresta3;

    @FXML
    private Line Arresta4;

    @FXML
    private Line Arresta5;

    @FXML
    private Line Arresta6;

    @FXML
    private Line Arresta7;

    @FXML
    private Circle circle1;

    @FXML
    private Circle circle2;

    @FXML
    private Circle circle3;

    @FXML
    private Circle circle4;

    @FXML
    private Circle circle5;

    @FXML
    private Circle circle6;

    @FXML
    private Circle circle7;

    @FXML
    private Circle circle8;

    @FXML
    private Label label1;

    @FXML
    private Label label2;

    @FXML
    private Label label3;

    @FXML
    private Label label4;

    @FXML
    private Label label5;

    @FXML
    private Label label6;

    @FXML
    private Label label7;

    @FXML
    private Label label8;



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

            label1.setText(l.getCaminho().get(0));
            label2.setText(l.getCaminho().get(1));
            label3.setText(l.getCaminho().get(2));
            label4.setText(l.getCaminho().get(3));
           // label5.setText(l.getCaminho().get(4));
           // label6.setText(l.getCaminho().get(5));
           // label7.setText(l.getCaminho().get(6));
           // label8.setText(l.getCaminho().get(7));

            circle1.setVisible(true);
            circle2.setVisible(true);
            circle3.setVisible(true);
            circle4.setVisible(true);
            circle5.setVisible(false);
            circle6.setVisible(false);
            circle7.setVisible(false);
            circle8.setVisible(false);

            Arresta1.setVisible(true);
            Arresta2.setVisible(true);
            Arresta3.setVisible(true);
            Arresta4.setVisible(false);
            Arresta5.setVisible(false);
            Arresta6.setVisible(false);
            Arresta7.setVisible(false);
            
            label1.setVisible(true);
            label2.setVisible(true);
            label3.setVisible(true);
            label4.setVisible(true);
            label5.setVisible(true);
            label6.setVisible(true);
            label7.setVisible(true);
            label8.setVisible(true);
            Limpar.setVisible(true);

            System.out.println();
            }
            if(selected==5){
            System.out.println("Busca Profundidade:");
            l.BuscaProfundidade("A", "F", no, grafo);
            textArea1.setText(l.getCaminho().toString());
            textFiledNiveis.setText(l.getNiveis().toString());
            labelCustos.setText(String.valueOf(l.getPeso()));
            Limpar.setVisible(true);
            label1.setText(l.getCaminho().get(0));
            label2.setText(l.getCaminho().get(1));
            label3.setText(l.getCaminho().get(2));
            label4.setText(l.getCaminho().get(3));
            circle1.setVisible(true);
            circle2.setVisible(true);
            circle3.setVisible(true);
            circle4.setVisible(true);

            circle1.setVisible(true);
            circle2.setVisible(true);
            circle3.setVisible(true);
            circle4.setVisible(true);
            circle5.setVisible(false);
            circle6.setVisible(false);
            circle7.setVisible(false);
            circle8.setVisible(false);

            Arresta1.setVisible(true);
            Arresta2.setVisible(true);
            Arresta3.setVisible(true);
            Arresta4.setVisible(false);
            Arresta5.setVisible(false);
            Arresta6.setVisible(false);
            Arresta7.setVisible(false);
            
            label1.setVisible(true);
            label2.setVisible(true);
            label3.setVisible(true);
            label4.setVisible(true);
            label5.setVisible(true);
            label6.setVisible(true);
            label7.setVisible(true);
            label8.setVisible(true);
            Limpar.setVisible(true);
                                    

            System.out.println();
            }
            if(selected==4){
            System.out.println("Busca Bi-Direcional:");
            l.buscaBidirecional("A", "F", no, grafo);
            textArea1.setText(l.getCaminho().toString());
            textFiledNiveis.setText(l.getNiveis().toString());
            labelCustos.setText(String.valueOf(l.getPeso()));
            Limpar.setVisible(true);

            }
            if(selected==2){
                System.out.println("Busca Profundidade-Limitada");
                l.BuscaProfundidadeLimitada("A", "F", no, grafo, this.limited);
                textArea1.setText(l.getCaminho().toString());
                textFiledNiveis.setText(l.getNiveis().toString());
                labelCustos.setText(String.valueOf(l.getPeso()));
                Limpar.setVisible(true);

            }
            if(selected==3){
                System.out.println("Busca Interativa");
                l.ProfundidadeInterativa("A", "F", no, grafo, limited);
                textArea1.setText(l.getCaminho().toString());
                textFiledNiveis.setText(l.getNiveis().toString());
                labelCustos.setText(String.valueOf(l.getPeso()));
                Limpar.setVisible(true);

            }
            /*
            circle1.setVisible(true);
            circle2.setVisible(true);
            circle3.setVisible(true);
            circle4.setVisible(true);
            circle5.setVisible(true);
            circle6.setVisible(true);
            circle7.setVisible(true);
            circle8.setVisible(true);

            Arresta1.setVisible(true);
            Arresta2.setVisible(true);
            Arresta3.setVisible(true);
            Arresta4.setVisible(true);
            Arresta5.setVisible(true);
            Arresta6.setVisible(true);
            Arresta7.setVisible(true);
            
            label1.setVisible(true);
            label2.setVisible(true);
            label3.setVisible(true);
            label4.setVisible(true);
            label5.setVisible(true);
            label6.setVisible(true);
            label7.setVisible(true);
            label8.setVisible(true);
            */
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

    @FXML
    void LimparGrafo(ActionEvent event) {
            circle1.setVisible(false);
            circle2.setVisible(false);
            circle3.setVisible(false);
            circle4.setVisible(false);
            circle5.setVisible(false);
            circle6.setVisible(false);
            circle7.setVisible(false);
            circle8.setVisible(false);

            Arresta1.setVisible(false);
            Arresta2.setVisible(false);
            Arresta3.setVisible(false);
            Arresta4.setVisible(false);
            Arresta5.setVisible(false);
            Arresta6.setVisible(false);
            Arresta7.setVisible(false);
            
            label1.setVisible(false);
            label2.setVisible(false);
            label3.setVisible(false);
            label4.setVisible(false);
            label5.setVisible(false);
            label6.setVisible(false);
            label7.setVisible(false);
            label8.setVisible(false);

            Limpar.setVisible(false);

    }

}
