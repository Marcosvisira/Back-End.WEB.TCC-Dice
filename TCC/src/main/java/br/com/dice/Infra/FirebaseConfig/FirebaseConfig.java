package br.com.dice.Infra.FirebaseConfig;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.FileInputStream;
import java.io.IOException;

@Configuration
public class FirebaseConfig {

    @Bean 
    public FirebaseApp initializeFirebaseApp() throws IOException {
        FileInputStream serviceAccount = new FileInputStream("dicetcc-firebase-adminsdk-tycs0-d70eb66e80.json"); // Substitua pelo caminho real

        FirebaseOptions options = new FirebaseOptions.Builder()
                .setCredentials(GoogleCredentials.fromStream(serviceAccount))
                .setDatabaseUrl("https://dicetcc-default-rtdb.firebaseio.com") // Substitua pela URL do seu projeto Firebase
                .build();

        return FirebaseApp.initializeApp(options);
    }
}