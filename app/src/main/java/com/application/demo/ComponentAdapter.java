package com.application.demo;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ComponentAdapter extends RecyclerView.Adapter<ComponentAdapter.VH> {

    private final ArrayList<BasicComponentsInfo> mInfos;

    private OnItemClickListener<BasicComponentsInfo> mListener;

    public ComponentAdapter(ArrayList<BasicComponentsInfo> infos) {
        mInfos = infos;
    }

    public void setListener(OnItemClickListener<BasicComponentsInfo> mListener) {
        this.mListener = mListener;
    }

    @NonNull
    @Override
    public VH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new VH(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_component, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull VH holder, int position) {
        holder.title.setText(mInfos.get(position).title);
        holder.desc.setText(mInfos.get(position).desc);
        holder.itemView.setOnClickListener(v -> {
            if (mListener != null) {
                mListener.onItemClick(mInfos.get(holder.getAdapterPosition()));
            }
        });
    }

    @Override
    public int getItemCount() {
        return mInfos.size();
    }

    public static class VH extends RecyclerView.ViewHolder {

        public TextView title;
        public TextView desc;

        public VH(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.tv_title);
            desc = itemView.findViewById(R.id.tv_desc);
        }
    }
}
