package ubb.barcoaie.lab4_ma.Activities.Update;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import ubb.barcoaie.lab4_ma.Model.Vegetable;
import ubb.barcoaie.lab4_ma.R;

public class VegetableViewHolderUpd extends RecyclerView.ViewHolder {
    private final TextView vegetableItemView;

    public VegetableViewHolderUpd(View itemView) {
        super(itemView);
        vegetableItemView = itemView.findViewById(R.id.textView);
    }

    public void bind(Vegetable vegetable) {
        vegetableItemView.setText(vegetable.toString());
    }

    static VegetableViewHolderUpd create(ViewGroup parent) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.recyclerview_item, parent, false);
        return new VegetableViewHolderUpd(view);
    }
}
