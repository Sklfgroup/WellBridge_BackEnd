package com.wellbridge.wellbridge.services.Notification;

import com.google.firebase.messaging.FirebaseMessaging;
import com.google.firebase.messaging.Message;
import com.google.firebase.messaging.Notification;
import com.wellbridge.wellbridge.dao.entities.account.AccountEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NotificationService {

    private static final Logger log = LoggerFactory.getLogger(NotificationService.class);
    @Autowired
    private FirebaseMessaging firebaseMessaging;

    public void sendAccessRequestNotification(AccountEntity patient, AccountEntity medecin, Long accessRequestId) {
        String patientFirebaseToken = patient.getFirebaseToken();

        if (patientFirebaseToken != null && !patientFirebaseToken.isEmpty()) {
            Notification notification = Notification.builder()
                    .setTitle("Accès aux informations médicales")
                    .setBody("Le médecin " + medecin.getFirstname() + " souhaite accéder à vos informations médicales.")
                    .build();

            Message message = Message.builder()
                    .setToken(patientFirebaseToken)
                    .setNotification(notification)
                    .putData("medecinUuid", medecin.getUuid())
                    .putData("accessRequest", accessRequestId.toString())
                    .putData("type", "ACCESS_REQUEST")
                    .build();

            try {
                firebaseMessaging.send(message);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void sendAccessResponseNotification(AccountEntity medecin, boolean isApproved, Long accessRequestId) {
        String medecinFirebaseToken = medecin.getFirebaseToken();

        if (medecinFirebaseToken != null && !medecinFirebaseToken.isEmpty()) {
            String bodyMessage = isApproved ? "Votre demande d'accès a été approuvée." : "Votre demande d'accès a été rejetée.";

            Notification notification = Notification.builder()
                    .setTitle("Réponse à la demande d'accès")
                    .setBody(bodyMessage)
                    .build();

            Message message = Message.builder()
                    .setToken(medecinFirebaseToken)
                    .setNotification(notification)
                    .putData("type", "ACCESS_RESPONSE")
                    .putData("status", isApproved ? "APPROVED" : "REJECTED")
                    .build();

            try {
                firebaseMessaging.send(message);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}