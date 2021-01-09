package ubb.barcoaie.lab5_ma.activities.Delete;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.recyclerview.widget.RecyclerView;

import ubb.barcoaie.lab5_ma.model.Vegetable;
import ubb.barcoaie.lab5_ma.R;
import ubb.barcoaie.lab5_ma.repository.VegetableDatabase;

public class VegetableViewHolderDel extends RecyclerView.ViewHolder{
    private final TextView vegetableItemView;


    public VegetableViewHolderDel(View itemView) {
        super(itemView);
        vegetableItemView = itemView.findViewById(R.id.textView);
    }

    public void bind(Vegetable vegetable) {
        vegetableItemView.setText(vegetable.toString());
        vegetableItemView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                AlertDialog alertDialog = new AlertDialog.Builder(v.getContext()).create();
                alertDialog.setTitle("Delete vegetable");
                alertDialog.setMessage("Are you sure you want this?");
                alertDialog.setButton(AlertDialog.BUTTON_POSITIVE, "Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        VegetableDatabase.databaseWriteExecutor.execute(() -> {
                            VegetableDatabase.getDatabase(v.getContext()).vegetableDao().delete(vegetable.getId());
                        });
                        Toast.makeText(v.getContext(), "On long clicked and yes chosen", Toast.LENGTH_SHORT).show();
                        dialog.dismiss();
                    }
                });
                alertDialog.setButton(AlertDialog.BUTTON_NEGATIVE, "No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(v.getContext(), "On long clicked and no chosen", Toast.LENGTH_SHORT).show();
                        dialog.dismiss();
                    }
                });
                alertDialog.show();
                return true;
            }
        });
    }

    static VegetableViewHolderDel create(ViewGroup parent) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.recyclerview_item, parent, false);
        return new VegetableViewHolderDel(view);
    }
}
