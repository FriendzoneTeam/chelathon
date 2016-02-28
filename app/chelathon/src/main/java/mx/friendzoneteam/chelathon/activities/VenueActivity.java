package mx.friendzoneteam.chelathon.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import mx.friendzoneteam.chelathon.P;
import mx.friendzoneteam.chelathon.R;
import mx.friendzoneteam.chelathon.fragments.EditVenueFragment;
import mx.friendzoneteam.chelathon.model.Venue;

public class VenueActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_venue);

        if(savedInstanceState == null) {
            Bundle extras = getIntent().getExtras();
            if (extras.containsKey(P.Venue.VENUE_EDIT)) {
                Venue venue = extras.getParcelable(P.Venue.VENUE_EDIT);
                EditVenueFragment editVenueFragment = EditVenueFragment.newInstance(venue);
                getSupportFragmentManager().beginTransaction().replace(R.id.content, editVenueFragment).commit();
            }
        }
    }
}
