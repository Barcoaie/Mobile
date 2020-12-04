package ubb.barcoaie.lab4_ma.Activities.Read;

import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;

import ubb.barcoaie.lab4_ma.Model.Vegetable;

public class VegetableListAdapter extends ListAdapter<Vegetable, VegetableViewHolder> {
    protected VegetableListAdapter(@NonNull DiffUtil.ItemCallback<Vegetable> diffCallback) {
        super(diffCallback);
    }

    @NonNull
    @Override
    public VegetableViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return VegetableViewHolder.create(parent);
    }

    @Override
    public void onBindViewHolder(@NonNull VegetableViewHolder holder, int position) {
        Vegetable current = getItem(position);
        holder.bind(current);
    }

    static class VegetableDiff extends DiffUtil.ItemCallback<Vegetable> {

        @Override
        public boolean areItemsTheSame(@NonNull Vegetable oldItem, @NonNull Vegetable newItem) {
            return oldItem == newItem;
        }

        @Override
        public boolean areContentsTheSame(@NonNull Vegetable oldItem, @NonNull Vegetable newItem) {
            return oldItem.getName().equals(newItem.getName());
        }
    }
}
