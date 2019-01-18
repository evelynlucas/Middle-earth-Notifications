package org.pursuit.Notification_App_HW_LUCAS_EVELYN;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

public class TolkienAdapter extends RecyclerView.Adapter<TolkienViewHolder> {

    private List<TolkienCharacter> tolkienCharacterList;

    public TolkienAdapter(List<TolkienCharacter> tolkienCharacterList) {
        this.tolkienCharacterList = tolkienCharacterList;
    }

    @NonNull
    @Override
    public TolkienViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View childView = LayoutInflater.from(parent.getContext()).inflate(R.layout.view_item, parent, false);
        return new TolkienViewHolder(childView);
    }

    @Override
    public void onBindViewHolder(@NonNull TolkienViewHolder tolkienViewHolder, int position) {
        TolkienCharacter tolkienCharacter = tolkienCharacterList.get(position);
        tolkienViewHolder.onBind(tolkienCharacter);
    }

    @Override
    public int getItemCount() {
        return tolkienCharacterList.size();
    }
}
