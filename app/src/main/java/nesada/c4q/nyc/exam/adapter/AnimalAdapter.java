package nesada.c4q.nyc.exam.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import java.util.List;

import nesada.c4q.nyc.exam.backend.Animal;
import nesada.c4q.nyc.exam.backend.AnimalResponse;


public class AnimalAdapter extends RecyclerView.Adapter<AnimalViewHolder> {
    private final List<Animal> mData;

    public AnimalAdapter(AnimalResponse data) {
        mData = data.getAnimals();
    }

    @Override
    public AnimalViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new AnimalViewHolder(parent);
    }

    @Override
    public void onBindViewHolder(AnimalViewHolder holder, int position) {
        holder.bind(mData.get(position));
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }
}
