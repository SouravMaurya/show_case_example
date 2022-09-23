package com.sourav.showcaseexample;

import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import uk.co.deanwild.materialshowcaseview.MaterialShowcaseSequence;
import uk.co.deanwild.materialshowcaseview.MaterialShowcaseView;
import uk.co.deanwild.materialshowcaseview.ShowcaseConfig;

public class MainActivity extends AppCompatActivity {

    private static final String SHOWCASE_ID = "sequence example";

    private Button mButtonOne;
    private Button mButtonTwo;
    private Button mButtonThree;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mButtonOne = findViewById(R.id.btn_one);
        mButtonTwo = findViewById(R.id.btn_two);
        mButtonThree = findViewById(R.id.btn_three);

        presentShowcaseSequence();

    }


    private void presentShowcaseSequence() {

        ShowcaseConfig config = new ShowcaseConfig();
        config.setDelay(200); // 200 milli second between each showcase view

        MaterialShowcaseSequence sequence = new MaterialShowcaseSequence(this, SHOWCASE_ID);

        sequence.setConfig(config);

        sequence.addSequenceItem(
                new MaterialShowcaseView.Builder(this)
                        .setDismissOnTouch(true)
                        .setDismissOnTargetTouch(true)
                        .setTarget(mButtonOne)
                        .setSkipText("SKIP")
                        .setDismissText("GOT IT")
                        .setTitleText("This is button 1")
                        .setContentText("Showcase with circle shape")
                        .withCircleShape()
                        .setShapePadding(20)
                        .setMaskColour(R.color.purple_500)
                        .build()
        );

        sequence.addSequenceItem(
                new MaterialShowcaseView.Builder(this)
                        .setDismissOnTouch(true)
                        .setDismissOnTargetTouch(true)
                        .setTarget(mButtonTwo)
                        .setSkipText("SKIP")
                        .setDismissText("GOT IT")
                        .setTitleText("This is button 2")
                        .setContentText("Showcase with oval shape")
                        .withOvalShape()
                        .setShapePadding(20)
                        .setMaskColour(R.color.purple_500)
                        .build()
        );

        sequence.addSequenceItem(
                new MaterialShowcaseView.Builder(this)
                        .setDismissOnTargetTouch(true)
                        .setDismissOnTouch(true)
                        .setTarget(mButtonThree)
                        .setSkipText("SKIP")
                        .setDismissText("GOT IT")
                        .setTitleText("This is button 3")
                        .setContentText("Showcase with rectangle shape")
                        .withRectangleShape()
                        .setShapePadding(20)
                        .setMaskColour(R.color.purple_500)
                        .build()
        );
        sequence.start();
    }

}