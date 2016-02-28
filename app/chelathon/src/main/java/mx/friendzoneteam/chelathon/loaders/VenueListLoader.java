package mx.friendzoneteam.chelathon.loaders;

import android.content.Context;
import android.support.v4.content.Loader;

import java.util.ArrayList;
import java.util.List;

import mx.friendzoneteam.chelathon.model.Location;
import mx.friendzoneteam.chelathon.model.Venue;

/**
 * Created by gianpa on 2/27/16.
 */
public class VenueListLoader extends Loader<List<Venue>> {
    private static final String TAG = VenueListLoader.class.getSimpleName();

    private List<Venue> venueList;

    public VenueListLoader(Context context) {
        super(context);
    }

    @Override
    protected void onStartLoading() {
        if (venueList != null) {
            deliverResult(venueList);
        }

        forceLoad();
    }

    @Override
    protected void onForceLoad() {
        venueList = new ArrayList<>();

        Venue venue = new Venue();
        venue.name = "My house";
        venue.location = new Location(19.4282736, -99.2087178);
        venueList.add(venue);

        if (isStarted()) {
            deliverResult(venueList);
        }
    }

    @Override
    protected void onStopLoading() {
        cancelLoad();
    }

    @Override
    protected void onReset() {
        cancelLoad();
        venueList = null;
    }
}
