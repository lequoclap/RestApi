package atinyshop.hacorp.laplq.restapi;

import android.content.Intent;
import android.os.Bundle;

import atinyshop.hacorp.laplq.restapi.activities.TrackListActivity;
import atinyshop.hacorp.laplq.restapi.fragments.SettingFragment;
import it.neokree.materialnavigationdrawer.MaterialNavigationDrawer;

/**
 * Created by laplq on 15/09/12.
 */

public class MyNavigationDrawer extends MaterialNavigationDrawer {

    @Override
    public void init(Bundle savedInstanceState) {

        // set header data
        setDrawerHeaderImage(R.drawable.earth);
        setUsername("My App Name");
        setUserEmail("My version build");
        //setFirstAccountPhoto(getResources().getDrawable(R.drawable.photo));

        // create sections
        this.addSection(newSection("Section 1", new SettingFragment()));
        this.addSection(newSection("Section 2", new SettingFragment()));

        // create bottom section
        this.addBottomSection(newSection("Bottom Section",R.drawable.action_search,new Intent(this,TrackListActivity.class)));


    }
}