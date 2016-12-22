package nesada.c4q.nyc.exam;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

import nesada.c4q.nyc.exam.adapter.AnimalAdapter;
import nesada.c4q.nyc.exam.backend.AnimalApi;
import nesada.c4q.nyc.exam.backend.AnimalResponse;
import nesada.c4q.nyc.exam.helpers.Consumer;


public class MainFragment extends Fragment {
    private RequestQueue mRequestQueue;
    private RecyclerView mRecyclerView;
    private View mRoot;

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        mRequestQueue = Volley.newRequestQueue(getContext());
    }

    @Override
    public void onStart(){
        super.onStart();
        Consumer<AnimalResponse> listener = buildDataReceiver();
        mRequestQueue.add(AnimalApi.buildDataRequest(listener));
    }

    public Consumer<AnimalResponse> buildDataReceiver(){
        return new Consumer<AnimalResponse>() {
            @Override
            public void accept(AnimalResponse data) {
                mRecyclerView.setAdapter(new AnimalAdapter(data));
                mRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
            }
        };
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup parent, Bundle savedInstanceState){
        mRoot = inflater.inflate(R.layout.fragment_main, parent, false);
        mRecyclerView = (RecyclerView) mRoot.findViewById(R.id.content);
        return mRoot;


    }


}
