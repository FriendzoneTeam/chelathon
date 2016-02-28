package mx.friendzoneteam.chelathon.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import mx.friendzoneteam.chelathon.R;
import mx.friendzoneteam.chelathon.fragments.VenueListFragment;

public class VenueListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_venue_list);

        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction().add(R.id.content, VenueListFragment.newInstance()).commit();
        }
    }
}
