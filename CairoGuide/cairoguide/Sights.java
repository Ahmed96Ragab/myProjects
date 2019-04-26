package com.cairoguide.ragab.cairoguide;

import android.content.Context;

import java.util.List;

/**
 * Created by lara on 28/8/16.
 */
public class Sights {

    public static void initSightsList(List<Location> list, Context context) {

        list.add(new Location(
                context.getString(R.string.sight_Pyramids_name),
                context.getString(R.string.sight_Pyramids_description),
                context.getString(R.string.sight_Pyramids_address),
                context.getString(R.string.sight_Pyramids_phone),
                context.getString(R.string.sight_Pyramids_schedule),
                context.getString(R.string.sight_Pyramids_price),
                R.drawable.sight_pyramids
        ));

        list.add(new Location(
                context.getString(R.string.sight_Mosque_name),
                context.getString(R.string.sight_Mosque_description),
                context.getString(R.string.sight_Mosque_address),
                context.getString(R.string.sight_Mosque_phone),
                context.getString(R.string.sight_Mosque_schedule),
                context.getString(R.string.sight_Mosque_price),
                R.drawable.sight_mosque
        ));

        list.add(new Location(
                context.getString(R.string.sight_Museum_name),
                context.getString(R.string.sight_Museum_description),
                context.getString(R.string.sight_Museum_address),
                context.getString(R.string.sight_Museum_phone),
                context.getString(R.string.sight_Museum_schedule),
                context.getString(R.string.sight_Museum_price),
                R.drawable.sight_museum
        ));

        list.add(new Location(
                context.getString(R.string.sight_Tower_name),
                context.getString(R.string.sight_Tower_description),
                context.getString(R.string.sight_Tower_address),
                context.getString(R.string.sight_Tower_phone),
                context.getString(R.string.sight_Tower_schedule),
                context.getString(R.string.sight_Tower_price),
                R.drawable.sight_tower
        ));

    }
}
