package com.example.portfolioapp.cv;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.portfolioapp.R;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class CVFragment extends Fragment {

    RecyclerView RvCv;
    CVAdapter adapter ;
    List<CVItem> items;

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        RvCv = view.findViewById(R.id.recyclerview_cv);

        // create a list of cv items
        items = new ArrayList<>();
        items.add(new CVItem("Web Development Intern\n" +
                "Prodigy Infotech – (June 2024 – August 2024)","Developed and optimized dynamic, responsive web applications using JavaScript, Node.js, Express, and MongoDB.\n"
                +    "Collaborated with cross-functional teams to implement user-focused features and APIs. \n"
                +    "Assisted in building and testing RESTful APIs for client-side integration.\n"
                +    "Gained experience in project management, version control (Git), and agile development practices.\n"
                +    "Received a Letter of Recommendation for outstanding performance.\n"));

        items.add(new CVItem("Full-Stack Development Trainee\n" +
                "MyCaptain – (2023)","Completed an intensive full-stack development program, gaining hands-on experience with technologies such as HTML, CSS, JavaScript, Node.js, Express, and MongoDB.\n"
                +    "Built and deployed full-stack web applications as part of course projects, implementing both front-end interfaces and back-end APIs.\n"
                +    "Learned best practices in software development, debugging, and version control through Git and GitHub.\n"
                +    "Collaborated with peers on group projects to simulate real-world development environments and workflows.\n"));

        items.add(new CVItem("Freelance Full-Stack Developer\n" +
                "Self-employed – (2023 – Present)","Designed and developed customized web applications and solutions for clients using front-end and back-end technologies.\n"
                +    "Projects included a Sales CRM system, Task Manager app, and a RESTful Bookstore API.\n"
                +    "Emphasized clean, maintainable code and agile development techniques.\n"
                +    "Worked closely with clients to gather requirements, provide updates, and ensure timely delivery of projects.\n"));

        adapter = new CVAdapter(items);

        RvCv.setLayoutManager(new LinearLayoutManager(getContext()));
        RvCv.setAdapter(adapter);



    }

    public CVFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_cv, container, false);
    }

}