/*
 * TP2MotDePasseControlleur.java                                    22 avr. 2023
 * IUT de Rodez, info1 2022-2023, aucun copyright ni copyleft
 * Classe contrôleur qui gère la vue SBMDP.fxml
 */
package application.tp2.mdp;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.text.Text;

/**
 * <p> 
 * Classe contrôleur qui gère l'interactivité avec la vue décrite dans le fichier fxml 
 * SBMDP.fxml
 * </p>
 * L'utilisateur peut : 
 * <ul>
 *     <li>
 *         générer un mot de passe, en utilisant la classe 
 *         {@link application.tp2.mdp.MotDePasse  MotDePasse}
 *         Il sera affiché dans le Text resultat.
 *     </li>
 *     <li>
 *         effacer le mot de passe générer, 
 *         ce qui remettra l'interface à zéro
 *     </li>
 * </ul>
 *
 * @author François de Saint Palais
 */
public class MotDePasseControlleur {

    /** Text où afficher le résultat */
    @FXML 
    private Label resultat;

    @FXML
    void initialize() {
        resultat.setText("?");
    }
    
    @FXML
    private void effacerResultat() {
        System.out.println("Effacer cliqué");
        resultat.setText("?");
    }
    
    @FXML
    private void genererMDP () {
        System.out.println("Générer cliqué");
        MotDePasse motDePasseGenere = new MotDePasse();
        resultat.setText(motDePasseGenere.getMot());
    }
}
