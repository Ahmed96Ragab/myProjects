package com.cairoguide.ragab.cairoguide;

import android.content.Context;
import java.util.List;

public class Food {

    public static void initFoodsList( List<Location> list , Context context) {

        list.add(new Location(
                context.getString(R.string.food_Bab_name),
                context.getString(R.string.food_Bab_description),
                context.getString(R.string.food_Bab_address),
                context.getString(R.string.food_Bab_phone),
                context.getString(R.string.food_Bab_schedule),
                context.getString(R.string.food_Bab_two),
                R.drawable.food_bab
        ));

        list.add(new Location(
                context.getString(R.string.food_Fayruz_name),
                context.getString(R.string.food_Fayruz_description),
                context.getString(R.string.food_Fayruz_address),
                context.getString(R.string.food_Fayruz_phone),
                context.getString(R.string.food_Fayruz_schedule),
                context.getString(R.string.food_Fayruz_two),
                R.drawable.food_fayruz
        ));

        list.add(new Location(
                context.getString(R.string.food_Grill_name),
                context.getString(R.string.food_Grill_description),
                context.getString(R.string.food_Grill_address),
                context.getString(R.string.food_Grill_phone),
                context.getString(R.string.food_Grill_schedule),
                context.getString(R.string.food_Grill_four),
                R.drawable.food_grill
        ));

        list.add(new Location(
                context.getString(R.string.food_Indian_name),
                context.getString(R.string.food_Indian_description),
                context.getString(R.string.food_Indian_address),
                context.getString(R.string.food_Indian_phone),
                context.getString(R.string.food_Indian_schedule),
                context.getString(R.string.food_Indian_one),
                R.drawable.food_indian
        ));


    }
}
