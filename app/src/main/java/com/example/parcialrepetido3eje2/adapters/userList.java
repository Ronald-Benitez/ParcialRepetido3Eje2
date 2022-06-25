package com.example.parcialrepetido3eje2.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.parcialrepetido3eje2.R;
import com.example.parcialrepetido3eje2.models.User;

import java.util.ArrayList;

public class userList extends RecyclerView.Adapter<userList.ViewHolder> {
    ArrayList<User> users;

    public userList(ArrayList<User> users) {
        this.users = users;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_user, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.tvuserid.setText(users.get(position).getUserId());
        holder.tvbody.setText(users.get(position).getBody());
        holder.tvtitle.setText(users.get(position).getTitle());
        holder.tvid.setText(users.get(position).getId());

    }

    @Override
    public int getItemCount() {
        try {
            return users.size();
        } catch (Exception e) {
            return 0;
        }
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvuserid,tvid,tvtitle,tvbody;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvbody = itemView.findViewById(R.id.tvbody);
            tvtitle = itemView.findViewById(R.id.tvtitle);
            tvid = itemView.findViewById(R.id.tvid);
            tvuserid = itemView.findViewById(R.id.tvuserid);

        }
    }
}
