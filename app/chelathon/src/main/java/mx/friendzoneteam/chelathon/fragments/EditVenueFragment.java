package mx.friendzoneteam.chelathon.fragments;


import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.google.android.gms.maps.GoogleMap;

import butterknife.Bind;
import butterknife.ButterKnife;
import mx.friendzoneteam.chelathon.P;
import mx.friendzoneteam.chelathon.R;
import mx.friendzoneteam.chelathon.activities.MapActivity;
import mx.friendzoneteam.chelathon.model.Location;
import mx.friendzoneteam.chelathon.model.Venue;

public class EditVenueFragment extends Fragment implements LocationListener {

    private static final int MAP_ACTIVITY_REQUEST_CODE = 1;

    @Bind(R.id.name_edit_text)
    EditText nameEditText;

    @Bind(R.id.address_1_edit_text)
    EditText address1EditText;

    @Bind(R.id.address_2_edit_text)
    EditText address2EditText;

    @Bind(R.id.map_image_view)
    ImageView mapImageView;

    @Bind(R.id.save_button)
    Button saveButton;

    private GoogleMap googleMap;
    private Venue venue;
    private LocationManager locationManager;

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

        locationManager = (LocationManager) getActivity().getSystemService(Context.LOCATION_SERVICE);

        if (savedInstanceState == null) {
            venue = getArguments().getParcelable(P.Venue.VENUE);
        } else {
            venue = savedInstanceState.getParcelable(P.Venue.VENUE);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_venue_edit, container, false);
        ButterKnife.bind(this, view);

        if (venue.location != null) {
            loadMap(venue.location);
        }
        mapImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Location location = new Location();

                if (venue.location != null) {
                    location = venue.location;
                }

                Intent mapIntent = new Intent(getActivity(), MapActivity.class);
                mapIntent.putExtra(P.LOCATION, location);
                startActivityForResult(mapIntent, MAP_ACTIVITY_REQUEST_CODE);
            }
        });

        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        if(venue.location != null) {
            return;
        }

        if (ActivityCompat.checkSelfPermission(getActivity(), Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(getActivity(), Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return;
        }
        locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 5000, 10, this);
    }

    @Override
    public void onPause() {
        super.onPause();
        if (ActivityCompat.checkSelfPermission(getActivity(), Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(getActivity(), Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return;
        }
        locationManager.removeUpdates(this);
    }

    private void loadMap(Location location) {
        String url = "http://maps.google.com/maps/api/staticmap?center=" + location.latitude + "," + location.longitude + "&zoom=15&size=200x200&sensor=false";
        Glide.with(this).load(url).into(mapImageView);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == MAP_ACTIVITY_REQUEST_CODE && resultCode == Activity.RESULT_OK) {
            venue.location = data.getParcelableExtra(P.LOCATION);
            loadMap(venue.location);
        }
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        outState.putParcelable(P.Venue.VENUE, venue);
    }

    @Override
    public void onLocationChanged(android.location.Location location) {
        venue.location = new Location(location.getLatitude(), location.getLongitude());
        loadMap(venue.location);
    }

    @Override
    public void onStatusChanged(String provider, int status, Bundle extras) {

    }

    @Override
    public void onProviderEnabled(String provider) {

    }

    @Override
    public void onProviderDisabled(String provider) {

    }
}
