package ubb.barcoaie.lab4_ma.Activities.Read;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import ubb.barcoaie.lab4_ma.Model.Vegetable;
import ubb.barcoaie.lab4_ma.R;

public class VegetableViewHolder extends RecyclerView.ViewHolder {
    private final TextView vegetableItemView;

    public VegetableViewHolder(View itemView) {
        super(itemView);
        vegetableItemView = itemView.findViewById(R.id.textView);
    }

    public void bind(Vegetable vegetable) {
        vegetableItemView.setText(vegetable.toString());
    }

    static VegetableViewHolder create(ViewGroup parent) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.recyclerview_item, parent, false);
        return new VegetableViewHolder(view);
    }
}
