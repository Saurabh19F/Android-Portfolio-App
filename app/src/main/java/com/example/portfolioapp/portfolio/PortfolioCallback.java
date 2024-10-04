package com.example.portfolioapp.portfolio;

import android.content.Context;

public interface PortfolioCallback {
    void onPortfolioItemClick(int pos);
    Context getContext();
}

