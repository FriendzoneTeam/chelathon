package mx.friendzoneteam.chelathon.fragments;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.OnMapReadyCallback;

import butterknife.Bind;
import butterknife.ButterKnife;
import mx.friendzoneteam.chelathon.P;
import mx.friendzoneteam.chelathon.R;
import mx.friendzoneteam.chelathon.model.Venue;

public class EditVenueFragment extends Fragment implements OnMapReadyCallback {

    @Bind(R.id.name_edit_text)
    EditText nameEditText;

    @Bind(R.id.address_1_edit_text)
    EditText address1EditText;

    @Bind(R.id.address_2_edit_text)
    EditText address2EditText;

    @Bind(R.id.map_View)
    MapView mapView;

    @Bind(R.id.save_button)
    Button saveButton;

    private GoogleMap googleMap;
    private Venue venue;

    public static EditVenueFragment newInstance(Venue venue) {

        Bundle args = new Bundle();
        args.putParcelable(P.Venue.VENUE, venue);

        EditVenueFragment fragment = new EditVenueFragment();
        fragment.setArguments(args);
        return fragment;
    }

    public EditVenueFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (savedInstanceState == null) {
            venue = getArguments().getParcelable(P.Venue.VENUE);
        } else {
            venue = savedInstanceState.getParcelable(P.Venue.VENUE);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_venue, container, false);
        ButterKnife.bind(this, view);

        mapView.onCreate(savedInstanceState);
        mapView.getMapAsync(this);

        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        if (mapView != null) {
            mapView.onResume();
        }
    }

    @Override
    public void onPause() {
        super.onPause();
        if (mapView != null) {
            mapView.onPause();
        }
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        outState.putParcelable(P.Venue.VENUE, venue);
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        this.googleMap = googleMap;
        this.googleMap.getUiSettings().setAllGesturesEnabled(false);
    }
}
