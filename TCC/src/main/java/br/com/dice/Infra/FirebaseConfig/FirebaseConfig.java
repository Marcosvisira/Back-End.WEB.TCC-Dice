/*package br.com.dice.Infra.FirebaseConfig;

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
    public FirebaseApp firebaseApp() throws IOException {
        // Carregue as credenciais do Firebase Admin SDK
        GoogleCredentials credentials = GoogleCredentials.fromStream(
                getClass().getResourceAsStream("dicetcc-firebase-adminsdk-tycs0-d70eb66e80.json")
        );

        FirebaseOptions options = FirebaseOptions.builder()
                .setCredentials(credentials)
                .build();

        return FirebaseApp.initializeApp(options);
    }


    }
*/