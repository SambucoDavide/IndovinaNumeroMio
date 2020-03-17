package it.polito.tdp.indovinanumber;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;

public class FXMLController {
	private final int NMAX = 100;
	private final int TMAX = 8;
	private int segreto;
	private int tentativifatti;
	private boolean inGioco = false;
	
	
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextArea txtrisultato;

    @FXML
    private Button btmnuova;

    @FXML
    private TextField txtrimasti;

    @FXML
    private HBox layautTentativo;

    @FXML
    private TextField txttentativi;

    @FXML
    private Button btmprova;

    @FXML
    void doNuova(ActionEvent event) {
    	// gestione dell' inizio di una nuova partita
    	this.segreto = (int)(Math.random() * NMAX) + 1;
    	this.tentativifatti = 0;
    	this.inGioco = true;
    	
    	// gestione dell' interfaccia
    	layautTentativo.setDisable(false);
    	txtrisultato.clear();
    	txtrimasti.setText(Integer.toString(TMAX));
    	

    }

    @FXML
    void doTentativo(ActionEvent event) {
    	// leggere l'imput dell' utente
    	String ts = txttentativi.getText();
    	int tentativo;
    	try {
    	tentativo = Integer.parseInt(ts);
    	} catch (NumberFormatException e) {
    		txtrisultato.appendText("Devi inserire un numero!\n");
    		return;
    	}
    	this.tentativifatti ++;
    	
    	if(tentativo == this.segreto) {
    		txtrisultato.appendText("Hai vinto! Hai utilizzato " + this.tentativifatti + " tentativi\n");
    		layautTentativo.setDisable(true);
    		this.inGioco = false;
    		return;
    	}
    	
    	if (tentativifatti == TMAX) {
    		txtrisultato.appendText("Hai perso! il numero segreto era: " + this.segreto);
    		layautTentativo.setDisable(true);
    		this.inGioco = false;
    		return;
    	}
    	
    	// Dire se era troppo alto o troppo basso
    	
    	if(tentativo < this.segreto)
    		txtrisultato.appendText("Tentativo troppo basso\n");
    	else 
    		txtrisultato.appendText("Tentativo troppo alto\n");
    	
    	txtrimasti.setText(Integer.toString(TMAX-tentativifatti));
    }

    @FXML
    void initialize() {
        assert txtrisultato != null : "fx:id=\"txtrisultato\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btmnuova != null : "fx:id=\"btmnuova\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txtrimasti != null : "fx:id=\"txtrimasti\" was not injected: check your FXML file 'Scene.fxml'.";
        assert layautTentativo != null : "fx:id=\"layautTentativo\" was not injected: check your FXML file 'Scene.fxml'.";
        assert txttentativi != null : "fx:id=\"txttentativi\" was not injected: check your FXML file 'Scene.fxml'.";
        assert btmprova != null : "fx:id=\"btmprova\" was not injected: check your FXML file 'Scene.fxml'.";

    }
}
