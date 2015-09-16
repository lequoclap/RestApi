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
        setDrawerHeaderImage(R.drawable.bg_2);
        setUsername("LapLQ");
        setUserEmail("quoclap.hedspi@gmail.com");
        setFirstAccountPhoto(getResources().getDrawable(R.drawable.user_buckaneer));


        // create sections
        this.addSection(newSection("Shop", new SettingFragment()));
        this.addSection(newSection("Album", new SettingFragment()));
        this.addSection(newSection("Picture", new SettingFragment()));
        this.addSection(newSection("Setting", new SettingFragment()));
        // create bottom section
        this.addBottomSection(newSection("Logout",R.drawable.ic_exit_to_app_black_24dp,new Intent(this,TrackListActivity.class)));


    }
}