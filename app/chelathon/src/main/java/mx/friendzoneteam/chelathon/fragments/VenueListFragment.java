package mx.friendzoneteam.chelathon.fragments;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.Loader;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import mx.friendzoneteam.chelathon.R;
import mx.friendzoneteam.chelathon.adapters.VenueListAdapter;
import mx.friendzoneteam.chelathon.loaders.VenueListLoader;
import mx.friendzoneteam.chelathon.model.Venue;

public class VenueListFragment extends Fragment implements LoaderManager.LoaderCallbacks<List<Venue>> {
    @Bind(R.id.recyclerview)
    RecyclerView recyclerView;

    private VenueListAdapter venueListAdapter;

    public VenueListFragment() {
        // Required empty public constructor
    }

    public static VenueListFragment newInstance() {
        return new VenueListFragment();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        venueListAdapter = new VenueListAdapter();

        getLoaderManager().initLoader(0, null, this);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_party_list, container, false);
        ButterKnife.bind(this, view);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(linearLayoutManager);

        recyclerView.setAdapter(venueListAdapter);

        return view;
    }

    @Override
    public Loader<List<Venue>> onCreateLoader(int id, Bundle args) {
        return new VenueListLoader(getActivity());
    }

    @Override
    public void onLoadFinished(Loader<List<Venue>> loader, List<Venue> data) {
        venueListAdapter.swapPartyList(data);
    }

    @Override
    public void onLoaderReset(Loader<List<Venue>> loader) {
        venueListAdapter.swapPartyList(null);
    }

}
