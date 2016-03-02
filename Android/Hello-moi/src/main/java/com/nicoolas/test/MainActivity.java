package com.nicoolas.test;
 
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
/*
Tuto disponible à cette adresse :
    http://www.tutomobile.fr/premiere-application-hello-moi-tutoriel-android-n%C2%B03/15/06/2010/
*/
public class MainActivity extends Activity {

    //Déclaration des objets qui seront utiles
	private EditText editText; //zone d'édition de textE
	private Button button;     //Bouton
	private String prenom;    //La variable qui contiendra la saisit et sera injectée dans un string
 
    /*Called when the activity is first created.*/
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);//lie l'activité à l'activity_main.xml
 
        /*récupération du prenomHint grâce à son ID EditTextPrenom. (création de l'objet)
        prenomHint se trouve dans le string XML
        l'ID EditTextPrenom a été décrit dans le activity_main.xml (res>layout)
        EditText est le texte grisé dans le champs de saisit. Il commente ce qui est attendu*/
        editText = (EditText) findViewById(R.id.EditTextPrenom);
 
        //récupération du bouton grâce à son ID
        button = (Button) findViewById(R.id.ButtonEnvoyer);
 
        //on applique un écouteur d'évenement au clique sur le bouton
        button.setOnClickListener(
                new OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        //on récupère le texte écrit dans l'EditText
                        prenom = editText.getText().toString();

/*on affiche "Hello votrePrenom !" dans une petit pop-up qui s'affiche quelques seconde
 *en bas d'écran
*/
                        Toast.makeText(MainActivity.this, "Hello "
                                + prenom
                                + " !", Toast.LENGTH_LONG).show();
 
/*on affiche "Hello votrePrenom ! " dans un textView que l'on a créé tout à l'heure
 * et dont on avait pas précisé la valeur de son texte il s'agit du dernier TextView dans le fichier
 * main.xml
 * De toute façon grâce à l'ID vous devrez facilement le trouver dans le fichier main.xml
*/
                        ((TextView) findViewById(R.id.TextViewHello)).setText("Hello " + prenom + " !");
                    }
                }
        );}
}