package mx.friendzoneteam.chelathon.loaders;

import android.content.Context;
import android.support.v4.content.Loader;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import mx.friendzoneteam.chelathon.model.Party;

/**
 * Created by gianpa on 2/27/16.
 */
public class PartyListLoader extends Loader<List<Party>> {
    private static final String TAG = PartyListLoader.class.getSimpleName();

    private List<Party> partyList;

    public PartyListLoader(Context context) {
        super(context);
    }

    @Override
    protected void onStartLoading() {
        if(partyList != null) {
            deliverResult(partyList);
        }

        forceLoad();
    }

    @Override
    protected void onForceLoad() {
        Log.d(TAG, "onForceLoad");

        partyList = new ArrayList<>();

        Party party = new Party();
        party.id = 42;
        party.name = "Party";
        partyList.add(party);

        if(isStarted()) {
            deliverResult(partyList);
        }
    }

    @Override
    protected void onStopLoading() {
        cancelLoad();
    }

    @Override
    protected void onReset() {
        cancelLoad();
        partyList = null;
    }
}
