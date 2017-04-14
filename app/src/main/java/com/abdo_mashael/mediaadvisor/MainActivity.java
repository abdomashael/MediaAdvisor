package com.abdo_mashael.mediaadvisor;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.GridLayout;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        if (savedInstanceState != null) {

            //Get a ref to the Spinner
            Spinner envir = (Spinner) findViewById(R.id.environment);

            GridLayout layout1 = (GridLayout) findViewById(R.id.layout1);
            layout1.setVisibility(View.VISIBLE);

            stiSituation Situation = new stiSituation();
            Situation.situation();
            stiReponse Response = new stiReponse();
            Response.response();
            mediaSolution Solution = new mediaSolution(Situation.set, Response.set);
            Solution.setSolution();
        }
    }

    public void onClickFind(View view) {
        GridLayout layout1 = (GridLayout) findViewById(R.id.layout1);
        layout1.setVisibility(View.VISIBLE);


        stiSituation Situation = new stiSituation();
        Situation.situation();

        stiReponse Response = new stiReponse();
        Response.response();

        mediaSolution Solution = new mediaSolution(Situation.set, Response.set);
        Solution.setSolution();


    }

    private class stiSituation {
        //Get a ref to the Spinner
        Spinner envir = (Spinner) findViewById(R.id.environment);
        //Get the selected item in the Spinner
        String envirType = String.valueOf(envir.getSelectedItem());
        String set;
        int position;
        //Get a ref to the TextView
        TextView sit_solve = (TextView) findViewById(R.id.sit_solve);


        public String getSet() {
            return set;
        }

        public int getPosition() {
            return envir.getSelectedItemPosition();
        }

        private void situation() {
            //Rule 1
            if (envirType.equals("papers") || envirType.equals("manuals") || envirType.equals("documents") || envirType.equals("textbooks")) {
                set = "verbal";
                sit_solve.setText(set);
            }//Rule 2
            if (envirType.equals("pictures") || envirType.equals("illustrations") || envirType.equals("photographs") || envirType.equals("diagrams")) {
                set = "visual";
                sit_solve.setText(set);
            }
            //Rule 3
            if (envirType.equals("machines") || envirType.equals("buildings") || envirType.equals("tools")) {
                set = "physical object";
                sit_solve.setText(set);

            }
            //Rule 4
            if (envirType.equals("numbers") || envirType.equals("formulas") || envirType.equals("computer programs")) {
                set = "symbolic";
                sit_solve.setText(set);
            }
        }

    }

    private class stiReponse {
        //Get a ref to the Spinner
        Spinner job = (Spinner) findViewById(R.id.job);
        //Get the selected item in the Spinner
        String jobType = String.valueOf(job.getSelectedItem());
        String set;
        //Get a ref to the TextView
        TextView resp_solve = (TextView) findViewById(R.id.resp_solve);

        public String getSet() {
            return set;
        }

        private void response() {
            //Rule 5
            if (jobType.equals("lecturing") || jobType.equals("advising") || jobType.equals("counselling")) {
                set = "oral";
                resp_solve.setText(set);
            }
            //Rule 6
            if (jobType.equals("building") || jobType.equals("repairing") || jobType.equals("troubleshooting")) {
                set = "hands-on";
                resp_solve.setText(set);
            }
            //Rule 7
            if (jobType.equals("writing") || jobType.equals("typing") || jobType.equals("drawing")) {
                set = "documented";
                resp_solve.setText(set);
            }
            //Rule 8
            if (jobType.equals("evaluating") || jobType.equals("reasoning") || jobType.equals("investigating")) {
                set = "analytical";
                resp_solve.setText(set);
            }

        }

    }


    private class mediaSolution {
        //Get a ref to the Spinner
        Spinner feedback = (Spinner) findViewById(R.id.feedback);
        //Get the selected item in the Spinner
        String feedbackType = String.valueOf(feedback.getSelectedItem());
        //Get a ref to the TextView
        TextView solution = (TextView) findViewById(R.id.solution);
        String sit, resp, set;

        private mediaSolution(String sit, String resp) {
            this.sit = sit;
            this.resp = resp;
        }

        public String getSet() {
            return set;
        }


        private void setSolution() {
            //Rule 9
            if (sit.equals("physical object") && resp.equals("hands-on") && feedbackType.equals("Yes")) {
                set = "workshop";
                solution.setText(set);
            }
            //Rule 10
            else if (sit.equals("symbolic") && resp.equals("analytical") && feedbackType.equals("Yes")) {
                set = "lecture – tutorial";
                solution.setText(set);
            }
            //Rule 11
            else if (sit.equals("visual") && resp.equals("documented") && feedbackType.equals("No")) {
                set = "videocassette";
                solution.setText(set);
            }
            //Rule 12
            else if (sit.equals("visual") && resp.equals("oral") && feedbackType.equals("Yes")) {
                set = "lecture – tutorial";
                solution.setText(set);
            }
            //Rule 13
            else if (sit.equals("verbal") && resp.equals("analytical") && feedbackType.equals("Yes")) {
                set = "lecture – tutorial";
                solution.setText(set);
            }
            //Rule 14
            else if (sit.equals("verbal") && resp.equals("oral") && feedbackType.equals("Yes")) {
                set = "role-play exercises";
                solution.setText(set);
            } else {
                set = "No Available Media";
                solution.setText(set);
            }

        }
    }

}
