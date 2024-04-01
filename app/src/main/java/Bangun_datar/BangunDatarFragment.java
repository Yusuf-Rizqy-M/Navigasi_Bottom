package Bangun_datar;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.navigasi_bottom.BangunModel;
import com.example.navigasi_bottom.MainActivity;
import com.example.navigasi_bottom.R;

import java.util.ArrayList;

public class BangunDatarFragment extends Fragment implements BangunDatarAdapter.RecyclerViewClickListener {
    ArrayList<BangunModel> modelbangundatar = new ArrayList<>();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootview = inflater.inflate(R.layout.fragment_bangun_datar, container, false);
        RecyclerView rvBangunDatar = rootview.findViewById(R.id.rvBangunDatar);

        modelbangundatar.add(new BangunModel("Persegi", R.drawable.persegi));
        modelbangundatar.add(new BangunModel("Persegi Panjang", R.drawable.persegipanjang));
        modelbangundatar.add(new BangunModel("Segitiga", R.drawable.segitiga));
        modelbangundatar.add(new BangunModel("Lingkaran", R.drawable.lingkaran));

        rvBangunDatar.setLayoutManager(new LinearLayoutManager(getActivity()));
        BangunDatarAdapter adapter = new BangunDatarAdapter(getContext(), modelbangundatar, this);
        rvBangunDatar.setAdapter(adapter);

        return rootview;
    }

    @Override
    public void onClick(View view, int position) {
        String selectedBangun = modelbangundatar.get(position).getName();

        Intent intent;
        switch (selectedBangun) {
            case "Persegi":
                intent = new Intent(getActivity(), Persegi.class);
                break;
            case "Persegi Panjang":
                intent = new Intent(getActivity(), PersegiPanjang.class);
                break;
            case "Segitiga":
                intent = new Intent(getActivity(), Segitiga.class);
                break;
            case "Lingkaran":
                intent = new Intent(getActivity(), Lingkaran.class);
                break;
            default:
                intent = new Intent(getActivity(), MainActivity.class);
                break;
        }
        startActivity(intent);
    }
}