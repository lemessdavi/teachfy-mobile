package com.example.teachfy.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.teachfy.databinding.DeckItemBinding;
import com.example.teachfy.models.Deck;

import java.util.ArrayList;
import java.util.List;

public class DeckAdpter extends RecyclerView.Adapter<DeckAdpter.ViewHolder> {

    private List<Deck> mData;
    private LayoutInflater mInflater;
    private ItemClickListener mClickListener;
    private Context context;

    public DeckAdpter(Context context, List<Deck> data) {
        this.mInflater = LayoutInflater.from(context);
        this.mData = data;

        if(data == null)
            this.mData = new ArrayList<>();
        this.context = context;
    }

    @NonNull
    @Override
    public DeckAdpter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        DeckItemBinding itemLista = DeckItemBinding.inflate(LayoutInflater.from(context), parent, false);
        return new ViewHolder(itemLista);
    }

    @Override
    public void onBindViewHolder(@NonNull DeckAdpter.ViewHolder holder, int position) {
        holder.textViewPorcentagemAcerto.setText(mData.get(position).getPorcentagemAcerto());
        holder.textViewQntdCrds.setText(mData.get(position).getQntdCards());
        holder.textViewTituloDeck.setText(mData.get(position).getName());
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView textViewPorcentagemAcerto;
        TextView textViewTituloDeck;
        TextView textViewQntdCrds;

        ViewHolder(DeckItemBinding binding) {
            super(binding.getRoot());
            textViewPorcentagemAcerto = binding.textViewPorcentagemAcerto;
            textViewQntdCrds = binding.textViewQntdCrds;
            textViewTituloDeck = binding.textViewTituloDeck;
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            int position = getAdapterPosition();
            if (position != RecyclerView.NO_POSITION) {
                Deck clickedDeck = getItem(position);
                int deckId = clickedDeck.getId();
                mClickListener.onItemClick(view, position, deckId);
            }
        }
    }

    // convenience method for getting data at click position
    Deck getItem(int id) {
        return mData.get(id);
    }

    // allows clicks events to be caught
    public void setClickListener(ItemClickListener itemClickListener) {
        this.mClickListener = itemClickListener;
    }

    // parent activity will implement this method to respond to click events
    public interface ItemClickListener {
        void onItemClick(View view, int position, int deck_id);
    }

}
