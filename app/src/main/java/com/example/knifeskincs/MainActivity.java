package com.example.knifeskincs;

import android.os.Bundle;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.knifeskincs.data.database.AppDatabase;
import com.example.knifeskincs.data.models.Knife;
import com.example.knifeskincs.utils.DatabaseInitializer;

import java.util.List;

public class MainActivity extends AppCompatActivity
    private KnifeViewModel mViewModel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        DatabaseInitializer.populateDatabaseAsync(AppDatabase.getInstance(getApplicationContext()));

        mViewModel = new ViewModelProvider(this).get(KnifeViewModel.class);
        mViewModel.setDao(AppDatabase.getInstance(getApplicationContext()).getKnifeDao());

    }

    public void listKnifes() {
        LiveData<List<Knife>> knifes = mViewModel.getAllKnifes();

        MainActivity mThis = this;
        knifes.observe(this, new Observer<List<Knife>>() {
            @Override
            public void onChanged(List<Knife> knifes) {
                for (Knife knife : knifes) {
                    Toast.makeText(mThis, knife.getName(), Toast.LENGTH_SHORT);
                }
            }
        });
    }


}
