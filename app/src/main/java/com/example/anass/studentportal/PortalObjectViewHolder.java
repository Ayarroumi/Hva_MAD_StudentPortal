package com.example.anass.studentportal;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

public class PortalObjectViewHolder extends RecyclerView.ViewHolder  {

    public TextView portalName;

    public PortalObjectViewHolder(View itemView) {
        super(itemView);

        portalName = itemView.findViewById(R.id.PortalName);
    }


}
