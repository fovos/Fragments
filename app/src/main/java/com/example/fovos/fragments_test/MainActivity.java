package com.example.fovos.fragments_test;

import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
/*
*Klasi i opoia
*
*/

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    //FIELDS
    public String message="Hello Fragment A";
    public String message2="Hello Fragment B";

    Button btn_add_frag,btn_replace_frag;

    public String get_message(){
        return message;
    }

    public String get_message2(){
        return message2;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn_add_frag=(Button)findViewById(R.id.btn_add_fragment);
        btn_add_frag.setOnClickListener(this);
        btn_replace_frag=(Button)findViewById(R.id.btn_replace_fragment);
        btn_replace_frag.setOnClickListener(this);

        //Fragment_A has been inflated into the Main Activity Layout, via the proper Fragment element in MainActivity Layout XML file.
        //Below, we inflate another fragment (fragment_B) programmatically.
        getSupportFragmentManager().beginTransaction()
                .add(R.id.maincontent, new FragmentB())
                .commit();
    }


    @Override
    public void onClick(View v) {
        if(v==btn_add_frag){
            //inflate/add fragment B to the mainactivity Layout
            //addtoBackstack wste patwntas Back button na epistrefw stin proigoumeni katastasi
            //na afairountai diladi ta fragments pou prosthesa
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.maincontent, new FragmentB())
                    .addToBackStack(null)
                    .commit();


        }
        else if(v==btn_replace_frag){

            /*
            Den mporoume na ektelesoume replace se statically orismeno fragment (diladi to Fragment A)
            You cannot replace a fragment that is statically placed in an xml layout file.
            You should create a container (e.g. a FrameLayout) in the layout and then add the fragment programatically using FragmentTransaction.
            */
            //replace the Fragment B with Fragment A
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.maincontent, new FragmentA())
                    .addToBackStack(null)
                    .commit();
        }
    }
}
