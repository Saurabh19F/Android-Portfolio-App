package com.example.portfolioapp.portfolio;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.portfolioapp.R;
import com.bumptech.glide.Glide;

import java.util.List;

public class PortfolioAdapter extends RecyclerView.Adapter<PortfolioAdapter.PortfolioViewHolder> {
    private final List<PortfolioItem> portfolioItems;
    private final PortfolioCallback callback;
    private final Context context;

    public PortfolioAdapter(List<PortfolioItem> portfolioItems, PortfolioCallback callback) {
        this.portfolioItems = portfolioItems;
        this.callback = callback;
        this.context = callback.getContext();
    }

    @NonNull
    @Override
    public PortfolioViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_portfolio, parent, false);
        return new PortfolioViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PortfolioViewHolder holder, int position) {
        PortfolioItem item = portfolioItems.get(position);
        holder.titleTextView.setText(item.getTitle());
        holder.imaport.setImageResource(item.getImage());



        // Set the description with clickable links
        String description = item.getDescription();
        SpannableString spannableString = new SpannableString(description);

        // Create clickable spans for URLs
        ClickableSpan liveDemoSpan = new ClickableSpan() {
            @Override
            public void onClick(@NonNull View widget) {
                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(item.getLiveDemoUrl()));
                context.startActivity(browserIntent);
            }
        };

        ClickableSpan githubSpan = new ClickableSpan() {
            @Override
            public void onClick(@NonNull View widget) {
                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(item.getGithubUrl()));
                context.startActivity(browserIntent);
            }
        };

        // Assuming your description mentions "live demo" and "GitHub"
        int startLiveDemo = description.indexOf("live demo");
        int endLiveDemo = startLiveDemo + "live demo".length();
        int startGithub = description.indexOf("GitHub");
        int endGithub = startGithub + "GitHub".length();

        spannableString.setSpan(liveDemoSpan, startLiveDemo, endLiveDemo, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        spannableString.setSpan(githubSpan, startGithub, endGithub, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

        holder.descriptionTextView.setText(spannableString);
        holder.descriptionTextView.setMovementMethod(LinkMovementMethod.getInstance()); // Make links clickable
    }

    @Override
    public int getItemCount() {
        return portfolioItems.size();
    }

    public class PortfolioViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView titleTextView;
        TextView descriptionTextView;
        ImageView imaport;

        public PortfolioViewHolder(@NonNull View itemView) {
            super(itemView);
            titleTextView = itemView.findViewById(R.id.tv_title);
            descriptionTextView = itemView.findViewById(R.id.tv_description);
            imaport = itemView.findViewById(R.id.iv_image);

            itemView.setOnClickListener(this);
        }


        @Override
        public void onClick(View v) {

            callback.onPortfolioItemClick(getAdapterPosition());
        }
    }
}
