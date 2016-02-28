package mx.friendzoneteam.chelathon;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by gianpa on 2/27/16.
 */
public class PartyListAdapter extends RecyclerView.Adapter<PartyListAdapter.ViewHolder> {
    private List<Party> partyList;

    public PartyListAdapter() {
        this(null);
    }

    public PartyListAdapter(List<Party> partyList) {
        this.partyList = partyList;
    }

    public void swapPartyList(List<Party> partyList) {
        this.partyList = partyList;
        notifyDataSetChanged();
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_party, parent, false));
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.name.setText(partyList.get(position).name);
    }

    @Override
    public int getItemCount() {
        if(partyList != null) {
            return partyList.size();
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
