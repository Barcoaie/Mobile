package ubb.barcoaie.lab5_ma.activities.Delete;

import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;

import ubb.barcoaie.lab5_ma.model.Vegetable;

public class VegetableListAdapterDel  extends ListAdapter<Vegetable, VegetableViewHolderDel> {
    protected VegetableListAdapterDel(@NonNull DiffUtil.ItemCallback<Vegetable> diffCallback) {
        super(diffCallback);
    }

    @NonNull
    @Override
    public VegetableViewHolderDel onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return VegetableViewHolderDel.create(parent);
    }

    @Override
    public void onBindViewHolder(@NonNull VegetableViewHolderDel holder, int position) {
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
