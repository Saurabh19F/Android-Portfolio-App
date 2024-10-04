package com.example.portfolioapp.team;

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
public class TeamFragment extends Fragment {


    RecyclerView RvTeam;
    TeamAdapter adapter;
    List<TeamItem> mdata;

    public TeamFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_team, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        RvTeam = view.findViewById(R.id.rv_team);



        // create list of team items

        TeamItem item1 = new TeamItem("Tanish Tyagi\n" + "Frontend Developer & UI/UX Specialist",("anish is our go-to person for frontend development, with a sharp eye for design and a passion for crafting user-friendly interfaces. His understanding of modern design principles and responsive web design ensures that our applications are visually compelling and accessible across all platforms. Tanish’s creativity shines in every project, delivering elegant solutions that improve user experience."),R.drawable.user);
        TeamItem item2 = new TeamItem("Sourabh Sinha\n" + "Backend Developer & Database Architect",("Sourabh’s expertise lies in backend development, where he works tirelessly to build secure, scalable, and efficient server-side solutions. He ensures that our databases are structured efficiently and that our APIs are fast and reliable. Sourabh’s logical thinking and problem-solving skills allow us to create robust systems that handle complex processes with ease."), R.drawable.uservoyager);
        TeamItem item3 = new TeamItem("Shivangi Srivastav\n" + "Quality Assurance & Project Manager",("Shivangi brings a balance of organizational skills and attention to detail to the team. As our project manager, she oversees project timelines, ensures smooth coordination between team members, and keeps the project on track. In her QA role, she is meticulous in testing to ensure that our solutions are bug-free and perform flawlessly, adding an extra layer of quality to our work."),R.drawable.shivi);
        TeamItem item = new TeamItem("Saurabh Kumar\n" + "Full Stack Developer & Team Lead",("As the team lead and full stack developer, I bridge the gap between frontend and backend development, ensuring that the team’s efforts align and integrate seamlessly. My role is to guide the team’s vision, ensure that both the client-side and server-side development are cohesive, and tackle any complex coding challenges. I take pride in fostering collaboration, solving problems creatively, and driving the team toward success."),R.drawable.userspace);

        mdata = new ArrayList<>();

        mdata.add(item1);
        mdata.add(item2);
        mdata.add(item3);
        mdata.add(item);

        // setup adapter and recyclerview

        RvTeam.setLayoutManager(new LinearLayoutManager(getContext()));
        adapter = new TeamAdapter(mdata);
        RvTeam.setAdapter(adapter);


    }
}