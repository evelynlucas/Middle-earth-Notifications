package org.pursuit.homework0302;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class TolkienViewHolder extends RecyclerView.ViewHolder {
    private TextView nameTextView;
    private ImageView imageView;
    private TextView messageTextView;
    private Intent intent;

    public TolkienViewHolder(@NonNull View itemView) {
        super(itemView);
        nameTextView = itemView.findViewById(R.id.name_text_view);
        imageView = itemView.findViewById(R.id.image_view);
        messageTextView = itemView.findViewById(R.id.message_text_view);
    }


    public void onBind(final TolkienCharacter tolkienCharacter) {
        nameTextView.setText(tolkienCharacter.getName());
        messageTextView.setText(tolkienCharacter.getMessage());
        imageView.setImageResource(tolkienCharacter.getImageView());

        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(itemView.getContext(), SecondActivity.class);
                intent.putExtra("name", tolkienCharacter.getName());
                intent.putExtra("message", tolkienCharacter.getMessage());
                intent.putExtra("image", tolkienCharacter.getImageView());
                itemView.getContext().startActivity(intent);

            }
        });
    }
}
