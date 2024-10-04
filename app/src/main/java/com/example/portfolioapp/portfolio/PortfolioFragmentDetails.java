package com.example.portfolioapp.portfolio;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.portfolioapp.R;
import com.bumptech.glide.Glide;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;

import java.util.Objects;

public class PortfolioFragmentDetails extends BottomSheetDialogFragment {


    private ImageView imgPortfolio;
    private TextView title,description;



    public PortfolioFragmentDetails() {
        // Required empty public constructor
    }
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        imgPortfolio = view.findViewById(R.id.portfolio_details_img);
        title = view.findViewById(R.id.portfolio_details_title);
        description = view.findViewById(R.id.portfolio_details_desc);
        TextView githubLink = view.findViewById(R.id.portfolio_details_github_link); // Get the GitHub link TextView
        TextView liveDemoLink = view.findViewById(R.id.portfolio_details_live_demo_link); // Get the Live Demo link TextView

        Bundle bundle = getArguments();
        assert bundle != null;
        PortfolioItem item = (PortfolioItem) bundle.getSerializable("object");

        assert item != null;
        loadPortfolioData(item);

        // Set the GitHub link text and click listener
        githubLink.setText(item.getGithubLink());
        githubLink.setOnClickListener(v -> {
            Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(item.getGithubLink()));
            startActivity(browserIntent); // Open the GitHub link in a browser
        });

        // Set the Live Demo link text and click listener
        liveDemoLink.setText(item.getLiveDemoLink());
        liveDemoLink.setOnClickListener(v -> {
            Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(item.getLiveDemoLink()));
            startActivity(browserIntent); // Open the Live Demo link in a browser
        });
    }



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_portfolio_details, container, false);
    }




    void loadPortfolioData(PortfolioItem item) {

        Glide.with(Objects.requireNonNull(getContext())).load(item.getImage()).into(imgPortfolio);
        // bind title and description ...
        title.setText(item.getTitle());
        description.setText(item.getDescription());

    }


}