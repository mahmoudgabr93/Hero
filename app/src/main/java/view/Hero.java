package view;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.example.gabrm.retrofitjsonexample.R;

import java.util.ArrayList;
import java.util.List;

import model.MyAdapter;
import presenter.MainContentPresenter;

public class Hero extends AppCompatActivity implements MainContentView {

    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    MainContentPresenter mainContentPresenter;
    List<model.Hero> heroes;
    private ProgressDialog progressDialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mainContentPresenter=new MainContentPresenter(this);
        recyclerView=findViewById(R.id.recyclerview);
        recyclerView.setHasFixedSize(false);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        heroes=new ArrayList<>();
        loadRecyclerView();
    }

    private void loadRecyclerView() {
        progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Loading...");
        progressDialog.show();
        mainContentPresenter.LoadMainContent();
    }

    @Override
    public void OnResponseSuccess(List<model.Hero> heroesList) {
        progressDialog.cancel();
        heroes=new ArrayList<>();
        heroes.addAll(heroesList);
        adapter=new MyAdapter(heroes, Hero.this);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void OnResponseFails() {
        progressDialog.cancel();
        Toast.makeText(getApplicationContext(),"error",Toast.LENGTH_SHORT).show();
    }
}
