package com.example.nycschool.schools.view;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.nycschool.R;
import com.example.nycschool.schools.model.SchoolsData;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ListSchoolsAdapter extends RecyclerView.Adapter<ListSchoolsAdapter.ListItemViewHolder>{
    private List<SchoolsData> list;

    public ListSchoolsAdapter(List<SchoolsData> list) {
        this.list = list;
    }

    @NonNull
    @Override
    public ListItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.hschool_item, parent, false);
        return new ListItemViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ListItemViewHolder holder, int position) {
        holder.id.setText(list.get(position).getDbn());
        holder.title.setText(list.get(position).getSchoolName());
        holder.direction.setText(list.get(position).getLocation());
        holder.website.setText(list.get(position).getWebsite());
        holder.email.setText(list.get(position).getSchoolEmail());
    }

    @Override
    public int getItemCount() {
        return this.list.size();
    }

    public static class ListItemViewHolder extends RecyclerView.ViewHolder{

        @BindView(R.id.text_view_id)
        public TextView id;

        @BindView(R.id.text_view_title)
        public TextView title;

        @BindView(R.id.text_view_direction)
        public TextView direction;

        @BindView(R.id.text_view_website)
        public TextView website;

        @BindView(R.id.text_view_email)
        public TextView email;

        public ListItemViewHolder(@NonNull View itemView) {
            super(itemView);

            ButterKnife.bind(this, itemView);
        }
    }
}