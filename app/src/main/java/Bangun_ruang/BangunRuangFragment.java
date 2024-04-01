package Bangun_ruang;

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
import com.example.navigasi_bottom.BangunModel;
import com.example.navigasi_bottom.MainActivity;

import java.util.ArrayList;

public class BangunRuangFragment extends Fragment implements BangunRuangAdapter.RecyclerViewClickListener {
    ArrayList<BangunModel> modelBangunRuang = new ArrayList<>();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootview = inflater.inflate(R.layout.fragment_bangun_ruang,container,false);
        RecyclerView rvBangunRuang = rootview.findViewById(R.id.rvBangunRuang);

        modelBangunRuang.add(new BangunModel("Kubus", R.drawable.kubus));
        modelBangunRuang.add(new BangunModel("Bola", R.drawable.bola));
        modelBangunRuang.add(new BangunModel("Balok", R.drawable.balok));
        modelBangunRuang.add(new BangunModel("Tabung", R.drawable.tabung));

        rvBangunRuang.setLayoutManager(new LinearLayoutManager(getActivity()));
        BangunRuangAdapter adapter = new BangunRuangAdapter(getContext(), modelBangunRuang, this);
        rvBangunRuang.setAdapter(adapter);

        return rootview;
    }
    public void onClick(View view, int position) {
        String selectedBangunRuang = modelBangunRuang.get(position).getName();

        Intent intent;
        switch (selectedBangunRuang) {
            case "Kubus":
                intent = new Intent(getActivity(), Kubus.class);
                break;
            case "Balok":
                intent = new Intent(getActivity(), Balok.class);
                break;
            case "Bola":
                intent = new Intent(getActivity(), Bola.class);
                break;
            case "Tabung":
                intent = new Intent(getActivity(), Tabung.class);
                break;
            default:
                intent = new Intent(getActivity(), MainActivity.class);
                break;
        }
        startActivity(intent);
    }
}