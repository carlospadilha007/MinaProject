package com.mina.minaproject.helper;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.FirebaseFirestore;

public class ConfiguracaoFirebase {
    private static FirebaseFirestore firestore;
    private static FirebaseAuth autenticador;
    //aqui colocar o atributo do FirebaseAuth


    public static FirebaseFirestore getFirestore(){
        if(firestore == null){
            firestore = FirebaseFirestore.getInstance();
        }
        return firestore;
    }

    public static FirebaseAuth getAutenticador() {
        if(autenticador == null){
            autenticador=FirebaseAuth.getInstance();
        }

        return autenticador;
    }
}
