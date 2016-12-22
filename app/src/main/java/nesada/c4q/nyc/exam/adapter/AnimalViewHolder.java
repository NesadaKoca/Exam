package nesada.c4q.nyc.exam.adapter;

import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import nesada.c4q.nyc.exam.R;
import nesada.c4q.nyc.exam.backend.Animal;


public class AnimalViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
    private final View mRoot;
    private final Button mName;
    private final TextView mTextColor;
    private final TextView mBackground;
    View mLayoutId;

    public AnimalViewHolder(ViewGroup parent) {
        super(inflateView(parent));
        mRoot = itemView;
        mName = (Button) mRoot.findViewById(R.id.name);
        mTextColor = (TextView) mRoot.findViewById(R.id.textColor);
        mBackground = (TextView) mRoot.findViewById(R.id.bacground);

        mLayoutId = itemView.findViewById(R.id.LayoutId);

    }

    private static View inflateView(ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        return inflater.inflate(R.layout.animal_list_item, parent, false);
    }

    public void bind(Animal animal) {
        mName.setText(animal.getName());
        mTextColor.setText(animal.getBackground());
        mBackground.setText(animal.getTextColor());
    }


    @Override
    public void onClick(View view) {
        mLayoutId.setBackgroundColor(Color.parseColor("#FF4081"));


    }

}




