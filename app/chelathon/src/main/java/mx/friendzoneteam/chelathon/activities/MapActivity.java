package mx.friendzoneteam.chelathon.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import butterknife.Bind;
import butterknife.ButterKnife;
import mx.friendzoneteam.chelathon.P;
import mx.friendzoneteam.chelathon.R;
import mx.friendzoneteam.chelathon.fragments.MapFragment;
import mx.friendzoneteam.chelathon.model.Location;

public class MapActivity extends AppCompatActivity {

    @Bind(R.id.save_button)
    Button saveButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map);
        ButterKnife.bind(this);

        if (savedInstanceState == null) {
            Location location = getIntent().getParcelableExtra(P.LOCATION);
            getSupportFragmentManager().beginTransaction().add(R.id.content, MapFragment.newInstance(location)).commit();
        }

        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MapFragment mapFragment = (MapFragment) getSupportFragmentManager().findFragmentById(R.id.content);
                Location location = mapFragment.getLocation();

                Intent data = new Intent();
                data.putExtra(P.LOCATION, location);

                setResult(RESULT_OK, data);
                finish();
            }
        });
    }
}
