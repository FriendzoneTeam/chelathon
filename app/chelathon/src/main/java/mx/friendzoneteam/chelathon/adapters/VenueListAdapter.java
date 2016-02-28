package mx.friendzoneteam.chelathon.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import mx.friendzoneteam.chelathon.R;
import mx.friendzoneteam.chelathon.model.Venue;

/**
 * Created by gianpa on 2/27/16.
 */
public class VenueListAdapter extends RecyclerView.Adapter<VenueListAdapter.ViewHolder> {
    private List<Venue> venueList;

    public VenueListAdapter() {
        this(null);
    }

    public VenueListAdapter(List<Venue> venueList) {
        this.venueList = venueList;
    }

    public void swapPartyList(List<Venue> venueList) {
        this.venueList = venueList;
        notifyDataSetChanged();
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_venue, parent, false));
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.name.setText(venueList.get(position).name);
    }

    @Override
    public int getItemCount() {
        if (venueList != null) {
            return venueList.size();
        }

        return 0;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        @Bind(R.id.name)
        TextView name;

        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
