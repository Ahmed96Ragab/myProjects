package com.cairoguide.ragab.cairoguide;

import android.content.Context;

import java.util.List;

public class Host {
    public static void initHostList(List<Location> list , Context context) {

        list.add(new Location(
                context.getString(R.string.host_InterContinental_name),
                context.getString(R.string.host_InterContinental_description),
                context.getString(R.string.host_InterContinental_address),
                context.getString(R.string.host_InterContinental_phone),
                context.getString(R.string.host_InterContinental_schedule),
                context.getString(R.string.host_InterContinental_five),
                R.drawable.host_two
        ));


        list.add(new Location(
                context.getString(R.string.host_Kempinski_name),
                context.getString(R.string.host_Kempinski_description),
                context.getString(R.string.host_Kempinski_address),
                context.getString(R.string.host_Kempinski_phone),
                context.getString(R.string.host_Kempinski_schedule),
                context.getString(R.string.host_Kempinski_five),
                R.drawable.host_one
        ));

        list.add(new Location(
                context.getString(R.string.host_Meridien_name),
                context.getString(R.string.host_Meridien_description),
                context.getString(R.string.host_Meridien_address),
                context.getString(R.string.host_Meridien_phone),
                context.getString(R.string.host_Meridien_schedule),
                context.getString(R.string.host_Meridien_five),
                R.drawable.host_three
        ));

        list.add(new Location(
                context.getString(R.string.host_Conrad_name),
                context.getString(R.string.host_Conrad_description),
                context.getString(R.string.host_Conrad_address),
                context.getString(R.string.host_Conrad_phone),
                context.getString(R.string.host_Conrad_schedule),
                context.getString(R.string.host_Conrad_five),
                R.drawable.hosy_four
        ));


    }
}
