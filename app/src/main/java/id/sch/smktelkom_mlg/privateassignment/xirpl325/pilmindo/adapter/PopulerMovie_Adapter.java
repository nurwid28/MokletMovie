package id.sch.smktelkom_mlg.privateassignment.xirpl325.pilmindo.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

import id.sch.smktelkom_mlg.privateassignment.xirpl325.pilmindo.NowPlayingFragment;
import id.sch.smktelkom_mlg.privateassignment.xirpl325.pilmindo.PopulerFragment;
import id.sch.smktelkom_mlg.privateassignment.xirpl325.pilmindo.R;
import id.sch.smktelkom_mlg.privateassignment.xirpl325.pilmindo.model.Results;

/**
 * Created by Widya on 5/14/2017.
 */

public class PopulerMovie_Adapter extends RecyclerView.Adapter<PopulerMovie_Adapter.ViewHolder> {

    public String url = "https://image.tmdb.org/t/p/w500";
    public String image;
    ArrayList<Results> populerList;
    PopulerFragment populerFragment;
    Context context;
    private int lastposition = -1;

    public PopulerMovie_Adapter(PopulerFragment populerFragment, ArrayList<Results> populer_List, Context context) {
        this.populerList = populer_List;
        this.populerFragment = populerFragment;
        this.context = context;

    }

    @Override
    public PopulerMovie_Adapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list2, parent, false);
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Results results = populerList.get(position);
        holder.tvJudul.setText(results.title);
        holder.tvDeskripsi.setText(results.overview);
        image = url + results.backdrop_path;
        Glide.with(context).load(image)
                .crossFade()
                .centerCrop()
                .placeholder(R.mipmap.ic_launcher_round)
                .error(R.mipmap.ic_launcher)
                .into(holder.ivFoto);
    }

    @Override
    public int getItemCount() {
        if (populerList != null)
            return populerList.size();
        return 0;
    }


    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView ivFoto;
        TextView tvJudul;
        TextView tvDeskripsi;

        public ViewHolder(View itemView) {
            super(itemView);
            ivFoto = (ImageView) itemView.findViewById(R.id.imageViewPoster_populer);
            tvJudul = (TextView) itemView.findViewById(R.id.textViewJuduln_populer);
            tvDeskripsi = (TextView) itemView.findViewById(R.id.textViewDeskripsi_populer);
        }
    }
}

