package mx.friendzoneteam.chelathon.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import mx.friendzoneteam.chelathon.fragments.PartyListFragment;
import mx.friendzoneteam.chelathon.R;

public class PartiesActivity extends AppCompatActivity {

    private static final String TAG = PartiesActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_parties);

        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction().add(R.id.content, new PartyListFragment()).commit();
        }
    }
}
