package com.example.portfolioapp.home;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.method.LinkMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.portfolioapp.R;

public class HomeFragment extends Fragment {

    TextView tvClickableLink;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        // Use the inflated view to find the TextView
        tvClickableLink = view.findViewById(R.id.textView9); // Correct way to access the TextView
        tvClickableLink.setMovementMethod(LinkMovementMethod.getInstance()); // For clickable links (optional if just a listener is used)

        // Set up a click listener to open the URL
        tvClickableLink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Open the URL in a web browser
                Intent browserIntent = new Intent(Intent.ACTION_VIEW);
                //startActivity(browserIntent);
            }
        });

        return view; // Return the inflated layout
    }
}
