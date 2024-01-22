package com.example.messengerbluetooth.activities;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.messengerbluetooth.utilities.Constants;
import com.example.messengerbluetooth.utilities.PreferenceManager;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

public class BaseActivity extends AppCompatActivity {
    private DocumentReference documentReference;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        // Remember to override method with one argument only
        super.onCreate(savedInstanceState);
        PreferenceManager preferenceManager = new PreferenceManager(getApplicationContext());
        FirebaseFirestore database = FirebaseFirestore.getInstance();
        documentReference = database.collection(Constants.KEY_COLLECTION_USERS)
                .document(preferenceManager.getString(Constants.KEY_USER_ID));
    }

    @Override
    protected void onPause() { //Out_app
        super.onPause();
        documentReference.update(Constants.KEY_AVAILABILITY, 0 );
    }

    @Override
    protected void onResume() { //In_app
        super.onResume();
        documentReference.update(Constants.KEY_AVAILABILITY,1);
    }
}
