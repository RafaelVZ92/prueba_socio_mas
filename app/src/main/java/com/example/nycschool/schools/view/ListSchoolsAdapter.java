package com.example.nycschool.schools.view;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.nycschool.R;
import com.example.nycschool.schools.model.SchoolsData;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ListSchoolsAdapter extends RecyclerView.Adapter<ListSchoolsAdapter.ListItemViewHolder>{
    public static final String TAG = ListSchoolsAdapter.class.getSimpleName();
    private List<SchoolsData> list;
    private ListItemViewHolder.OnDetailListener mDetailListener;

    public ListSchoolsAdapter(List<SchoolsData> list, ListItemViewHolder.OnDetailListener mDetailListener) {
        this.list = list;
        this.mDetailListener = mDetailListener;
    }

   /* public ListSchoolsAdapter(List<SchoolsData> list) {
        this.list = list;
    }*/

    @NonNull
    @Override
    public ListItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.hschool_item, parent, false);
        return new ListItemViewHolder(itemView, mDetailListener);
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

    public static class ListItemViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

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

        OnDetailListener onDetailListener;

        public ListItemViewHolder(@NonNull View itemView, OnDetailListener detailListener) {
            super(itemView);
            this.onDetailListener = detailListener;
            ButterKnife.bind(this, itemView);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            onDetailListener.onClickListener(getAdapterPosition());
        }

        public interface OnDetailListener{
            void onClickListener(int position);
        }

    }
}