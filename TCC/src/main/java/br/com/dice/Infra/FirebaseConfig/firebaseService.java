/*package br.com.dice.Infra.FirebaseConfig;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import org.springframework.stereotype.Service;

@Service
public class firebaseService {

    private final DatabaseReference database;

    public firebaseService(FirebaseDatabase firebaseDatabase) {
        this.database = firebaseDatabase.getReference();
    }

    public void saveData(String key, Object data) {
        database.child(key).setValueAsync(data);
    }

    public Object getData(String key) {
        // Recupere os dados do Firebase Realtime Database
        // ...

        return null;
    }

    // Outros métodos para manipular dados no Firebase
}*/