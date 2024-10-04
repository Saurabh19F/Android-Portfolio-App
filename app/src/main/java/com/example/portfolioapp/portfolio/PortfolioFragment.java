package com.example.portfolioapp.portfolio;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.portfolioapp.R;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.zip.Inflater;

/**
 * A simple {@link Fragment} subclass.
 */
public class PortfolioFragment extends Fragment implements PortfolioCallback {

    List<PortfolioItem> mdata;
    RecyclerView rv_portfolio;
    PortfolioAdapter portfolioAdapter;

    public PortfolioFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
       View v= container.findViewById(R.id.rv_portfolio);
        return inflater.inflate(R.layout.fragment_portfolio, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        rv_portfolio = view.findViewById(R.id.rv_portfolio);
        // create a list of portfolio items
        mdata = new ArrayList<>();

        // Adding portfolio items with live demo and GitHub URLs
        mdata.add(new PortfolioItem(R.drawable.project1, "Restaurant Menu Web App:","The Restaurant Menu Web App is an elegant and interactive digital menu designed for restaurants, offering a seamless browsing experience for customers. Built using HTML, CSS, and JavaScript, the app presents food and beverage options, including various dishes, brandy beverages, and other items, organized in an intuitive and visually appealing layout. The design features a classic and timeless color scheme, enhancing the user experience and reflecting the restaurant’s refined ambiance. Key functionalities include the ability to filter menu items by category, detailed item descriptions, and pricing. One of the challenges was ensuring a responsive design that works flawlessly across devices, which I achieved using flexible grid layouts and media queries. You can explore the project further through the live demo or visit the GitHub repository for the source code.", "https://github.com/Saurabh19F/PRODIGY_WD_01.git", "https://saurabh19f.github.io/PRODIGY_WD_01/"));

        mdata.add(new PortfolioItem(R.drawable.project2, "Portfolio Web App:","The Portfolio Web App is a personal platform designed to showcase my skills, projects, and professional experience as a full-stack web developer. Developed using HTML, CSS, JavaScript, and other modern web technologies, this app highlights my journey, technical expertise, and creative abilities. It features a clean, responsive design, offering smooth navigation across sections such as About Me, Skills, Projects, and Contact. Each project is presented with detailed descriptions, technologies used, and links to live demos or GitHub repositories. The design incorporates animations and interactivity to make the user experience engaging and visually appealing. Building this portfolio allowed me to integrate both front-end and back-end development skills, with an emphasis on responsive design and user-friendly interfaces. You can explore the live version here or check out the code on GitHub.","https://github.com/Saurabh19F/PRODIGY_WD_04.git", "https://saurabh19f.github.io/PRODIGY_WD_04/"));

        mdata.add(new PortfolioItem(R.drawable.project3, "Stopwatch Web App:","The Stopwatch Web App is a simple yet functional tool designed to track time accurately, featuring start, stop, reset, and lap functionalities. Built using HTML, CSS, and JavaScript, the stopwatch offers a minimalistic and intuitive user interface. The app allows users to record multiple lap times, with each lap displayed dynamically on the screen in real-time. One of the technical challenges was ensuring precise time tracking and synchronization with the UI, which I handled by utilizing JavaScript's setInterval() method to update the timer every millisecond. The app is fully responsive, making it accessible across devices, and is designed to be lightweight for fast performance. Explore the live demo or check out the GitHub repository for the source code.","https://github.com/Saurabh19F/PRODIGY_WD_02.git", "https://saurabh19f.github.io/PRODIGY_WD_02/"));

        mdata.add(new PortfolioItem(R.drawable.project4, "Tic-Tac-Toe Web App:","This project is a web-based Tic-Tac-Toe game designed for two players. The game allows users to take turns placing their symbols (X or O) on a 3x3 grid, with automatic detection of a win, loss, or draw. The app includes a reset function to easily restart the game after each round. I built the project using HTML, CSS, and JavaScript, focusing on providing a smooth user experience with simple animations and real-time feedback. The biggest challenge was implementing efficient win-condition logic, which I solved by utilizing matrix-based comparisons for all possible outcomes. You can check out the live demo or explore the GitHub repository for more details.","https://github.com/Saurabh19F/PRODIGY_WD_03.git", "https://saurabh19f.github.io/PRODIGY_WD_03/"));

        mdata.add(new PortfolioItem(R.drawable.project5, "Mini Sales CRM Web App:","The Mini Sales CRM Web App is a lightweight, efficient system built to manage sales leads and streamline the sales process. Developed using HTML, CSS, JavaScript, and a Node.js/Flask backend, the app allows users to track leads, update lead statuses (e.g., 'Sold' or 'Not Sold'), and keep a detailed record of client interactions. The app features a clean user interface with functionality for adding new leads, viewing and editing lead information, and filtering based on status. A key challenge was integrating seamless communication between the front-end and back-end, which I achieved through RESTful API calls for real-time updates. The application is designed to improve sales productivity and is fully responsive across devices. You can view the live demo or explore the GitHub repository.", "https://github.com/Saurabh19F/Mini-Sales-CRM.git", ""));

        mdata.add(new PortfolioItem(R.drawable.project6, "Weather App with OpenWeather API:","The Weather App is a responsive web application that provides real-time weather updates for any location, using the OpenWeather API. Built with HTML, CSS, and JavaScript, the app allows users to search by city or use their current location to view weather details such as temperature, humidity, wind speed, and weather conditions. Additionally, it offers a 5-day weather forecast, allowing users to plan ahead based on upcoming conditions. A key feature of the app is the ability to toggle between Celsius and Fahrenheit for temperature display. One of the technical challenges was efficiently fetching and displaying weather data asynchronously, which was solved by implementing API calls and handling responses dynamically. The app is designed with a clean, intuitive UI and adapts to various screen sizes for seamless use across devices. Check out the live demo or visit the GitHub repository for the code.","https://github.com/Saurabh19F/PRODIGY_WD_05.git", "https://saurabh19f.github.io/PRODIGY_WD_05/"));



        PortfolioAdapter portfolioAdapter = new PortfolioAdapter(mdata, this);
        rv_portfolio.setLayoutManager(new GridLayoutManager(getActivity(), 3));
        rv_portfolio.setAdapter(portfolioAdapter);
    }

    @Override
    public void onPortfolioItemClick(int pos) {
        // Handle click listener event when portfolio item clicked


        PortfolioFragmentDetails portfolioFragmentDetails = new PortfolioFragmentDetails();



        Bundle bundle = new Bundle();
        bundle.putSerializable("object", mdata.get(pos));
        portfolioFragmentDetails.setArguments(bundle);

        portfolioFragmentDetails.show(Objects.requireNonNull(getActivity()).getSupportFragmentManager(), "tagname");
    }
}
