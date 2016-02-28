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
import mx.friendzoneteam.chelathon.loaders.PartyListLoader;
import mx.friendzoneteam.chelathon.R;
import mx.friendzoneteam.chelathon.adapters.PartyListAdapter;
import mx.friendzoneteam.chelathon.model.Party;

/**
 * Created by gianpa on 2/27/16.
 */
public class PartyListFragment extends Fragment implements LoaderManager.LoaderCallbacks<List<Party>> {
    @Bind(R.id.recyclerview)
    RecyclerView recyclerView;

    private PartyListAdapter partyListAdapter;

    public PartyListFragment() {
        // Required empty public constructor
    }

    public static PartyListFragment newInstance() {
        return new PartyListFragment();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        partyListAdapter = new PartyListAdapter();

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

        recyclerView.setAdapter(partyListAdapter);

        return view;
    }

    @Override
    public Loader<List<Party>> onCreateLoader(int id, Bundle args) {
        return new PartyListLoader(getActivity());
    }

    @Override
    public void onLoadFinished(Loader<List<Party>> loader, List<Party> data) {
        partyListAdapter.swapPartyList(data);
    }

    @Override
    public void onLoaderReset(Loader<List<Party>> loader) {
        partyListAdapter.swapPartyList(null);
    }

}
